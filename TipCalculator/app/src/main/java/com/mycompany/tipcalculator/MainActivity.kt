package com.mycompany.tipcalculator

import com.mycompany.tipcalculator.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateTipButton.setOnClickListener {
            calculateTip()
        }
    }

    private fun calculateTip() {
        val billTotalInput = binding.billTotalEditText.text.toString()
        if (billTotalInput.isNotEmpty()) {
            val billTotal = billTotalInput.toDouble()
            val tip10 = billTotal * 1.10
            val tip15 = billTotal * 1.15
            val tip20 = billTotal * 1.20

            val result = "The tips are as follows:\n" +
                    "10% = ${String.format("%.2f", tip10)}\n" +
                    "15% = ${String.format("%.2f", tip15)}\n" +
                    "20% = ${String.format("%.2f", tip20)}"

            result.also { binding.resultTextView.text = it }
        } else {
            binding.resultTextView.text = "YOU MUST ENTER A BILL AMOUNT"
        }
    }
}
