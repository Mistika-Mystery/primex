package com.example.primex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.primex.databinding.ActivitySecond2Binding

class Second2 : AppCompatActivity() {
    lateinit var binding: ActivitySecond2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecond2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        var question = intent.getStringExtra("question")
    }
    fun onClickCheck(view: View) {
        var answerUser = binding.EditAnswer.text
        val mainIntent = Intent(this,MainActivity::class.java)
        mainIntent.putExtra("answerUser",answerUser)
        setResult(RESULT_OK,mainIntent)
        finish()
    }
    fun onClickEditAnswer(view: View) {
        if (binding.EditAnswer.text.toString()!="")
        {
            binding.CheckBtn.setEnabled(true)
        }
        else
        {
            binding.CheckBtn.setEnabled(false)
        }
    }
}