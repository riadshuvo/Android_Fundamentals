package com.example.swipe_page_viewpager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val images = listOf(
            R.drawable.shuvo1,
            R.drawable.shuvo2,
            R.drawable.shuvo3,
            R.drawable.shuvo4,
            R.drawable.shuvo5,
            R.drawable.shuvo6
        )

        val adapter = ViewPagerAdapter(images)
        viewPager.adapter = adapter
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //Scroll Images vartically
        //viewPager.orientation = ViewPager2.ORIENTATION_VERTICAL


    }
}