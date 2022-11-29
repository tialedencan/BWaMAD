package com.tia.orwma_lv6

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment

class RadioGroupFragment : Fragment() {

    private lateinit var communicator: Communicator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       /* val tvFragment = TextViewFragment()
        val bundle = Bundle()
        val view = inflater.inflate(R.layout.fragment_radio_group, container, false)
        val radioButton=view.findViewById<RadioButton>(R.id.radioGroup)

        bundle.putString("BUTTON", radioButton.text.toString())
        tvFragment.arguments = bundle
        val fragmentTransaction: FragmentTransaction? =
            activity?.supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragmentContainer, tvFragment) //mainFragment
        fragmentTransaction?.commit()*/
        val view = inflater.inflate(R.layout.fragment_radio_group, container, false)

        communicator=activity as Communicator
        var btnForward=view.findViewById<Button>(R.id.btnForward)
        btnForward.setOnClickListener {

            var radioGroup=view.findViewById<RadioGroup>(R.id.radioGroup)
            // get selected radio button from radioGroup
            val selectedId: Int = radioGroup.getCheckedRadioButtonId()
            // find the radiobutton by returned id
            var radioButton = view.findViewById(selectedId) as RadioButton

            communicator.passDataCom(radioButton.text.toString())
        }

        return view
    }
}




