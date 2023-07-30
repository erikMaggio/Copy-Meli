package com.example.copymeli.model.repository

import com.example.copymeli.model.Service
import com.example.copymeli.model.response.Product
import com.example.copymeli.model.response.ProductList
import com.example.copymeli.utils.Constants.PRODUCT

class ProductRepository : Service {

    private val productList = ProductList()
    private val product = PRODUCT

    override fun getList(): MutableList<Product> {
        return productList.list
    }

    override fun getProduct(): Product? {
        return product
    }
}
