package com.example.primex

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.primex.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(bindingClass.root)
        serviceIntent = Intent(applicationContext, TimerService::class.java)
        registerReceiver(updateTime, IntentFilter(TimerService.TIMER_UPDATED))
    }
    private var timerStarted = false
    private lateinit var serviceIntent: Intent
    private var allTime = 0.0
    private var avgSec = 0.0
    private var maxSec = 0.0
    private var minSec = 99999.0
    private var time = 0.0

    private var wins = 0
    private var loses = 0
    private var allExamples = 0.0
    private var percentage = 0.0
    private var choice = true


    fun onClickRightBtn(view: View) {
        if (choice)
        {
            wins++
            allExamples++
            bindingClass.resultTxt.setBackgroundColor(Color.GREEN)

        }
        else
        {
            loses++
            allExamples++
            bindingClass.resultTxt.setBackgroundColor(Color.RED)

        }
        percentage = ((wins/allExamples)*100).toDouble()
        bindingClass.rigthtxt.text = wins.toString()
        bindingClass.losetxt.text = loses.toString()
        bindingClass.allextxt.text =  ("%.0f".format(allExamples)).toString()
        bindingClass.percentrigthtxt.text = ("%.2f".format(percentage)).toString()  + "%"
        bindingClass.loseBtn.isEnabled = false
        bindingClass.rightBtn.isEnabled = false
        bindingClass.startBtn.isEnabled = true
        resetTimer()
    }

    fun onClickStartBtn(view: View) {
        var result = 0
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
        var chance = (1..2).random()
        if (chance == 1)
        {
            choice = true
            when (operand){
                "+" -> result = oneOperant+twoOperator
                "-" -> result = oneOperant-twoOperator
                "*" -> result = oneOperant*twoOperator
                "/" -> result = oneOperant/twoOperator
            }
        }
        else
        {
            choice = false
            result = (-100..100).random()
        }
        bindingClass.oper1txt.text = oneOperant.toString()
        bindingClass.oper2txt.text= twoOperator.toString()
        bindingClass.operatortxt.text = operand
        bindingClass.resultTxt.text = result.toString()
        bindingClass.loseBtn.isEnabled = true
        bindingClass.rightBtn.isEnabled = true
        bindingClass.startBtn.isEnabled = false
        bindingClass.resultTxt.setBackgroundColor(Color.WHITE)
        startTimer()
    }

    fun onClickLoseBtn(view: View) {
        if (!choice)
        {
            wins++
            allExamples++
            bindingClass.resultTxt.setBackgroundColor(Color.GREEN)
        }
        else
        {
            loses++
            allExamples++
            bindingClass.resultTxt.setBackgroundColor(Color.RED)
        }
        percentage = ((wins/allExamples)*100).toDouble()
        bindingClass.rigthtxt.text = wins.toString()
        bindingClass.losetxt.text = loses.toString()
        bindingClass.allextxt.text = ("%.0f".format(allExamples)).toString()
        bindingClass.percentrigthtxt.text = ("%.2f".format(percentage)).toString()  + "%"
        bindingClass.loseBtn.isEnabled = false
        bindingClass.rightBtn.isEnabled = false
        bindingClass.startBtn.isEnabled = true
        resetTimer()
    }


    private fun resetTimer()
    {
        stopTimer()
        allTime += time
        if (time < minSec) {
            minSec = time
            bindingClass.mintxt.text = time.toString()
        }
        if (time > maxSec) {
            maxSec = time
            bindingClass.maxtxt.text = time.toString()
        }
        avgSec = allTime / allExamples
        bindingClass.avgtxt.text = ("%.2f".format(avgSec)).toString()
        time = 0.0
        bindingClass.timextx.text = getTimeStringFromDouble(time)
    }
    private fun startTimer()
    {
        serviceIntent.putExtra(TimerService.TIME_EXTRA, time)
        startService(serviceIntent)
        timerStarted = true
    }

    private fun stopTimer()
    {
        stopService(serviceIntent)
        timerStarted = false
    }

    private val updateTime: BroadcastReceiver = object : BroadcastReceiver()
    {
        override fun onReceive(context: Context, intent: Intent)
        {
            time = intent.getDoubleExtra(TimerService.TIME_EXTRA, 0.0)
            bindingClass.timextx.text = getTimeStringFromDouble(time)
        }
    }
    private fun getTimeStringFromDouble(time: Double): String {
        val resultInt = time.roundToInt()
        return resultInt.toString()
    }
}