package com.rafaelsouza.cakeshop.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rafaelsouza.cakeshop.adapter.ProductAdapter

import com.rafaelsouza.cakeshop.databinding.ActivityMainBinding
import com.rafaelsouza.cakeshop.listitems.Products
import com.rafaelsouza.cakeshop.model.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var productAdapter: ProductAdapter? = null
    private val products = Products()
    private val productList: MutableList<Product> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CoroutineScope(Dispatchers.IO).launch {
            products.getProducts().collectIndexed { index , value ->
                for (product in value) {
                    productList.add(product)

                }
            }
        }
        val recyclerViewProducts = binding.recyclerVCupTradicionais
        recyclerViewProducts.layoutManager = GridLayoutManager(this, 2)
        recyclerViewProducts.setHasFixedSize(true)
        this.productAdapter = ProductAdapter(this, productList)
        recyclerViewProducts.adapter = productAdapter

    }
}
