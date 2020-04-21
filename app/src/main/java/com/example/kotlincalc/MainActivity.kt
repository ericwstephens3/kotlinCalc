package com.example.kotlincalc

import android.content.res.ColorStateList
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity(), Calculator {

    //////////////////////////////////////////////
    //                  Global Vars
    //////////////////////////////////////////////

    private val DIVISION = 0
    private val MULTIPLICATION = 1
    private val ADDITION = 2
    private val SUBTRACTION = 3

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
    private var prevNum = 0
    private var num = 0
    private var booleans : BitSet = BitSet(4)



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
            reverseColor(this.divisionBtn, DIVISION)
        }
        multiplyBtn.setOnClickListener{
            reverseColor(this.multiplyBtn, MULTIPLICATION)
        }
        subtractBtn.setOnClickListener{
            reverseColor(this.subtractBtn, SUBTRACTION)
        }
        plusBtn.setOnClickListener{
            reverseColor(this.plusBtn, ADDITION)
        }
        oneBtn.setOnClickListener{

        }

    }

    private fun clear(){
        outputText.text= "0"
        num = 0
        prevNum = 0
        booleans.clear()
    }

    private fun changePercentage(){
        outputText.setText(divide(outputText.text.toString().toInt(), 100))
    }

    private fun negate(){
        outputText.setText(multiply(outputText.text.toString().toInt(), -1))
    }

    private fun reverseColor (btn: Button, value: Int){

        var fg: ColorStateList = btn.backgroundTintList
        var fontColor: Int = btn.currentTextColor
        btn.backgroundTintList = ColorStateList.valueOf(fontColor)
        btn.setTextColor(fg)

        changeBoolean(value)
    }

    private fun changeBoolean(value: Int){
        booleans.clear()
        booleans.set(value)
    }

    private fun getBoolean(): Int{
        return booleans.nextSetBit(0)
    }

    private fun equals(){
        if (prevNum != 0){
            when (getBoolean()){
                DIVISION ->{
                    prevNum /= num
                    outputText.text = prevNum.toString()
                }
                MULTIPLICATION->{
                    prevNum *= num
                    outputText.text = prevNum.toString()
                }
                SUBTRACTION->{
                    prevNum -= num
                    outputText.text = prevNum.toString()
                }
                ADDITION->{
                    prevNum += num
                    outputText.text = prevNum.toString()
                }
                else->{
                    outputText.text = "0"
                }
            }
        }
        else
            outputText.text = "0"
    }
}
