package com.rafaelsouza.cakeshop.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.rafaelsouza.cakeshop.R

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_intro)
        Handler(Looper.getMainLooper()).postDelayed({

            val telaTemp = Intent(this, MainActivity::class.java)

            startActivity(telaTemp)

            finish()

        },3000)


    }
    }
