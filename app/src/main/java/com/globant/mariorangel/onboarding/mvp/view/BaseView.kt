package com.globant.mariorangel.onboarding.mvp.view

import android.app.Activity
import android.app.FragmentManager
import android.content.Context
import io.reactivex.annotations.Nullable
import java.lang.ref.WeakReference

/**
 * BaseView works as a binder between an activity with its ViewHolder
 * it's declared open to come inheritable to child classes
 */
open class BaseView {

    private lateinit var activityRef: WeakReference<Activity>

    constructor(activity: Activity) {
        activityRef = WeakReference(activity)
    }

    @Nullable
    fun getActivity(): Activity? {
        return activityRef.get()
    }

    @Nullable
    fun getContext(): Context? {
        return getActivity()
    }

    @Suppress("DEPRECATION")
    @Nullable
    fun getFragmentManager(): FragmentManager? {
        val activity = getActivity()
        return activity?.fragmentManager
    }

}
