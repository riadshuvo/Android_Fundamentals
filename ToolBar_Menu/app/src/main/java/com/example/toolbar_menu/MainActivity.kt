package com.example.toolbar_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_manu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.miSettings -> Toast.makeText(this,"You clicked on Settings",Toast.LENGTH_SHORT).show()
            R.id.miAddContacts -> Toast.makeText(this,"You clicked on Add Contacts",Toast.LENGTH_SHORT).show()
            R.id.miFavorite -> Toast.makeText(this,"You clicked on Favorite",Toast.LENGTH_SHORT).show()
            R.id.miFeedback -> Toast.makeText(this,"You clicked on Give Feedback",Toast.LENGTH_SHORT).show()
            R.id.miClose -> finish()
        }
        return true
    }

}