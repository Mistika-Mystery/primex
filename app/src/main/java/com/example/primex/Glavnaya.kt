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
    public fun KmnbysBTNClick(view: View) {
        val KmnbysIntent = Intent (this, MainActivity2::class.java)
        startActivity(KmnbysIntent)
    }
    public fun ArifmetBTNClick(view: View) {
        val ArifmetIntent = Intent (this, MainActivity4::class.java)
        startActivity(ArifmetIntent)
    }
    public fun ZagadkiBTNClick(view: View) {
        val ZagadkiIntent = Intent (this, Second::class.java)
        startActivity(ZagadkiIntent)
    }
}