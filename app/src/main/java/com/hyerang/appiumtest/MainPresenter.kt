package com.hyerang.appiumtest

class MainPresenter {

    private var mainView : MainView? = null

    fun getView(view : MainView) {
        mainView = view
    }

    fun resultButtonClicked() {
        mainView?.showResultButtonClickedText()
    }

    fun resetButtonClicked() {
        mainView?.showResetButtonClickedText()
    }

    fun dropView() {
        mainView = null
    }

}