package com.example.simplecalcmvp

import com.example.simplecalcmvp.CalcModel.Companion.SUM
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

class CalcPresenterTest {
    private var calcPresenter: CalcPresenter? = null

    @Mock
    lateinit var view: ICalcView

    @Mock
    lateinit var model: ICalcModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        calcPresenter = CalcPresenter(view, model)
    }

    @Test
    fun shouldSaveFirstParameter() {
        // Given

        // When
        model.setFirstNumber(1, SUM)

        // Then
        verify(model, times(1)).setFirstNumber(1, SUM)
    }

    @Test
    fun shouldSaveSecondParameter() {
        // Given

        // When
        model.setSecondNumber(2)

        // Then
        verify(model, times(1)).setSecondNumber(2)
    }
}