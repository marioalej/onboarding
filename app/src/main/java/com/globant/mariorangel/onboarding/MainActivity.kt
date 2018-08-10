package com.globant.mariorangel.onboarding

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.globant.mariorangel.onboarding.mvp.model.CountModel
import com.globant.mariorangel.onboarding.mvp.presenter.CountPresenter
import com.globant.mariorangel.onboarding.mvp.view.CountView

class MainActivity : AppCompatActivity() {

    private lateinit var presenter: CountPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = CountPresenter(CountModel(), CountView(this))
    }

    override fun onPause() {
        super.onPause()
        presenter.unregister()
    }

    override fun onResume() {
        super.onResume()
        presenter.register()
    }
}
