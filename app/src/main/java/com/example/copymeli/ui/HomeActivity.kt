package com.example.copymeli.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import androidx.appcompat.widget.SearchView
import com.example.copymeli.R
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

        binding.swDarkMode.setOnCheckedChangeListener{_, isSelected ->
            if (isSelected){
                enabeDarkMode()
            }else{
                disableDarkMode()
            }
        }

        getViewModel()
        observer()
        action()

    }
    private fun mySearch(listProduct: List<Product>){
        binding.svHomeSearchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                val secondaryList = mutableListOf<Product>()
                listProduct.forEach{
                    if (it.name.toLowerCase().contains(newText!!.toLowerCase())){
                        secondaryList.add(it)
                    }
                }
                if(secondaryList.isNotEmpty()){
                    initRecyclerView(secondaryList)
                    binding.errorView.root.visibility = View.GONE
                }else{
                    binding.errorView.root.visibility = View.VISIBLE
                }

                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {

                return false
            }
        })
    }
    private fun enabeDarkMode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
        delegate.applyDayNight()
    }

    private fun disableDarkMode(){
        AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
        delegate.applyDayNight()

    }

    private fun observer() {
        viewModel.data.observe(this) {
            initRecyclerView(it)
            mySearch(it)
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
