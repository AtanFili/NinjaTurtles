package com.gsixacademy.android.ninjaturtles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import com.gsixacademy.android.ninjaturtles.fragments.CaracterData
import com.gsixacademy.android.ninjaturtles.fragments.CaracterModel

class MainActivity : AppCompatActivity() {
lateinit var database:DatabaseReference
    var caracterModel:CaracterModel?= CaracterModel()

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            database=FirebaseDatabase.getInstance().reference

            initaliaseFireBaseDatabase()
    }

    private fun initaliaseFireBaseDatabase(){
        val postListener=object :ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                Log.d("error",error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                for (objSnapshot in snapshot.getChildren()){
                    val myClass=objSnapshot.getValue(CaracterData::class.java)
                    caracterModel?.caracter?.add(myClass)
                }
            }
        }
        database.addValueEventListener(postListener)
    }


}
