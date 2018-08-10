package com.globant.mariorangel.onboarding.mvp.presenter

import com.globant.mariorangel.onboarding.mvp.model.CountModel
import com.globant.mariorangel.onboarding.mvp.view.CountView
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class CountPresenterTest {

    private lateinit var countPresenter : CountPresenter

    private val countModel = Mockito.mock(CountModel::class.java)!!
    private val countView = Mockito.mock(CountView::class.java)!!

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        countPresenter = CountPresenter(countModel, countView)
    }


    @Test
    fun shouldIncrementByOne() {
        Mockito.`when`(countModel.count).thenReturn(1)
        countPresenter.handleButtonUpPressed()
        Mockito.verify(countModel).inc()
        Mockito.verify(countView).setCount("1")
        Mockito.verifyNoMoreInteractions(countView)
    }

    @Test
    fun shouldResetCounter() {
        Mockito.`when`(countModel.count).thenReturn(3)
        countPresenter.handleButtonUpPressed()
        countPresenter.handleButtonUpPressed()
        countPresenter.handleButtonUpPressed()
        Mockito.verify(countModel, Mockito.times(3)).inc()
        assertEquals(countModel.count, 3)
        Mockito.`when`(countModel.count).thenReturn(0)
        countPresenter.handleResetButtonPressed()
        Mockito.verify(countModel).reset()
        assertEquals(countModel.count, 0)
        Mockito.verify(countView, Mockito.times(4)).setCount(Mockito.anyString())
        Mockito.verifyNoMoreInteractions(countView)
    }

}