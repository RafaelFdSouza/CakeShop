package com.rafaelsouza.cakeshop.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.rafaelsouza.cakeshop.databinding.ActivityProductDetailsBinding
import kotlinx.coroutines.flow.DEFAULT_CONCURRENCY_PROPERTY_NAME
import java.text.DecimalFormat


class ProductDetails : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding
    var amount = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val imgProduct = intent.extras!!.getInt("imageProduct")
        val nameProduct = intent.extras!!.getString("nameProduct")
        val priceProduct: Double = intent.extras!!.getString("priceProduct")!!.toDouble()
        var newPrice = priceProduct
        val decimalFormat = DecimalFormat.getCurrencyInstance()

        binding.cupcakeImage.setImageResource(imgProduct)
        binding.cupcakeSabor.text = "$nameProduct"
        binding.cupcakePreco.text = decimalFormat.format(priceProduct)

        binding.btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()

        }
        binding.btnAddCart.setOnClickListener {
            amount++
            binding.txtQuantidade.text = amount.toString()
            newPrice = priceProduct * amount
            binding.cupcakePreco.text = decimalFormat.format(newPrice)
        }
        binding.btnDecreaseCart.setOnClickListener {
            if (amount > 1) {
                amount--
                binding.txtQuantidade.text = amount.toString()
                newPrice = priceProduct * amount
            }
            binding.cupcakePreco.text = decimalFormat.format(newPrice)
        }
        binding.btnCorfirmar.setOnClickListener {
val intent = Intent(this, CartActivity::class.java)
            intent.putExtra("nameProduct", nameProduct)
            intent.putExtra("amount", amount)
            intent.putExtra("total", newPrice)
            startActivity(intent)
            finish()

        }
    }
}