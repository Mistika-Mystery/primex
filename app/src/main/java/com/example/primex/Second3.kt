package com.example.primex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.primex.databinding.ActivitySecond3Binding

class Second3 : AppCompatActivity() {
    lateinit var binding: ActivitySecond3Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecond3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.TxtRightAnswer.text = "Правильных ответов: " + intent.getStringExtra("rightNumberAnswer")
        binding.TxtWrongAnswer.text = "Неправильных ответов: " + intent.getStringExtra("wrongNumberAnswer")

    }

    fun onClickBackBtn(view: View)
    {
        finish()
    }
}