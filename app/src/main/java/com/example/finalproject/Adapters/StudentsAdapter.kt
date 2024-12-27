package com.example.finalproject.Adapters
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.example.finalproject.R
import com.example.finalproject.model.Student


class StudentsAdapter(private val students: MutableList<Student>?): BaseAdapter() {
    override fun getCount(): Int {
        return students?.size ?: 0
    }

    override fun getItem(position: Int): Any {
        return 0
    }

    override fun getItemId(position: Int): Long {
        return 0
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        if (convertView == null) {
            // Inflate the layout and set up the listener once
            view = LayoutInflater.from(parent?.context).inflate(R.layout.student_list_row, parent, false)
//        The setOnClickListener is only applied during view inflation (if (convertView == null)).
//        The listener references the tag property of the CheckBox.
//        The tag is updated on every call to getView, even for recycled views.
//        This ensures the CheckBox listener always operates on the correct position.
            val checkBox: CheckBox = view.findViewById(R.id.student_row_check_box)
            checkBox.setOnClickListener {
                // Use tag to determine the correct position dynamically
                val pos = checkBox.tag as Int
                val student = students?.get(pos)
                student?.isChecked = checkBox.isChecked
            }
        } else {
            view = convertView
        }

        // Get the current student
        val student = students?.get(position)
        // Access and bind views

        val nameTextView: TextView = view.findViewById(R.id.student_row_name_text_view)
        val idTextView: TextView = view.findViewById(R.id.student_row_id_text_view)
        val checkBox: CheckBox = view.findViewById(R.id.student_row_check_box)
        //These assignments ensure that the recycled view reflects the current item's data,
        // overriding anything from the previous item.
        nameTextView.text = student?.name
        idTextView.text = student?.id
        checkBox.isChecked = student?.isChecked ?: false

        // Update tag every time
        checkBox.tag = position

        return view
    }

}