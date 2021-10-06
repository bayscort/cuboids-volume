package com.example.volumeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var inputLength:EditText
    private lateinit var inputWidth:EditText
    private lateinit var inputHeight:EditText
    private lateinit var buttonCalculate:Button
    private lateinit var outputResult:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inputLength = findViewById(R.id.input_length)
        inputWidth = findViewById(R.id.input_width)
        inputHeight = findViewById(R.id.input_height)
        buttonCalculate = findViewById(R.id.calculate_button)
        outputResult = findViewById(R.id.output_result)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
       if(v != null) {
           if(v.id == R.id.calculate_button) {
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
                   val cuboidsVolume = length.toDouble()*width.toDouble()*height.toDouble()
                   outputResult.text = cuboidsVolume.toString()
               }
           }
       }
    }
}