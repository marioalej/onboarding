package com.globant.mariorangel.onboarding.util.bus

import io.reactivex.functions.Consumer

abstract class BusObserver <T>(private val clazz: Class<T>) : Consumer<Any> {

    @Suppress("UNCHECKED_CAST")
    override fun accept(t: Any) {
        if(t.javaClass == clazz){
            onEvent(t as T)
        }
    }

    abstract fun onEvent(value: T)
}