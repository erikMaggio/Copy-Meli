package com.example.copymeli.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.copymeli.R
import com.example.copymeli.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
