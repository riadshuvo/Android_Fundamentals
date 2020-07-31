package com.example.android_permission

import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions


class MainActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    private val STORAGE_PERMISSION_CODE = 1
    private val Location_Foreground_PERMISSION_CODE = 2
    private val Location_Background_PERMISSION_CODE = 3
    private val CAMERA_PERMISSION_CODE = 4
    private val REQUEST_CALL_PERMISSION_CODE = 5

    var requestCode: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /**
         * @Button is requesting for getting Storage Permission
         */
        btnStorageRequest.setOnClickListener() {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this, "You have already granted this permission", Toast.LENGTH_SHORT)
                    .show()
            } else {
                requestStoragePermission()
            }
        }

        /**
         * @Button is requesting for getting Background Location Permission
         */
        btnBacLoc.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this, "You have already granted this permission", Toast.LENGTH_SHORT)
                    .show()
            } else {
                requestLocationBackgroundPermisison()
            }

        }

        /**
         * @Button is requesting for getting Foreground Location Permission
         */
        btnForLoc.setOnClickListener() {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                Toast.makeText(this, "You have already granted this permission", Toast.LENGTH_SHORT)
                    .show()
            } else {
                requestLocationForegroudPermission()
            }
        }


        /**
         * @Button is requesting for getting Opening Camera and Storage Permission at a same time by @EasyPermissions Libraries
         * By this Library we can get Multiple request at a same time only for one purpose
         *
         * YouTubeLink: https://www.youtube.com/watch?v=iHbdDAOJHIU
         */
        btnCamera.setOnClickListener() {
            openCamera()
        }

        /**
         * @Button is requesting for getting Phone Call Permission by EasyPermissions external Library
         */
        btnPhoneCall.setOnClickListener() {
            makePhoneCall()
        }


    }

    /**
     * @Function is requesting for getting Phone Call Permission by EasyPermissions external Library
     * By this EasyPermissions Library we can request @Multiple Request at a Time
     * To generate this operation Every Request must have to be granted by the Users
     * So this is the best way to request multiple user permission at once
     */

    @AfterPermissionGranted(5)
    private fun makePhoneCall() {
        val number = edit_text_number.text.toString()

        if (number.trim { it <= ' ' }.isNotEmpty()) {

            val perms = arrayOf(
                Manifest.permission.CALL_PHONE,
                Manifest.permission.READ_CONTACTS
            )
            if (EasyPermissions.hasPermissions(this, *perms)) {
                val dial = "tel:$number"
                startActivity(Intent(Intent.ACTION_CALL, Uri.parse(dial)))
            } else {
                EasyPermissions.requestPermissions(
                    this, "We need Call permissions because of this and that",
                    REQUEST_CALL_PERMISSION_CODE, *perms
                )
            }
        } else {
            Toast.makeText(this@MainActivity, "Enter Phone Number", Toast.LENGTH_SHORT).show()
        }
    }


    /**
     * @Function is requesting for Opening Camera and Storage Permission at a same time
     */
    @AfterPermissionGranted(4)
    private fun openCamera() {
        val perms = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE
        )
        if (EasyPermissions.hasPermissions(this, *perms)) {
            Toast.makeText(this, "Opening camera", Toast.LENGTH_SHORT).show()
        } else {
            EasyPermissions.requestPermissions(
                this, "We need Camera permissions because this and that",
                CAMERA_PERMISSION_CODE, *perms
            )
        }
    }


    /**
     * This @EasyPermissionsFunction will show @AlertDialog for go to phone Setting for allowing the permissions
     */
    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
            AppSettingsDialog.Builder(this).build().show()
        }
    }


    /**
     * This @EasyPermissionsFunction will shows us which requests are granted by users In LogCat So that Programmers can track the services
     */
    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {
        for (i in perms.indices) {
            //Toast.makeText(this, "${perms[i]} has been granted", Toast.LENGTH_SHORT).show()
            Log.d("PermissionGranted", "${perms[i]} has been granted")
        }
    }


    /**
     * @Function is requesting for getting Background Location Permission with @AlertDialog
     */
    private fun requestLocationBackgroundPermisison() {
        requestCode = Location_Background_PERMISSION_CODE

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        ) {
            AlertDialog.Builder(this)
                .setTitle("Permission needed")
                .setMessage("This BACKGROUND_LOCATION permission is needed because of this and that")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("ok") { dialog, which ->
                    ActivityCompat.requestPermissions(
                        this@MainActivity,
                        arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                        requestCode!!
                    )
                }
                .setNegativeButton("cancel") { dialog, which -> dialog.dismiss() }
                .setCancelable(false)
                .create()
                .show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_BACKGROUND_LOCATION),
                requestCode!!
            )
        }
    }

    /**
     * @Function is requesting for getting Foreground Location Permission with @AlertDialog
     */
    private fun requestLocationForegroudPermission() {
        requestCode = Location_Foreground_PERMISSION_CODE

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
        ) {
            AlertDialog.Builder(this)
                .setTitle("Permission needed")
                .setMessage("This COARSE_LOCATION permission is needed because of this and that")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("ok") { dialog, which ->
                    ActivityCompat.requestPermissions(
                        this@MainActivity,
                        arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                        requestCode!!
                    )
                }
                .setNegativeButton("cancel") { dialog, which -> dialog.dismiss() }
                .setCancelable(false)
                .create()
                .show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                requestCode!!
            )
        }

    }

    /**
     * @Function is requesting for getting Phone Storage Permission with @AlertDialog
     */
    private fun requestStoragePermission() {
        requestCode = STORAGE_PERMISSION_CODE

        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
        ) {
            AlertDialog.Builder(this)
                .setTitle("Permission needed")
                .setMessage("This EXTERNAL_STORAGE permission is needed because of this and that")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setPositiveButton("ok") { dialog, which ->
                    ActivityCompat.requestPermissions(
                        this@MainActivity,
                        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                        requestCode!!
                    )
                }
                .setNegativeButton("cancel") { dialog, which -> dialog.dismiss() }
                .setCancelable(false)
                .create()
                .show()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                requestCode!!
            )
        }
    }

    /**
     * @Function is need for Handling the all kinds of Requesting Permission
     */
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {

        //Handling for Multiple request by their RequestCode
        if (requestCode == this.requestCode) {
            for (i in grantResults.indices) {
                if (grantResults.isNotEmpty() && grantResults[i] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission GRANTED", Toast.LENGTH_SHORT).show()

                    Log.d("PermissionGranted", "${permissions[i]} is granted")
                } else {
                    Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show()
                }
            }

        }

        //Handling for Phone Call
        if (requestCode == REQUEST_CALL_PERMISSION_CODE) {
            EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
        }

        //Handling for Opening Camera
        if (requestCode == CAMERA_PERMISSION_CODE) {
            EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
        }


    }


}