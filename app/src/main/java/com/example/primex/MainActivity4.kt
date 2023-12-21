package com.example.primex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.primex.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    private var allExamples = 0
    private var wins = 0.0
    private var loses = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun checkResult(operand: String, operatorOne: Int, operatorTwo: Int, playerResult: Int): Boolean {
        var result = 0
        when (operand) {
            "+" -> result = operatorOne + operatorTwo
            "-" -> result = operatorOne - operatorTwo
            "*" -> result = operatorOne * operatorTwo
            "/" -> {
                if (operatorTwo != 0) {
                    result = operatorOne / operatorTwo
                } else {
                    // Handle division by zero
                }
            }
        }
        return (result == playerResult)
    }

    fun onClickStart(view: View) {
        binding.EditNumberTxt.text.clear()
        binding.EditNumberTxt.setBackgroundColor(Color.WHITE)
        val operands = arrayOf("+", "-", "*", "/")
        val operand = operands.random()
        var oneOperant = (10..99).random()
        var twoOperator = (10..99).random()
        if (operand == "/") {
            while (twoOperator == 0 || oneOperant % twoOperator != 0) {
                oneOperant = (10..99).random()
                twoOperator = (10..99).random()
            }
        }
        binding.FirstOperandTxt.text = oneOperant.toString()
        binding.TwoOperandTxt.text = twoOperator.toString()
        binding.OperationTxt.text = operand
        binding.EditNumberTxt.isEnabled = true
        binding.CheckAnswerBtn.isEnabled = true
        binding.StartBtn.isEnabled = false
    }

    fun onClickCheckAnswer(view: View) {
        val operator1 = binding.FirstOperandTxt.text.toString().toInt()
        val operator2 = binding.TwoOperandTxt.text.toString().toInt()
        val operandTxt = binding.OperationTxt.text.toString()
        val resultPlayer = binding.EditNumberTxt.text.toString().toInt()

        binding.CheckAnswerBtn.isEnabled = false
        binding.StartBtn.isEnabled = true

        if (checkResult(operandTxt, operator1, operator2, resultPlayer)) {
            wins++
            allExamples++
            binding.NumberRigthTxt.text = wins.toString()
            binding.NumberRigthTxt.setTextColor(Color.GREEN)
            binding.EditNumberTxt.setBackgroundColor(Color.GREEN)
        } else {
            loses++
            allExamples++
            binding.NumberWrongTxt.text = loses.toString()
            binding.EditNumberTxt.setBackgroundColor(Color.RED)
            binding.NumberWrongTxt.setTextColor(Color.RED)
        }

        val percentage = (wins / allExamples) * 100
        binding.AllExamplesTxt.text = allExamples.toString()
        binding.AllExamplesTxt.setTextColor(Color.BLUE)
        binding.PercentageCorrectAnswersTxt.text = ("%.2f".format(percentage)).toString() + "%"
    }
}
