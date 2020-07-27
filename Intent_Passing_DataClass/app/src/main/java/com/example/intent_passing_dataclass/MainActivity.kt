package com.example.intent_passing_dataclass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_Apply.setOnClickListener{

            val id = txt_id.text.toString().toInt()
            val name = txt_name.text.toString()
            val email = txt_email.text.toString()
            val person = Person(id, name, email)

            Intent(applicationContext, SecondActivity::class.java).also {intent ->
                intent.putExtra("key",person)
                startActivity(intent)
            }
        }
    }
}