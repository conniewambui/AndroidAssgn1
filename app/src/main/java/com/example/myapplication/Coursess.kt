package com.example.myapplication
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity(tableName = "Coursess")

data class Coursess(
        @SerializedName("course_id") var courseId: String,
        @SerializedName("course_name") var courseName: String,
        @SerializedName("course_code") var courseCode: String,
        @SerializedName("instructor") var instructor: String,
        @SerializedName("description") var description: String
)
