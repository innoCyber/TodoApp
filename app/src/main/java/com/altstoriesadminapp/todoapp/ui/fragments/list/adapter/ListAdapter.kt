package com.altstoriesadminapp.todoapp.ui.fragments.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.altstoriesadminapp.todoapp.R
import com.altstoriesadminapp.todoapp.data.entities.ToDoData

class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    var toDoDataItems = emptyList<ToDoData>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemView.tit
    }

    override fun getItemCount(): Int {
        return toDoDataItems.size
    }
}