package com.gsixacademy.android.ninjaturtles.adapter

import com.gsixacademy.android.ninjaturtles.fragments.CaracterData

open class CaracterDataClickEvent {
    data class CaracterDataItemClicked(val caracterData:CaracterData?):CaracterDataClickEvent()

}
