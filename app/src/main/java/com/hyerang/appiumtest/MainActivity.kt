package com.hyerang.appiumtest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val mainPresenter: MainPresenter by lazy { MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainPresenter.getView(this)

        setButtonClick()
    }

    private fun setButtonClick() {
        startLoginButton.setOnClickListener {
            mainPresenter.startLoginActivity()
        }
    }


    override fun showLoginActivity() {
        startActivity(Intent())
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.dropView()
    }
}
