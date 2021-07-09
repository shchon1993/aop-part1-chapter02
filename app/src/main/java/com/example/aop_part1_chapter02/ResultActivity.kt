package com.example.aop_part1_chapter02

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class ResultActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var height = intent.getIntExtra("height",0)
        var weight = intent.getIntExtra("weight",0)
        Log.d("result","height $height weight $weight")

        var bmi = weight / (height / 100.0).pow(2.0)
        var resultText = when{
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중"
            bmi >= 18.0 -> "정상 체중"
            else -> "저체중"
        }


        var resultTextView = findViewById<TextView>(R.id.resultTextView)
        var resultStringTextView = findViewById<TextView>(R.id.valueTextView)

        resultTextView.text = bmi.toString()
        resultStringTextView.text = resultText

    }

}
