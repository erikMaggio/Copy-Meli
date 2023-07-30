package com.example.copymeli.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.copymeli.databinding.ActivityHomeBinding
import com.example.copymeli.model.response.Product
import com.example.copymeli.ui.adapter.ProductAdapter
import com.example.copymeli.utils.Constants.PRODUCT
import com.example.copymeli.viewModel.ProductViewModel
import com.example.copymeli.viewModel.ViewModelFactory

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductViewModel
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getViewModel()
        observer()
        action()
    }

    private fun observer() {
        viewModel.data.observe(this) {
            initRecyclerView(it)
        }
    }

    private fun action() {
        viewModel.getList()
    }


    private fun initRecyclerView(listProduct: List<Product>) {

        val adapter = ProductAdapter(listProduct, onClick = { goToDetails.invoke(it) })
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvHomeProduct.layoutManager = layoutManager
        binding.rvHomeProduct.adapter = adapter

    }

    private fun getViewModel() {
        viewModel =
            ViewModelFactory().create(ProductViewModel::class.java)
    }

    private val goToDetails = fun(item: Product) {
        val intent = Intent(this, DetailActivity::class.java)
        PRODUCT = item
        startActivity(intent)
    }
}
