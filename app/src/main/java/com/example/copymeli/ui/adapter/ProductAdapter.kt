package com.example.copymeli.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.copymeli.R
import com.example.copymeli.databinding.ItemRvProductBinding
import com.example.copymeli.model.response.Product
import com.squareup.picasso.Picasso

class ProductAdapter(
    private val productList: List<Product>,
    private val onClick: (Product) -> Unit
) :
    RecyclerView.Adapter<ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_product, parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.render(productList[position], onClick)
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}

class ProductHolder(view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemRvProductBinding.bind(view)

    fun render(product: Product, onClick: (Product) -> Unit) {
        binding.textTitle.text = product.name
        Picasso.get().load(product.url).into(binding.imageProduct)
        binding.textDescription.text = product.description
        binding.textPrice.text = product.price.toString()

        binding.root.setOnClickListener {
            onClick(product)
        }
    }
}
