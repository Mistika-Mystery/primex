package com.example.primex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import java.util.Random

class MainActivity2 : AppCompatActivity() {
    private val elements = arrayOf("Камень", "Ножницы", "Бумага", "Ящерица", "Спок")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val buttonPaper: ImageButton = findViewById(R.id.imageButtonPaper)
        val buttonNoz: ImageButton = findViewById(R.id.imageButtonNoz)
        val buttonKamen: ImageButton = findViewById(R.id.imageButtonKamen)
        val buttonYacher: ImageButton = findViewById(R.id.imageButtonYacher)
        val buttonSpok: ImageButton = findViewById(R.id.imageButtonSpok)
        buttonKamen.setOnClickListener { playerChoise(0) }
        buttonNoz.setOnClickListener { playerChoise(1) }
        buttonPaper.setOnClickListener { playerChoise(2) }
        buttonYacher.setOnClickListener { playerChoise(3) }
        buttonSpok.setOnClickListener { playerChoise(4) }
    }
    fun playerChoise(playerGame: Int) {
        val computerChoice = Random().nextInt(5)
        val playerV: TextView = findViewById(R.id.textView)
        playerV.setTextColor(Color.GREEN)
        val compV: TextView = findViewById(R.id.textView2)
        compV.setTextColor(Color.GREEN)
        val resultV: TextView = findViewById(R.id.textView3)
        resultV.setTextColor(Color.RED)
        playerV.text = elements[playerGame]
        compV.text = elements[computerChoice]
        val result = determineWinner(playerGame, computerChoice)
        resultV.text = result
    }
    private fun determineWinner(playerGame: Int, computerChoice: Int): String {
        if (playerGame == computerChoice) {
            return "Победила дружба"

        } else if (
            (playerGame == 0 && (computerChoice == 1 || computerChoice == 3)) ||
            (playerGame == 1 && (computerChoice == 2 || computerChoice == 3)) ||
            (playerGame == 2 && (computerChoice == 0 || computerChoice == 4)) ||
            (playerGame == 3 && (computerChoice == 2 || computerChoice == 4)) ||
            (playerGame == 4 && (computerChoice == 0 || computerChoice == 1))
        ) {
            return "Вы выиграли"
        } else {
            return "Вы проиграли"
        }
    }
}