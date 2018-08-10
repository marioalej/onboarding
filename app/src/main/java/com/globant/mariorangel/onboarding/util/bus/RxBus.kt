package com.globant.mariorangel.onboarding.util.bus

import android.app.Activity
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject

class RxBus {

    /**
     * Enclosed inside a companion object to share just one instance over all the application
     */
    companion object {

        private val disposableMap = HashMap<Activity, CompositeDisposable>()
        private val publishSubject = PublishSubject.create<Any>()

        fun post(@NonNull any: Any) = publishSubject.onNext(any)

        fun subscribe(@NonNull activity: Activity, @NonNull busObserver: BusObserver<*>){
            var compositeDisposable: CompositeDisposable? = disposableMap[activity]
            if (compositeDisposable == null)
                compositeDisposable = CompositeDisposable()
            compositeDisposable.add(publishSubject.subscribe(busObserver))
            disposableMap[activity] = compositeDisposable
        }

        fun clear(@NonNull activity: Activity) {
            var compositeDisposable: CompositeDisposable? = disposableMap[activity]
            if(compositeDisposable != null)
                compositeDisposable.clear()
            disposableMap.remove(activity)
        }

        fun clearAll() {
            for (entry: Map.Entry<Activity, CompositeDisposable> in disposableMap.entries)
                entry.value.clear()
            disposableMap.clear()
        }
    }
}