package com.gsixacademy.android.ninjaturtles.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gsixacademy.android.ninjaturtles.R
import com.gsixacademy.android.ninjaturtles.fragments.CaracterData
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_list.view.*

class CaracterAdapter(
    val caracterDatas: ArrayList<CaracterData?>,
    val caracterDatasClickEvent: (CaracterDataClickEvent.CaracterDataItemClicked) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>

    () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.fragment_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return caracterDatas.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var myViewHolder = holder as MyViewHolder
        myViewHolder.bindData(caracterDatas[position], position)
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(caracterData: CaracterData?, position: Int) {


            itemView.turtle_name_tv.text = caracterData?.name
            itemView.turtle_name_tv.isAllCaps=true
            Picasso.get().load(caracterData?.image).fit().into(itemView.ninjaTurtle_iv)
            itemView.fragmentList_layout.setOnClickListener {
                caracterDatasClickEvent.invoke(
                    CaracterDataClickEvent.CaracterDataItemClicked(
                        caracterData
                    )
                )
            }


        }


    }


}