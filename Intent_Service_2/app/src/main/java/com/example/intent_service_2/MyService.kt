package com.example.intent_service_2

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    val TAG = "MyServices"

    init {
        Log.d(TAG,"Service is running...")
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val dataString = intent?.getStringExtra("EXTRA_DATA")
        dataString?.let {
            Log.d(TAG, dataString)
        }

        /**
         * If Android System Kills Your Service Then It Won't Recreate It If It Has Reach Others Again
         */
        // return START_NOT_STICKY

        /**
         * If Android System Kills Your Service Then It Will Recreate It When Possible
         * And The Last Intent Pass To This On Start Command Function Won't Be Redeliver To This Service Class
         */
        return START_STICKY

        /**
         * If Android System Kills Your Service Then It Will Recreate It When Possible
         * And The Last Intent Pass To This On Start Command Function Will Be Redeliver To This Service Class
         */
        //return START_REDELIVER_INTENT

    }

    override fun onDestroy() {
        Log.d(TAG,"Service is being killed...")
        super.onDestroy()
    }

}