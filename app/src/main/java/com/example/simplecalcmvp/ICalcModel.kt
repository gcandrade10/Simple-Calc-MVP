package com.example.simplecalcmvp

interface ICalcModel {
    fun setFirstNumber(first: Int, operation: Char): Void
    fun setSecondNumber(second: Int)
}
