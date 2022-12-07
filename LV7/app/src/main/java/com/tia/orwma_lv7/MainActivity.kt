package com.tia.orwma_lv7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnSearch = findViewById<Button>(R.id.btnSearch)
        btnSearch.setOnClickListener {
            val etBrandName = findViewById<EditText>(R.id.etSearch)
            val brand=etBrandName.text.toString()
            val request = ServiceBuilder.buildService(MakeupEndpoints::class.java)
            val call = request.getMakeup(brand)

            call.enqueue(object : Callback<ArrayList<Makeup>> {
                override fun onResponse(
                    call: Call<ArrayList<Makeup>>,
                    response: Response<ArrayList<Makeup>>
                ) {
                    if (response.isSuccessful) {
                        findViewById<RecyclerView>(R.id.makeupList).apply {
                            layoutManager = LinearLayoutManager(this@MainActivity)
                            adapter = MakeupRecyclerAdapter(response.body()!!)

                        }
                    }
                }

                override fun onFailure(call: Call<ArrayList<Makeup>>, t: Throwable) {
                    Log.d(
                        "FAIL", t.message.toString()
                    )
                }
            })

        }
    }
}

