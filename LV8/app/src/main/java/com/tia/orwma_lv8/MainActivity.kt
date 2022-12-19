package com.tia.orwma_lv8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(),PersonRecyclerAdapter.ContentListener {

    private lateinit var recyclerAdapter: PersonRecyclerAdapter
    private val db=Firebase.firestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.personList)
        db.collection("persons")
            .get()
            .addOnSuccessListener { result ->
                val personList=ArrayList<Person>()
                for(data in result.documents){
                    val person=data.toObject(Person::class.java)
                    if(person != null){
                        person.id=data.id
                        personList.add(person)
                    }
                }
                recyclerAdapter = PersonRecyclerAdapter(personList, this@MainActivity)
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = recyclerAdapter
                }
            }
            .addOnFailureListener { exception ->
                Log.e("MainActivity", "Error getting documents.", exception)
            }


        val image=findViewById<EditText>(R.id.etImage)
        val name=findViewById<EditText>(R.id.personName)
        val description=findViewById<EditText>(R.id.etDescription)

        val btnSave=findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener{

            /*val user = hashMapOf(
                "imageUrl" to image.text,
                "name" to name.text,
                "description" to description.text
            )*/
            val user=Person(
                image.text.toString(),
                name.text.toString(),
                description.text.toString(),
                "1",
            )
            val doc=db.collection("persons").document()
            doc.set(user).addOnSuccessListener {
                user.id=doc.id
                recyclerAdapter.addItem(user)
            }

        }

    }

    override fun onItemButtonClick(index: Int, person: Person, clickType: ItemClickType) {
        if (clickType == ItemClickType.EDIT) {
            db.collection("persons")
                .document(person.id)
                .set(person)
        } else if (clickType == ItemClickType.REMOVE) {
            recyclerAdapter.removeItem(index)
            db.collection("persons")
                .document(person.id)
                .delete()
        }
    }
}


