package com.globant.mariorangel.onboarding.mvp.model

class CountModel {

    var count = 0

    fun reset() {
        count = 0
    }

    fun inc() {
        count += 1
    }

}
