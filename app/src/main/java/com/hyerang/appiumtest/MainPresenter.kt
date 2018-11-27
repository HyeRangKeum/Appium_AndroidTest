package com.hyerang.appiumtest

class MainPresenter {

    private var mainView : MainView? = null

    fun getView(view : MainView) {
        mainView = view
    }


    fun startLoginActivity() {
        mainView?.showLoginActivity()
    }

    fun dropView() {
        mainView = null
    }

}