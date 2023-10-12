package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private var num1: Int = 0
    private var num2: Int = 0
    private var operator: String? = null

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener { appendToExpression("1") }
        binding.button2.setOnClickListener { appendToExpression("2") }
        binding.button3.setOnClickListener { appendToExpression("3") }
        binding.button4.setOnClickListener { appendToExpression("4") }
        binding.button5.setOnClickListener { appendToExpression("5") }
        binding.button6.setOnClickListener { appendToExpression("6") }
        binding.button7.setOnClickListener { appendToExpression("7") }
        binding.button8.setOnClickListener { appendToExpression("8") }
        binding.button0.setOnClickListener { appendToExpression("0") }
        binding.button9.setOnClickListener { appendToExpression("9") }

        binding.buttonPlus.setOnClickListener { setOperator("+") }
        binding.buttonMinus.setOnClickListener { setOperator("-") }
        binding.buttonMultiply.setOnClickListener { setOperator("*") }
        binding.buttonDivide.setOnClickListener { setOperator("/") }

        binding.buttonClear.setOnClickListener { clearExpression() }

        binding.buttonEqual.setOnClickListener { evaluateExpression() }


    }


    private fun appendToExpression(value: String) {
        binding.editText.append(value)

    }

    private fun setOperator(op: String) {
        operator = op
        num1 = binding.editText.text.toString().toInt()
        binding.editText.text.clear()

    }

    private fun clearExpression() {
        binding.editText.text.clear()
        num1 = 0
        num2 = 0
        operator = null

    }

    private fun evaluateExpression() {
        if (operator != null) {
            num2 = binding.editText.text.toString().toInt()
            val result = when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> num1 / num2

                else -> 0

            }
            binding.editText.setText(result.toString())
            num1 = result
            num2 = 0
            operator = null
        }
    }
}



