package com.example.finalproject.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.Adapters.StudentsViewHolder
import com.example.finalproject.R
import com.example.finalproject.model.Student

class StudentsRecyclerAdapter(private val students: MutableList<Student>): RecyclerView.Adapter<StudentsViewHolder>(){
    // Called when RecyclerView needs a new ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsViewHolder {
        val view: View = LayoutInflater.from(parent?.context).inflate(R.layout.student_list_row, parent, false)
        return StudentsViewHolder(view)
    }
    // Called to display the data at the specified position
    override fun onBindViewHolder(holder: StudentsViewHolder, position: Int) {
        holder.bind(students.get(position), position)
    }

    override fun getItemCount(): Int {
        return students.size
    }

}