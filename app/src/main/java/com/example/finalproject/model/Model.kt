package com.example.finalproject.model


class Model private constructor() // Primary constructor is private
{
    val students: MutableList<Student> = ArrayList() // Setting Property for students
    companion object {
        // When writing Model.shared for the first time, the primary Model() constructor is called
        // which takes no arguments. then, init block is called which
        // initializes the students list with 20 students.
        // when the Model.shared is called for the second time, the same instance is returned (no constructor is called)
        var shared = Model()
    }
    init {
        for(i in 1..20)
        {
            val student = Student("Name:  $i", "ID: $i", "", false)
            students.add(student)
        }
    }
}