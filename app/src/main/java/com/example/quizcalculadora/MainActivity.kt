package com.example.quizcalculadora

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

    class MainActivity : AppCompatActivity() {

        private lateinit var editTextResult: EditText
        private var currentOperator = ""
        private var operand1 = ""
        private var operand2 = ""

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            editTextResult = findViewById(R.id.editTextResult)
        }

        fun onNumberClick(view: View) {
            val button = view as Button
            editTextResult.append(button.text)
        }

        fun onOperatorClick(view: View) {
            val button = view as Button
            currentOperator = button.text.toString()
            operand1 = editTextResult.text.toString()
            editTextResult.text.clear()
        }

        fun onEqualsClick(view: View) {
            operand2 = editTextResult.text.toString()
            val result = when (currentOperator) {
                "+" -> operand1.toDouble() + operand2.toDouble()
                "-" -> operand1.toDouble() - operand2.toDouble()
                "*" -> operand1.toDouble() * operand2.toDouble()
                "/" -> operand1.toDouble() / operand2.toDouble()
                else -> 0.0
            }
            editTextResult.setText(result.toString())
        }

        fun onClearClick(view: View) {
            editTextResult.text.clear()
            currentOperator = ""
            operand1 = ""
            operand2 = ""
        }
    }
