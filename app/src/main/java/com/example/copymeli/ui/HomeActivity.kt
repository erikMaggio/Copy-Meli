package com.example.copymeli.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.copymeli.R
import com.example.copymeli.databinding.ActivityHomeBinding
import com.example.copymeli.model.response.Product
import com.example.copymeli.ui.adapter.ProductAdapter
import com.example.copymeli.viewModel.ProductViewModel
import com.example.copymeli.viewModel.ViewModelFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductViewModel
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


    private fun observer() {
        viewModel.data.observe(this) {
            //aca va el recyclerView
        }
    }

    private fun action() {
        viewModel.getList()
    }


    private fun initRecyclerView(listProduct:List<Product>) {

        val adapter = ProductAdapter(listProduct)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

    }

    private fun getViewModel() {
        viewModel =
            ViewModelFactory().create(ProductViewModel::class.java)
    }
}
