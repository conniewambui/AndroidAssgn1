package com.example.myapplication


data class RegistrationResponse(
    @Student.SerializedName("message") var message: String,
    @Student.SerializedName("student") var student: Student
)