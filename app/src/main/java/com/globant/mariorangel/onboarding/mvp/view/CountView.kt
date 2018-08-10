package com.globant.mariorangel.onboarding.mvp.view

import android.app.Activity
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.globant.mariorangel.onboarding.R
import com.globant.mariorangel.onboarding.util.bus.RxBus
import com.globant.mariorangel.onboarding.util.bus.actions.ButtonUpObserver
import com.globant.mariorangel.onboarding.util.bus.actions.ResetButtonObserver

class CountView : BaseView {

    @BindView(R.id.count_label)
    lateinit var countLabel : TextView

    constructor(activity: Activity) : super(activity) {
        ButterKnife.bind(this, activity)
    }

    fun setCount(count: String) { countLabel.text = count }

    @OnClick(R.id.count_button)
    fun onClickCount() {
        RxBus.post(ButtonUpObserver.OnButtonUpPressed())
    }

    @OnClick(R.id.reset_button)
    fun onClickReset() {
        RxBus.post(ResetButtonObserver.OnResetButtonPressed())
    }

}
