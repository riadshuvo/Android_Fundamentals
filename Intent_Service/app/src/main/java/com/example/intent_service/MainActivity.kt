package com.example.intent_service

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnStart.setOnClickListener(){
            Intent(this, MyIntenServices::class.java).also {
                startService(it)
                txtServiceInfo.text = "Service is running"
            }
        }

        btnStop.setOnClickListener(){
            MyIntenServices.stopService()
            txtServiceInfo.text = "Service stopped"
        }

    }
}