package com.globant.mariorangel.onboarding.util.bus.actions

import com.globant.mariorangel.onboarding.util.bus.BusObserver

/**
 * abstract class that defines the event for increment button
 */
abstract class ButtonUpObserver :
        BusObserver<ButtonUpObserver.OnButtonUpPressed>(OnButtonUpPressed::class.java) {

    class OnButtonUpPressed
}


