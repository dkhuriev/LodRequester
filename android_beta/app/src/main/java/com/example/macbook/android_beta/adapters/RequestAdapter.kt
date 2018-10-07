package com.example.macbook.android_beta

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class RequestAdapter (private val arrWithInf: List<MainActivity.RequestModel>): RecyclerView.Adapter<RequestAdapter.ViewHolder>(){
    override fun getItemCount() = arrWithInf.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text = arrWithInf[position].name
        holder.tvDescription.text = arrWithInf[position].description
        holder.tvDorm.text = arrWithInf[position].dormName
        holder.tvTags.text = arrWithInf[position].tags.toString()
        holder.tvPrice.text = arrWithInf[position].price



    }
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.tv_name
        val tvDescription: TextView = itemView.tv_description
        val tvDorm: TextView = itemView.tv_dorm
        val tvTags: TextView = itemView.tv_tags
        val tvPrice: TextView = itemView.tv_price
    }

}