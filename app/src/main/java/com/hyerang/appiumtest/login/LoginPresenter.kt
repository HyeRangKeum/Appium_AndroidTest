package com.hyerang.appiumtest.login

import java.util.logging.Handler

class LoginPresenter {

    private var loginView : LoginView? = null

    fun getView(view : LoginView) {
        loginView = view
    }

    fun startLogin() {
        loginView?.showProgress()

        android.os.Handler().postDelayed({

            loginView?.hideProgress()

            var idStatus = false
            var pwStatus = false
            loginView?.getUserId()?.let {
                idStatus = true
            }

            loginView?.getUserPw()?.let {
                pwStatus = true
            }

            if (pwStatus && idStatus) {
                loginView?.successLogin()
            }
        }, 500)

    }

    fun dropView() {
        loginView = null
    }

}