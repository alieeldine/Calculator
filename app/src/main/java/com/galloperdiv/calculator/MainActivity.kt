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
}
