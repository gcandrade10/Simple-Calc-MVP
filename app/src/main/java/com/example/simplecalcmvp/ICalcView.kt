package com.example.simplecalcmvp

import io.reactivex.Observable

interface ICalcView {
    fun cleartext()
    fun enableOperationButtons(enable: Boolean)
    fun enableEqualsButton(enable: Boolean)
    fun showResult(result: Int?)
    fun reset()
    fun showToast(message: String)

    val viewEventObservable: Observable<EventTypes>
}
