package com.example.androidtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bindind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindind.root)

       bindind.button.setOnClickListener {
               bindind.button.text = getString(R.string.secondtext)
       }

    }
}