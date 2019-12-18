package com.example.simplecalcmvp

import io.reactivex.rxjava3.core.Observable


interface ICalcView {

    val viewEventObservable: Observable<EventTypes>
}
