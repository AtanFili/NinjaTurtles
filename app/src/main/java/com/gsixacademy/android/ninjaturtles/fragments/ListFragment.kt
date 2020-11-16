package com.gsixacademy.android.ninjaturtles.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsixacademy.android.ninjaturtles.MainActivity
import com.gsixacademy.android.ninjaturtles.R
import com.gsixacademy.android.ninjaturtles.adapter.CaracterAdapter
import com.gsixacademy.android.ninjaturtles.adapter.CaracterDataClickEvent
import kotlinx.android.synthetic.main.recycler_turtles.*
import kotlinx.android.synthetic.main.recycler_turtles.view.*
import kotlinx.android.synthetic.main.recycler_turtles.view.recycler_main

class ListFragment:Fragment() {
    var caracterList:CaracterModel?=null
    lateinit var caracterAdapter:CaracterAdapter
1


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recycler_turtles,container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initRecyclerView()
        val caracterSelected=arguments?.getString("caracterSelected")





    }
    private fun initRecyclerView(){
        val caracterModel=(activity as MainActivity).caracterModel


            caracterAdapter= CaracterAdapter(caracterModel?.caracter!!){
            if(it is CaracterDataClickEvent.CaracterDataItemClicked){
                var bundle=Bundle()

                bundle.putString("caracterImage",it.caracterData?.image)
                bundle.putString("carcaterFavoriteFood",it.caracterData?.favorite_food)
                bundle.putString("caracterWeapon",it.caracterData?.weapon)
                bundle.putString("caracterName",it.caracterData?.name)

                findNavController().navigate(R.id.action_listFragment_to_profileFragment,bundle)
            }
        }

        recycler_main.adapter=caracterAdapter



    }
}