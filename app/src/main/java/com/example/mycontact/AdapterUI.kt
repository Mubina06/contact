package com.example.mycontact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterUI(val listcontact: MutableList<contacts>): RecyclerView.Adapter<AdapterUI.MyHolder>() {

    var onItemClick : ((contacts) -> Unit)? = null
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        var contact: TextView = itemView.findViewById<TextView>(R.id.textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterUI.MyHolder {
        var itemView = MyHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false))
        return itemView
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var item = listcontact[position]
        holder.contact.text = item.name

        holder.itemView.setOnClickListener{
            onItemClick?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return listcontact.size
    }

}