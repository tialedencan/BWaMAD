package com.tia.orwma_lv5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.*
import java.lang.Math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

      /* val button = findViewById<Button>(R.id./button4)
        button.setOnClickListener {
            Toast.makeText(this,getString(R.string.app_name),Toast.LENGTH_LONG).show()
        }*/

        val textViewName=findViewById<TextView>(R.id.textViewName)
        val tvDescription=findViewById<TextView>(R.id.textViewDescription)
        var etName=findViewById<EditText>(R.id.editTextPersonName)
        var etDescription=findViewById<EditText>(R.id.editTextDescription)
        val button=findViewById<Button>(R.id.button)
       /* etName.setOnClickListener {
            etName.text.clear()
        }
        etDescription.setOnClickListener {
            etDescription.text.clear()
        }*/
        button.setOnClickListener {
            textViewName.text = etName.text
            tvDescription.text = etDescription.text
        }
        val btnCalculate=findViewById<Button>(R.id.buttonCalculate)

        btnCalculate.setOnClickListener {
            var weight=findViewById<EditText>(R.id.editTextWeight).text.toString()
            var height=findViewById<EditText>(R.id.editTextHeight).text.toString()
            var bmi=BMI(height,weight)
            Toast.makeText(this,bmi.calculateBMI().toString(),Toast.LENGTH_LONG).show()

        }

    }

}

    class BMI(var height: String, var weight: String){

        fun calculateBMI():Double{
            var h=height.toDouble()/100
            var w= weight.toDouble()
            return w/(h*h)
        }
    }
