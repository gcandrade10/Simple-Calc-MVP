package com.example.simplecalcmvp

class CalcModel : ICalcModel {
    private var firstNumber: Int? = null
    private var result: Int? = null
    private var operation: Char? = null

    override fun getResult(): Int? {
        return result
    }

    override fun getFirstNumber(): Int? {
        return firstNumber
    }

    override fun setFirstNumber(first: Int, pOperation: Char) {
        firstNumber = first
        operation = pOperation
    }

    override fun setSecondNumber(second: Int) {
        result = firstNumber?.let {
            operate(it, second)
        }
    }

    private fun operate(first: Int, second: Int): Int? {
        return when (operation) {
            '+' -> first + second
            '-' -> first - second
            '/' -> (first / second)
            '*' -> first * second
            else -> null
        }
    }

    override fun reset() {
        firstNumber = null
        result = null
        operation = null
    }
}
