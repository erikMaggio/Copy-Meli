package com.example.copymeli.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.copymeli.R
import com.example.copymeli.databinding.ActivityMainBinding
import com.example.copymeli.viewModel.ProductViewModel
import com.example.copymeli.viewModel.ViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        action()
        observer()
        getViewModel()
    }

    private fun observer() {
        viewModel.data.observe(this) {
            //aca va el recyclerView
        }
    }

    private fun action() {
        viewModel.getList()
    }

    private fun getViewModel() {
        viewModel =
            ViewModelFactory().create(ProductViewModel::class.java)
    }
}