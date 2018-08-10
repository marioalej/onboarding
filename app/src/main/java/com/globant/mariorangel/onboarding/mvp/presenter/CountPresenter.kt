package com.globant.mariorangel.onboarding.mvp.presenter

import android.app.Activity
import com.globant.mariorangel.onboarding.mvp.model.CountModel
import com.globant.mariorangel.onboarding.mvp.view.CountView
import com.globant.mariorangel.onboarding.util.bus.RxBus
import com.globant.mariorangel.onboarding.util.bus.actions.ButtonUpObserver
import com.globant.mariorangel.onboarding.util.bus.actions.ResetButtonObserver


class CountPresenter(private val model: CountModel,
                     private val view: CountView) {

    // Register the events to the view
    fun register() {

        val activity: Activity? = view.getActivity() ?: return

        RxBus.subscribe(activity!!, object: ButtonUpObserver() {
            override fun onEvent(value: OnButtonUpPressed) {
                handleButtonUpPressed()
            }

        })

        RxBus.subscribe(activity, object: ResetButtonObserver() {
            override fun onEvent(value: OnResetButtonPressed) {
                handleResetButtonPressed()
            }

        })
    }

    // Unregister events to the view
    fun unregister() {
        val activity = view.getActivity() ?: return

        RxBus.clear(activity)
    }

    // Handler for the reset button when is pressed
    fun handleResetButtonPressed() {
        model.reset()
        view.setCount(model.count.toString())
    }

    // Handler for the increment button when is pressed
    fun handleButtonUpPressed() {
        model.inc()
        view.setCount(model.count.toString())
    }
}