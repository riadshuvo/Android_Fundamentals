package com.example.intent_service

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntenServices : IntentService("MyIntentServices") {

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntenServices
        var isRunnig = false
        
        fun stopService() {
            Log.d("MyIntentService", "Service is stopping...")
            isRunnig = false
            instance.stopSelf()  //this stopSelf() will stop the background services
        }
    }

    override fun onHandleIntent(p0: Intent?) {

        try {
            isRunnig = true
            while (isRunnig) {
                Log.d("MyIntentService", "Service is running...")
                Thread.sleep(1000)
            }
        } catch (e: InterruptedException) {
            Thread.currentThread().interrupt()
        }

    }
}