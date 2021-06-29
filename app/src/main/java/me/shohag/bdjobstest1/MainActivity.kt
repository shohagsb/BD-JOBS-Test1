package me.shohag.bdjobstest1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private val viewModel: JobsViewModel by lazy {
        ViewModelProvider(this).get(JobsViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.jobs.observe(this, { jobs ->
            Log.d("MainViewTag", "onCreate: $jobs")
        })
    }
}