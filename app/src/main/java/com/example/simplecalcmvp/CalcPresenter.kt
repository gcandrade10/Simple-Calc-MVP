package com.example.simplecalcmvp

import io.reactivex.disposables.CompositeDisposable
import java.lang.ArithmeticException
import java.lang.NumberFormatException


class CalcPresenter(val view: ICalcView, val model: ICalcModel) {

    private val compositeDisposable = CompositeDisposable()

    fun initPresenter() {
        val disposable = view.viewEventObservable.subscribe( { event ->
            when (event) {
                is AddFirstNumber -> {
                    model.setFirstNumber(event.first, event.operation)
                    view.cleartext()

                }
                is AddSecondNumber -> {
                    model.setSecondNumber(event.second)
                    view.showResult(model.getResult())
                }
                is NumberChanged -> {
                    view.enableOperationButtons(!event.number.isNullOrEmpty() && model.getFirstNumber() == null)
                    view.enableEqualsButton(!event.number.isNullOrEmpty() && model.getFirstNumber() != null)
                }
                Reset -> {
                    model.reset()
                    view.reset()
                }
            }
        },{
            when(it){
                is ArithmeticException -> view.showToast("You can't divide by zero")
                is NumberFormatException -> view.showToast("That number is too big")
            }
            initPresenter()
        })
        compositeDisposable.add(disposable)
    }

    fun disposeObservers() {
        compositeDisposable.clear()
    }

}
