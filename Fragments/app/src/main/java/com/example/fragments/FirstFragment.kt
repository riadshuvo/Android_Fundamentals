package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fragment2 = SecondFragment()

        var bundle : Bundle = Bundle()

        btn_apply.setOnClickListener{

            bundle.putString("fname",txt_firstName.text.toString())
            bundle.putString("lname", txt_lastName.text.toString())
            bundle.putString("country",txt_country.text.toString())
            bundle.putString("bday",txt_birthdate.text.toString())

            fragment2.arguments = bundle

            val namager = fragmentManager
            val fragmentTransaction = namager?.beginTransaction()

            fragmentTransaction?.replace(R.id.flFragment,fragment2)
            fragmentTransaction?.commit()

        }

    }


}