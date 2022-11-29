package com.tia.orwma_lv6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment


class MainActivity : AppCompatActivity(),Communicator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1=RadioGroupFragment()
        replaceFragment(fragment1)



    }

    private fun replaceFragment(fragment:Fragment){

        val fragmentManager=supportFragmentManager
        val fragmentTransaction=fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }

    override fun passDataCom(textInput: String) {
        var bundle=Bundle()
        bundle.putString("message",textInput)

        val transaction=this.supportFragmentManager.beginTransaction()
        val fragment2=TextViewFragment()
        fragment2.arguments=bundle

        transaction.replace(R.id.fragmentContainer,fragment2)
        transaction.commit()
    }
}