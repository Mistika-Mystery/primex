package com.example.primex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.primex.databinding.ActivityZagadki2Binding

class Zagadki2 : AppCompatActivity() {
    lateinit var binding: ActivityZagadki2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zagadki2)
        binding = ActivityZagadki2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        var Answers: List<String?> = listOf(
            intent.getStringExtra("answer1"),
            intent.getStringExtra("answer2"),
            intent.getStringExtra("answer3"),
            intent.getStringExtra("answer4"),
            intent.getStringExtra("answer5"),
            intent.getStringExtra("answerCorrect")
        ).shuffled()


        binding.radioButton.text = Answers[0]
        binding.radioButton2.text = Answers[1]
        binding.radioButton3.text = Answers[2]
        binding.radioButton4.text = Answers[3]
        binding.radioButton5.text = Answers[4]
        binding.radioButton6.text = Answers[5]
    }
    fun btnClickCheck(view: View) {
        var chosenValue = "";
        if (binding.radioButton.isChecked) {
            chosenValue = binding.radioButton.text.toString()
        }
        else if (binding.radioButton2.isChecked) {
            chosenValue = binding.radioButton2.text.toString()
        }
        else if (binding.radioButton3.isChecked) {
            chosenValue = binding.radioButton3.text.toString()
        }
        else if (binding.radioButton4.isChecked) {
            chosenValue = binding.radioButton4.text.toString()
        }
        else if (binding.radioButton5.isChecked) {
            chosenValue = binding.radioButton5.text.toString()
        }
        else if (binding.radioButton6.isChecked) {
            chosenValue = binding.radioButton6.text.toString()
        }
        val intent = Intent(this, Zagadki::class.java)
        intent.putExtra("chosenAnswer", chosenValue)
        setResult(RESULT_OK, intent)
        finish()
    }
}