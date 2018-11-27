package com.hyerang.appiumtest.login

class LoginPresenter {

    private var loginView : LoginView? = null

    fun getView(view : LoginView) {
        loginView = view
    }

    fun startLogin() {
        loginView?.getUserId()

        loginView?.getUserPw()
    }

    fun dropView() {
        loginView = null
    }

}