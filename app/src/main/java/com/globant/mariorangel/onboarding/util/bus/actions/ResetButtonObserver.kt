package com.globant.mariorangel.onboarding.util.bus.actions

import com.globant.mariorangel.onboarding.util.bus.BusObserver

abstract class ResetButtonObserver :
        BusObserver<ResetButtonObserver.OnResetButtonPressed>(OnResetButtonPressed::class.java){

    class OnResetButtonPressed
}
