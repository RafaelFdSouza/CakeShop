package com.rafaelsouza.cakeshop.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.rafaelsouza.cakeshop.R
import com.rafaelsouza.cakeshop.databinding.ActivityCartBinding
import java.text.DecimalFormat

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

binding.back.setOnClickListener {
    val intent = Intent(this, MainActivity::class.java)
    startActivity(intent)


}
        val name = intent.extras!!.getString("nameProduct")
        val amount = intent.extras!!.getInt("amount")
        val total = intent.extras!!.getDouble("total")
        val decimalFormat = DecimalFormat.getCurrencyInstance()
        binding.tvTotal.text =
            "$name \nQuantidade: $amount \nTotal: ${decimalFormat.format(total)}"
        binding.btnPagar.setOnClickListener {
            if (binding.btnCreditCard.isChecked || binding.btnPix.isChecked) {
                Toast.makeText(this, "Pagamento aprovado", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Selecione uma forma de pagamento", Toast.LENGTH_SHORT).show()
            }
        }
    }
}