package com.example.fragments

import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var bundle = this.arguments

        var firstName  = "First Name: ${bundle?.getString("fname")}"
        var lastName  = "Last Name: ${bundle?.getString("lname")}"
        var country  = "Country: ${bundle?.getString("country")}"
        var bDay  = "Date of Birth: ${bundle?.getString("bday")}"

        txt_fName.text = firstName
        txt_lName.text = lastName
        txt_cntry.text = country
        txt_bDate.text = bDay
    }


}