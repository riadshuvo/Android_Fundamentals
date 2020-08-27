package com.example.broadcast_receivers

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlaneModeChangeReceiver: BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {

        val isAirPlaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if(isAirPlaneModeEnabled){
            Toast.makeText(context,"Airplane Mode is Enabled",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(context,"Airplane Mode is Disabled",Toast.LENGTH_SHORT).show()
        }
    }

}