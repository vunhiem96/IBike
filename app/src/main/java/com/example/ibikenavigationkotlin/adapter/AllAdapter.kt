package com.example.ibikenavigationkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.ibikenavigationkotlin.R
import com.example.ibikenavigationkotlin.model.ResultAll
import kotlinx.android.synthetic.main.item_bike.view.*

class AllAdapter( var context:Context, var data:ArrayList<ResultAll>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return  AllViewHolder(LayoutInflater.from(context).inflate(R.layout.item_bike, parent, false))
    }

    override fun getItemCount(): Int {
        return  data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var resultall : ResultAll = data[position]
        holder.itemView.tv_name.text = data[position].materialName
        holder.itemView.tv_gia.text = data[position].price.toString()
    }
    class AllViewHolder(v : View) : RecyclerView.ViewHolder(v){

    }
}