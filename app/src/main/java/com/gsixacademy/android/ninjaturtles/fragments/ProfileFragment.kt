package com.gsixacademy.android.ninjaturtles.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gsixacademy.android.ninjaturtles.MainActivity
import com.gsixacademy.android.ninjaturtles.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment:Fragment() {

    var caracterList:CaracterModel?=null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile,container,false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        caracterList=(activity as MainActivity).caracterModel
        val caracterImage=arguments?.getString("caracterImage")?:""
        val carcaterFavoriteFood=arguments?.getString("carcaterFavoriteFood")?:""
        val caracterWeapon=arguments?.getString("caracterWeapon")?:""
        val caracterName=arguments?.getString("caracterName")?:""

        profile_ninja_name.text=caracterName
        profile_ninja_name.isAllCaps=true
        Picasso.get().load(caracterImage).into(profile_Ninja_image)
        insert_weapon.text=caracterWeapon
        insert_food.text=carcaterFavoriteFood




    }
}