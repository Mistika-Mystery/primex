package com.example.primex

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.primex.databinding.ActivityZagadki3Binding
import com.example.primex.databinding.ActivityZagadkiBinding

class Zagadki3 : AppCompatActivity() {
    lateinit var binding: ActivityZagadki3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glavnaya)
        binding = ActivityZagadki3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvTotal.text = "Всего ответов: " + intent.getStringExtra("answeredTotal")
        binding.tvCorrect.text = "Правильных ответов: " + intent.getStringExtra("answeredCorrect")
        binding.tvWrong.text = "Неправильных ответов: " + intent.getStringExtra("answeredWrong")
    }

}

