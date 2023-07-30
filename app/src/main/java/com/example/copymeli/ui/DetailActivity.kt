package com.example.copymeli.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.copymeli.databinding.ActivityDetailBinding
import com.example.copymeli.utils.Constants.PRODUCT
import com.example.copymeli.viewModel.ProductViewModel
import com.example.copymeli.viewModel.ViewModelFactory
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: ProductViewModel
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        getViewModel()
        action()
        observer()

    }

    private fun observer() {
        viewModel.value.observe(this) {
            binding.tvName.text = it?.name
            binding.tvDescription.text = it?.description
            Picasso.get().load(it?.url).into(binding.ivImage)
            binding.tvPriceValue.text = it?.price.toString()
            binding.tvPriceOffer.text = it?.offersPrice.toString()
            binding.tvSellAmount.text = it?.sold.toString()
            binding.tvStarValue.text = it?.punctuation.toString()
            binding.tvPriceSend.text = it?.sendPrice.toString()

        }
    }

    private fun action() {
        PRODUCT?.let { viewModel.getProduct() }
    }

    private fun getViewModel() {
        viewModel =
            ViewModelFactory().create(ProductViewModel::class.java)
    }
}
