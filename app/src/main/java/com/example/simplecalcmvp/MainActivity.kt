package com.example.simplecalcmvp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var calcPresenter: CalcPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calcPresenter = CalcPresenter(CalcView(this),CalcModel())
    }

    override fun onResume() {
        super.onResume()
        calcPresenter?.initPresenter()
    }

    override fun onDestroy() {
        calcPresenter?.disposeObservers()
        super.onDestroy()
    }
}
