package com.example.simplecalcmvp

interface ICalcModel {
    fun setFirstNumber(first: Int, operation: Char)
    fun getFirstNumber():Int?
    fun setSecondNumber(second: Int)
    fun getResult(): Int?
    fun reset()
}
