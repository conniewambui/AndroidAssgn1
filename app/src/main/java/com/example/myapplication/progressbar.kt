package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_progressbar.*

class progressbar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progressbar)

                val btnStartProgress = this.button2
                val progressBar: ProgressBar = this.progressBar


                btnStartProgress.setOnClickListener { y ->


                    Thread(Runnable {


                        this@progressbar.runOnUiThread(java.lang.Runnable {
                            progressBar.visibility = View.VISIBLE
                        })

                        try {
                            var y = 0;
                            while (y < Int.MAX_VALUE) {
                                y++
                            }
                        } catch (e: InterruptedException) {
                            e.printStackTrace()
                        }


                        this@progressbar.runOnUiThread(java.lang.Runnable {
                            progressBar.visibility = View.GONE
                        })
                    }).start()
                }
            }
        }


