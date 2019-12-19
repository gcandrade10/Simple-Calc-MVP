package com.example.simplecalcmvp

import android.app.Activity
import android.widget.Button
import android.widget.Toast
import com.example.simplecalcmvp.CalcModel.Companion.DIVIDE
import com.example.simplecalcmvp.CalcModel.Companion.MULTIPLY
import com.example.simplecalcmvp.CalcModel.Companion.SUBTRACT
import com.example.simplecalcmvp.CalcModel.Companion.SUM
import com.jakewharton.rxbinding3.view.clicks
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Integer.parseInt


class CalcView(private val activity: Activity) : ICalcView {
    override fun showToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

    override fun reset() {
        cleartext()
    }

    override fun showResult(result: Int?) {
        result?.let {
            activity.txtNumber.setText("$it")
        }
    }

    override fun enableEqualsButton(enable: Boolean) {
        activity.btnEquals.isEnabled = enable
    }

    override fun enableOperationButtons(enable: Boolean) {
        activity.btnSum.isEnabled = enable
        activity.btnSubtract.isEnabled = enable
        activity.btnMultiply.isEnabled = enable
        activity.btnDivide.isEnabled = enable
    }

    override fun cleartext() {
        activity.txtNumber.setText("")
    }

    private fun parseNumber(): Int {
        return parseInt(activity.txtNumber.text.toString())
    }

    private fun getObservable(button: Button, operation: Char): Observable<EventTypes> {
        return button.clicks().map<EventTypes> {
            AddFirstNumber(parseNumber(), operation)
        }
    }

    private val addSecondNumber: Observable<EventTypes> =
        activity.btnEquals.clicks().map<EventTypes> {
            AddSecondNumber(parseNumber())
        }

    private val numberChanged: Observable<EventTypes> = activity.txtNumber.textChanges().map {
        NumberChanged(it.toString())
    }

    private val reset: Observable<EventTypes> = activity.btnReset.clicks().map {
        Reset
    }

    override val viewEventObservable: Observable<EventTypes> =
        getObservable(activity.btnSum, SUM)
            .mergeWith(getObservable(activity.btnSubtract, SUBTRACT))
            .mergeWith(getObservable(activity.btnMultiply, MULTIPLY))
            .mergeWith(getObservable(activity.btnDivide, DIVIDE))
            .mergeWith(addSecondNumber)
            .mergeWith(numberChanged)
            .mergeWith(reset)

}
