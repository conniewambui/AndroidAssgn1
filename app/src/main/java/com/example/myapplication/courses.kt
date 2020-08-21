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

        fetchCoursess()
    }

    fun fetchCoursess() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient = ApiClient.buildService(ApiInterface::class.java)
        val coursessCall = apiClient.getCourses("Bearer " + accessToken)
        coursessCall.enqueue(object: Callback<CoursesResponse> {
            override fun onFailure(call:Call<CoursesResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(
                call: Call<Coursess>,
                response: Response<Coursess>
            ) {
                if (response.isSuccessful) {
                    var coursessList = response.body()?.courses as List<Coursess>
                    var coursesAdapter = coursesRecyclerViewAdapter(coursessList)
                    rvCourses.layoutManager = LinearLayoutManager(baseContext)
                    rvCourses.adapter = coursesAdapter
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }
}