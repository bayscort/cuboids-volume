package com.example.volumeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var inputLength:EditText
    private lateinit var inputWidth:EditText
    private lateinit var inputHeight:EditText
    private lateinit var buttonCalculate:Button
    private lateinit var outputResult:TextView

    var currentResult= 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputLength = findViewById(R.id.input_length)
        inputWidth = findViewById(R.id.input_width)
        inputHeight = findViewById(R.id.input_height)
        buttonCalculate = findViewById(R.id.calculate_button)
        outputResult = findViewById(R.id.output_result)

        buttonCalculate.setOnClickListener{
            val length = inputLength.text.toString().trim()
            val width = inputWidth.text.toString().trim()
            val height = inputHeight.text.toString().trim()

            var emptyColumn = false
            if(length.isEmpty()){
                emptyColumn = true
                inputLength.error = "input value"
            }
            if(width.isEmpty()){
                emptyColumn = true
                inputWidth.error = "input value"
            }
            if(height.isEmpty()){
                emptyColumn = true
                inputHeight.error = "input value"
            }
            if (!emptyColumn){
                currentResult = length.toDouble()*width.toDouble()*height.toDouble()
                outputResult.text = currentResult.toString()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("currentResult", currentResult)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val currentValue = savedInstanceState.getDouble("currentResult", 0.0)
        currentResult =currentValue
        outputResult.text =currentResult.toString()
    }
}