package com.rafaelsouza.cakeshop.listitems


import com.rafaelsouza.cakeshop.model.Product
import com.rafaelsouza.cakeshop.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Products {
    private val _productList = MutableStateFlow<MutableList<Product>>(mutableListOf())
    private val productListFlow: StateFlow<MutableList<Product>> = _productList

    fun getProducts(): Flow<MutableList<Product>> {
        val productList: MutableList<Product> = mutableListOf(
            Product(
                imageProduct = R.drawable.chocolate,
                nameProduct = "Cupcake de Chocolate",
                priceProduct = "5.00"
            ),

            Product(
                imageProduct = R.drawable.pacoca,
                nameProduct = "Cupcake de Paçoca",
                priceProduct = "5.50"
            ),
            Product(
                imageProduct = R.drawable.baunilha,
                nameProduct = "Cupcake de Baunilha",
                priceProduct = "5.00"
            ),
            Product(
                imageProduct = R.drawable.lemon,
                nameProduct = "Cupcake de Limão",
                priceProduct = "6.00"

            ),
            Product(
                imageProduct = R.drawable.morango,
                nameProduct = "Cupcake de Morango",
                priceProduct = "5.00"
            ),
            Product(
                imageProduct = R.drawable.redvelvet,
                nameProduct = "Especial Red Velvet",
                priceProduct = "6.00"
            )
        )
        _productList.value = productList
        return productListFlow

    }
}