package com.rafaelsouza.cakeshop.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rafaelsouza.cakeshop.activity.ProductDetails
import com.rafaelsouza.cakeshop.databinding.ProductItemBinding
import com.rafaelsouza.cakeshop.model.Product


class ProductAdapter(context: Context, private val productList: MutableList<Product>) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val imageProduct = binding.imgProduct
        val nameProduct = binding.txtNameProduct
        val priceProduct = binding.txtPriceProduct
        val btnAdd = binding.btnAdd

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val listItem =
            ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(listItem)
    }

    override fun getItemCount(): Int = productList.size

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.imageProduct.setImageResource(productList[position].imageProduct)
        holder.nameProduct.text = productList[position].nameProduct
        holder.priceProduct.text = productList[position].priceProduct

        //Event Click
        holder.btnAdd.setOnClickListener {it: View ->
            val intent = Intent(it.context, ProductDetails::class.java)
           intent.putExtra("imageProduct", productList[position].imageProduct)
            intent.putExtra("nameProduct", productList[position].nameProduct)
            intent.putExtra("priceProduct", productList[position].priceProduct)
            it.context.startActivity(intent)

        }

    }

}