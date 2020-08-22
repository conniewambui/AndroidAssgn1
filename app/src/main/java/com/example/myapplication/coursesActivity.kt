package com.example.myapplication

import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_courses.*
import okhttp3.Callback
import retrofit2.Call
import retrofit2.Response


class CoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
        var courseList = listOf<Coursess>(
            Coursess("1", "Python", "BB 2", "James Mwai", "Django"),
            Coursess("2", "Kotlin", "BB 3", "John Owuor", "Android development training"),
            Coursess("3", "Javascript", "BB 4", "Purity Maina", "React"),
            Coursess("4", "Entrepreneurship", "BB 5", "Kelly Gatweri", "Business ideas and development")
        )
        rvCourses.layoutManager = LinearLayoutManager(baseContext)
        rvCourses.adapter = coursesRecyclerViewAdapter(courseList)


        fetchCoursess()
    }

        fun fetchCoursess() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val coursessCall = apiClient.getCourses("Bearer " + accessToken)
        coursessCall.enqueue(object : Call<Coursess>{
            override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<CoursesResponse>,
                response: Response<CoursesResponse>
            ) {
                if (response.isSuccessful) {
                    var courseList = response.body()?.courses as List<Coursess>
                    var coursesAdapter = coursesRecyclerViewAdapter(courseList)
                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    rvCourses.adapter = coursesAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }

            override fun enqueue(callback: retrofit2.Callback<Coursess>) {
                TODO("Not yet implemented")
            }
        })
    }
}

