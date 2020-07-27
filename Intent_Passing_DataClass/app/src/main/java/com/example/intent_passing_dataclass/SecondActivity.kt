package com.example.intent_passing_dataclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val getData = intent.getSerializableExtra("key") as Person

        txt_pId.text = getData.id.toString()
        txt_pName.text = getData.name
        txt_pEmail.text = getData.email

        btn_back.setOnClickListener(){
            finish()
        }

    }
}