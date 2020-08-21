package com.example.myapplication
import com.google.gson.annotations.SerializedName



data class LoginResponse(
    @Student.SerializedName("access_token") var access: String,
    @Student.SerializedName("message") var message: String
)
