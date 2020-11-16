package com.gsixacademy.android.ninjaturtles.fragments

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class CaracterData( ):Parcelable{
    var favorite_food:String?=null
    var image:String?=null
    var name:String?=null
    var weapon:String?=null


    constructor(parcel:Parcel):this(){
        favorite_food=parcel.readString()
        image=parcel.readString()
        name=parcel.readString()
        weapon=parcel.readString()


    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(favorite_food)
        parcel.writeString(name)
        parcel.writeString(weapon)


    }

    override fun describeContents(): Int {
        return 0
    }
 companion object CREATOR:Parcelable.Creator<CaracterData>{
     override fun createFromParcel(parcel: Parcel): CaracterData {
         return CaracterData(parcel)
     }

     override fun newArray(size: Int): Array<CaracterData?> {
         return arrayOfNulls(size)
     }
 }
}





