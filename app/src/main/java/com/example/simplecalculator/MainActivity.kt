package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.TextView
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T

enum class Operation {
    PLUS, MINUS, TIMES, DIVIDEDBY
}

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addButton.setOnClickListener{ sum() }
        minusButton.setOnClickListener{ subtract() }
        timesButton.setOnClickListener{ multiply() }
        divisionButton.setOnClickListener{ divide() }
    }

    private fun sum() {
        resultTextView.text = performOperation(Operation.PLUS).toString()
    }

    private fun subtract() {
        resultTextView.text = performOperation(Operation.MINUS).toString()
    }

    private fun multiply() {
        resultTextView.text = performOperation(Operation.TIMES).toString()
    }

    private fun divide() {
        resultTextView.text = performOperation(Operation.DIVIDEDBY).toString()
    }

    private fun performOperation(operation: Operation): Double {
        var (a, b) = getNumbers()

        return when(operation) {
            Operation.PLUS -> a + b
            Operation.MINUS -> a - b
            Operation.TIMES -> a * b
            Operation.DIVIDEDBY -> a / b
        }
    }

    private fun getNumbers(): Pair<Double, Double> {
        var a = firstNumberEditText.text.toString().toDouble()
        var b = secondNumberEditText.text.toString().toDouble()
        return Pair(a, b)
    }

}
