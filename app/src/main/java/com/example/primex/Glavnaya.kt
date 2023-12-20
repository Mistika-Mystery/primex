package com.example.primex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Glavnaya : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glavnaya)
    }

    public fun PrimerBTNClick(view: View) {
        val primerIntent = Intent (this, MainActivity::class.java)
startActivity(primerIntent)
    }




}