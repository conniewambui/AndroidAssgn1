package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_courses.view.*
import kotlinx.android.synthetic.main.row_course_item.view.*

class coursesRecyclerViewAdapter(val coursesList: List<Coursess>) :
    RecyclerView.Adapter<coursesRecyclerViewAdapter.NamesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NamesViewHolder{
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_course_item, parent, false)
        return NamesViewHolder(itemView)
    }
    override fun getItemCount(): Int {
        return coursesList.size
    }
    override fun onBindViewHolder(holder: NamesViewHolder, position: Int) {
        holder.rowView.courseName.text= coursesList[position].toString()
    }
    
    class NamesViewHolder(val rowView: View) : RecyclerView.ViewHolder(rowView)
}



