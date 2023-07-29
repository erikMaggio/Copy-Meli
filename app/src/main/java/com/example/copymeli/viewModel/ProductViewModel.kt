package com.example.copymeli.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.copymeli.model.repository.ProductRepository
import com.example.copymeli.model.response.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    private val repositoryProduct = ProductRepository()
    val data = MutableLiveData<MutableList<Product>>()

    fun getList() {
        CoroutineScope(Dispatchers.IO).launch {
            val call = repositoryProduct.getList()
            data.postValue(call)
        }
    }
}