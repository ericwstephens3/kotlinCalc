package com.example.kotlincalc

import android.content.Context
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity(), Calculator {

    //////////////////////////////////////////////
    //                  Global Vars
    //////////////////////////////////////////////

    private var DIVISION = 0
    private var MUTLTIPLICATION = 1
    private var ADDITION = 2
    private var SUBTRACTION = 3

    private lateinit var acBtn : Button
    private lateinit var percentageBtn : Button
    private lateinit var negativeBtn : Button
    private lateinit var divisionBtn : Button
    private lateinit var sevenBtn : Button
    private lateinit var eightButton : Button
    private lateinit var nineBtn : Button
    private lateinit var multiplyBtn : Button
    private lateinit var fourBtn : Button
    private lateinit var fiveBtn : Button
    private lateinit var sixBtn : Button
    private lateinit var subtractBtn : Button
    private lateinit var oneBtn : Button
    private lateinit var twoBtn : Button
    private lateinit var threeBtn : Button
    private lateinit var plusBtn : Button
    private lateinit var zeroBtn : Button
    private lateinit var periodBtn : Button
    private lateinit var equalsBtn : Button
    private lateinit var outputText : TextView
    private var expression = ""
    private var isDivision = false
    private var isMultiplication = false
    private var isAddition = false
    private var isSubtraction = false



    ///////////////////////////////////////////////////////
    //                  FUNCTIONS
    //////////////////////////////////////////////////////

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //UI references
        acBtn = findViewById(R.id.acButton)
        percentageBtn = findViewById(R.id.percentButton)
        negativeBtn = findViewById(R.id.negativeButton)
        divisionBtn = findViewById(R.id.divisionButton)
        sevenBtn = findViewById(R.id.sevenButton)
        eightButton = findViewById(R.id.eightButton)
        nineBtn = findViewById(R.id.nineButton)
        multiplyBtn = findViewById(R.id.multiplyButton)
        fourBtn = findViewById(R.id.fourButton)
        fiveBtn = findViewById(R.id.fiveButton)
        sixBtn = findViewById(R.id.sixButton)
        subtractBtn = findViewById(R.id.subtractButton)
        oneBtn = findViewById(R.id.oneButton)
        twoBtn = findViewById(R.id.twoButton)
        threeBtn = findViewById(R.id.threeButton)
        plusBtn = findViewById(R.id.plusButton)
        zeroBtn = findViewById(R.id.zeroButton)
        periodBtn = findViewById(R.id.periodButton)
        equalsBtn = findViewById(R.id.equalsButton)
        outputText = findViewById(R.id.outputView)

        //On click Listener Registers
        acBtn.setOnClickListener { clear() }
        percentageBtn.setOnClickListener { changePercentage() }
        negativeBtn.setOnClickListener { negate() }
        divisionBtn.setOnClickListener {
            reverseColor(DIVISION)
        }

    }

    private fun clear(){
        outputText.setText("0")
        expression = ""
        changeBoolean(5) //anything except 1-3 clears booleans
    }

    private fun changePercentage(){
        outputText.setText(divide(outputText.text.toString().toInt(), 100))
    }

    private fun negate(){
        outputText.setText(multiply(outputText.text.toString().toInt(), -1))
    }

    private fun reverseColor (value: Int){

        var fg: ColorStateList
        var fontColor: Int
        when (value) {
            0 -> {
                fg = divisionBtn.backgroundTintList
                fontColor = divisionBtn.currentTextColor
                divisionBtn.backgroundTintList = ColorStateList.valueOf(fontColor)
                divisionBtn.setTextColor(fg)
            }
            1 -> {
                fg = multiplyBtn.backgroundTintList
                fontColor = multiplyBtn.currentTextColor
                multiplyBtn.backgroundTintList = ColorStateList.valueOf(fontColor)
                multiplyBtn.setTextColor(fg)
            }
            2 -> {
                fg = plusBtn.backgroundTintList
                fontColor = plusBtn.currentTextColor
                plusBtn.backgroundTintList = ColorStateList.valueOf(fontColor)
                plusBtn.setTextColor(fg)
            }
            else -> {
                fg = subtractBtn.backgroundTintList
                fontColor = subtractBtn.currentTextColor
                subtractBtn.backgroundTintList = ColorStateList.valueOf(fontColor)
                subtractBtn.setTextColor(fg)
            }
        }
        changeBoolean(value)
    }

    private fun changeBoolean(value: Int){
        when (value){
            0 ->{
                if (isDivision) isDivision = false else isDivision = true
                isMultiplication = false
                isAddition = false
                isSubtraction = false
            }
            1 ->{
                isDivision = false
                isMultiplication = true
                isAddition = false
                isSubtraction = false
            }
            2 ->{
                isDivision = false
                isMultiplication = false
                isAddition = true
                isSubtraction = false
            }
            3 ->{
                isDivision = false
                isMultiplication = false
                isAddition = false
                isSubtraction = true
            }
            else -> {
                isDivision = false
                isMultiplication = true
                isAddition = false
                isSubtraction = false
            }
        }
    }
}
