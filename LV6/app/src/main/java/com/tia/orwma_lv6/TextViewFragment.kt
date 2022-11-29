package com.tia.orwma_lv6

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction

class TextViewFragment : Fragment() {

    var displayMessage:String?=""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_text_view, container, false)
     /*   var tvAnswer=view.findViewById<TextView>(R.id.textViewAnswer)
        tvAnswer.text = arguments?.getString("BUTTON").toString()*/
        displayMessage=arguments?.getString("message")
        var tvAnswer=view.findViewById<TextView>(R.id.textViewAnswer)
        tvAnswer.text=displayMessage

        val btnBack=view.findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
           /* val fragmentManager=this.supportFragmentManager
            val fragmentTransaction=fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragmentContainer,fragment)
            fragmentTransaction.commit()*/
            val rgFragment=RadioGroupFragment()
            val fragmentTransaction: FragmentTransaction? = activity?.supportFragmentManager?.beginTransaction()
            fragmentTransaction?.replace(R.id.fragmentContainer, rgFragment)
            fragmentTransaction?.commit()
        }

        return view
    }

}