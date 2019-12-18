package com.example.simplecalcmvp

sealed class EventTypes

class addFirstNumber(val first: Int, val operation: Char) : EventTypes()
class addSecondNumber(val second: Int) : EventTypes()

