package com.example.simplecalcmvp

import io.reactivex.rxjava3.disposables.CompositeDisposable

class CalcPresenter(val view: ICalcView, val model: ICalcModel) {

    private val compositeDisposable = CompositeDisposable()

    fun initPresenter() {
        view.viewEventObservable.subscribe { event ->
            when (event) {
                is addFirstNumber -> model.setFirstNumber(event.first, event.operation)
                is addSecondNumber -> model.setSecondNumber(event.second)
            }
        }
    }

    fun disposeObservers() {
        compositeDisposable.clear()
    }

}
