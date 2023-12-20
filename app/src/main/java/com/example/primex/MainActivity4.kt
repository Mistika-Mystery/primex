package com.example.primex

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil.setContentView
import com.example.primex.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {
    private lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun checkResult(operand:String, operatorOne:Int, operatorTwo:Int, playerResult: Int):Boolean
    {
        var result = 0
        when (operand){
            "+" -> result = operatorOne+operatorTwo
            "-" -> result = operatorOne-operatorTwo
            "*" -> result = operatorOne*operatorTwo
            "/" -> result = operatorOne/operatorTwo
        }
        return (result == playerResult)
    }

    fun onClickStart(view: View)
    {
        binding.EditNumberTxt.text.clear()
        binding.EditNumberTxt.setBackgroundColor(Color.WHITE)
        val operands = arrayOf("+","-","*","/")
        val operand = operands.random()
        var oneOperant = (10..99).random()
        var twoOperator = (10..99).random()
        if (operand == "/")
        {
            while (oneOperant%twoOperator!=0)
            {
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

    private var allExamples = 0
    var percentage = 0.0
    fun onClickCheckAnswer(view: View)
    {
        var wins = binding.NumberRigthTxt.text.toString().toDouble()
        var loses = binding.NumberWrongTxt.text.toString().toInt()
        val operator1 = binding.FirstOperandTxt.text.toString().toInt()
        val operator2 = binding.TwoOperandTxt.text.toString().toInt()
        val operandTxt = binding.OperationTxt.text.toString()
        val resultPlayer = binding.EditNumberTxt.text.toString().toInt()
        var percentage = 0.0
        binding.CheckAnswerBtn.isEnabled = false
        binding.StartBtn.isEnabled = true
        if (checkResult(operandTxt,operator1,operator2,resultPlayer))
        {
            wins += 1
            allExamples += 1
            percentage = (wins/allExamples*100).toDouble()
            binding.NumberRigthTxt.text = wins.toString()
            binding.EditNumberTxt.setBackgroundColor(Color.GREEN)
            binding.AllExamplesTxt.text = allExamples.toString()
            binding.PercentageCorrectAnswersTxt.text = ("%.2f".format(percentage)).toString()  + "%"
        }
        else
        {
            loses +=1
            allExamples +=1
            percentage = (allExamples/wins).toDouble()
            binding.NumberWrongTxt.text = loses.toString()
            binding.EditNumberTxt.setBackgroundColor(Color.RED)
            binding.AllExamplesTxt.text = allExamples.toString()
            binding.PercentageCorrectAnswersTxt.text = ("%.2f".format(percentage)).toString()  + "%"
        }
    }
}



