package com.example.copymeli.model

import com.example.copymeli.model.response.Product
import com.example.copymeli.model.response.ProductList

interface Service {

    fun getList(): MutableList<Product>

    fun getProduct(): Product?
}
