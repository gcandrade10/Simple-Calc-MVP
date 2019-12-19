package com.example.simplecalcmvp

sealed class EventTypes
data class AddFirstNumber(val first: Int, val operation: Char) : EventTypes()
data class AddSecondNumber(val second: Int) : EventTypes()
data class NumberChanged(val number: String) : EventTypes()
object Reset:EventTypes()


