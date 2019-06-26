package com.galloperdiv.calculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnNumberEvent(view: View) {
        if (isNewOp == true) etShowNumber.setText("")
        isNewOp = false

        val btnSelect = view as Button
        var btnClickValue:String = etShowNumber.text.toString()

        when (btnSelect.id) {
            btn0.id -> btnClickValue += "0"
            btn1.id -> btnClickValue += "1"
            btn2.id -> btnClickValue += "2"
            btn3.id -> btnClickValue += "3"
            btn4.id -> btnClickValue += "4"
            btn5.id -> btnClickValue += "5"
            btn6.id -> btnClickValue += "6"
            btn7.id -> btnClickValue += "7"
            btn8.id -> btnClickValue += "8"
            btn9.id -> btnClickValue += "9"
            btnDot.id -> {
                //TODO : prevent adding more than 1 dot
                btnClickValue += "."}
            btnPlusMinus.id -> btnClickValue = "-" + btnClickValue
        }

        etShowNumber.setText(btnClickValue)
    }

    var op = "*"
    var oldNumber = ""
    var isNewOp = true

    fun btnOpEvent(view: View) {
        val btnSelect = view as Button
        when (btnSelect.id) {
            btnDiv.id -> op = "/"
            btnMul.id -> op = "*"
            btnSub.id -> op = "-"
            btnSum.id -> op = "+"
        }
        oldNumber = etShowNumber.text.toString()
        isNewOp = true
    }

    fun btnEqual(view: View) {
        val newNumber = etShowNumber.text.toString()
        var finalNumber:Double ?= null
        when (op) {
            "/" -> finalNumber = oldNumber.toDouble()  / newNumber.toDouble()
            "*" -> finalNumber = oldNumber.toDouble()  * newNumber.toDouble()
            "-" -> finalNumber = oldNumber.toDouble()  - newNumber.toDouble()
            "+" -> finalNumber = oldNumber.toDouble()  + newNumber.toDouble()
        }
        etShowNumber.setText(finalNumber.toString())
        isNewOp = true
    }

    fun btnPercent(view:View) {
        val number:Double = etShowNumber.text.toString().toDouble() / 100
        etShowNumber.setText(number.toString())
        isNewOp = true
    }

    fun btnClean(view: View) {
        etShowNumber.setText("0")
        isNewOp = true
    }
}
