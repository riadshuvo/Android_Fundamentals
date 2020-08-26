 package com.example.shared_prefereces

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        btnSave.setOnClickListener(){
            val name = txtName.text.toString()
            val age = txtAge.text.toString().toInt()
            val isAdult = checkBox.isChecked

            editor.apply{
                putString("name",name)
                putInt("age",age)
                putBoolean("isAdult",isAdult)
                apply()
            }
        }

        btnLoad.setOnClickListener(){
            val name = sharedPref.getString("name",null)
            val age = sharedPref.getInt("age",0)
            val isAdult = sharedPref.getBoolean("isAdult",false)

            shrName.text = "Name: $name"
            shrAge.text = "Age: ${age.toString()}"
            if(isAdult){
                shrAdult.text = "Adultery: $name is Adult"
            }else{
                shrAdult.text = "Adultery: $name is not Adult"
            }

        }

    }
}