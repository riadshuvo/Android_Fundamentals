package com.example.chekbox_radiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btOrder.setOnClickListener() {
            val chechMeatRadioButtonId = rgMeat.checkedRadioButtonId
            val selectedMeat = findViewById<RadioButton>(chechMeatRadioButtonId)
            val cheese = cbCheese.isChecked
            val onion = cbOnion.isChecked
            val salad = cbSalad.isChecked

            val orderString = "You have ordered a burger with:\n" +
                    "${selectedMeat.text}" +
                    (if (cheese) "\nCheese" else "") +
                    (if (salad) "\nSalad" else "") +
                    (if (onion) "\nOnion" else "")

            tvOrder.text = orderString
        }

    }
}