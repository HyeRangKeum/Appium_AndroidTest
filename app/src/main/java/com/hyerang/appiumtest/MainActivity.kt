package com.hyerang.appiumtest

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
        resultButton.setOnClickListener {
            mainPresenter.resultButtonClicked()
        }

        resetButton.setOnClickListener {
            mainPresenter.resetButtonClicked()
        }
    }

    override fun showResultButtonClickedText() {
        resultTextView.text = "Button Clicked!"
    }

    override fun showResetButtonClickedText() {
        resultTextView.text = "Not Button Clicked"
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.dropView()
    }
}
