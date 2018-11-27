package com.hyerang.appiumtest.login

interface LoginView {

    fun showProgress()
    fun hideProgress()

    fun getUserId() : String?
    fun getUserPw() : String?

    fun showError(error : String)
}