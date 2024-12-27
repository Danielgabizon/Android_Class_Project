package com.example.finalproject.Adapters

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.model.Student

class StudentsViewHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    // Row properties
    private val nameTextView: TextView = itemView.findViewById(R.id.student_row_name_text_view)
    private val idTextView: TextView = itemView.findViewById(R.id.student_row_id_text_view)
    private val studentCheckBox: CheckBox = itemView.findViewById(R.id.student_row_check_box)

    private var student: Student? = null

    init {
        studentCheckBox.setOnClickListener {
            // Use tag to determine the correct position dynamically
            student?.isChecked = studentCheckBox.isChecked
        }
    }

    fun bind(student: Student?, position: Int) {
        this.student = student
        nameTextView.text = student?.name
        idTextView.text = student?.id
        studentCheckBox.isChecked = student?.isChecked ?: false
    }
}