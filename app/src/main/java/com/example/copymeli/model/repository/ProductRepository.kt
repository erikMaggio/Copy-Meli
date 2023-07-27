package com.example.copymeli.model.repository

import com.example.copymeli.model.Service
import com.example.copymeli.model.response.Product
import com.example.copymeli.model.response.ProductList

class ProductRepository : Service {

    private val productList = ProductList()

    override fun getList(): MutableList<Product> {
        return productList.list
    }
}