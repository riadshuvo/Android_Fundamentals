package com.example.recyclerviewexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
class MainActivity : AppCompatActivity() {
    private val exampleList = generateDummyList(500)
    private val adapter = ExampleAdapter(exampleList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.setHasFixedSize(true)
    }
    fun insertItem(view: View) {
        val index = Random.nextInt(8)
        val newItem = ExampleItem(
            R.drawable.ic_android,
            "New item at position $index",
            "New Line $index"
        )
        exampleList.add(index, newItem)
        adapter.notifyItemInserted(index)
        Toast.makeText(this,"at position $index item has been added",Toast.LENGTH_SHORT).show()
    }
    fun removeItem(view: View) {
        val index = Random.nextInt(8)
        exampleList.removeAt(index)
        adapter.notifyItemRemoved(index)
        Toast.makeText(this,"at position $index item has been removed",Toast.LENGTH_SHORT).show()
    }
    private fun generateDummyList(size: Int): ArrayList<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        for (i in 1 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_android
                1 -> R.drawable.ic_cake
                else -> R.drawable.ic_brightness
            }
            val item = ExampleItem(drawable, "Item $i", "Line 2")
            list += item
        }
        return list
    }
}
