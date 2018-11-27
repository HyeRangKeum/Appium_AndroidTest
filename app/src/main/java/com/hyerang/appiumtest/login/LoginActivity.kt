package com.hyerang.appiumtest.login

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.hyerang.appiumtest.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginView {

    private val loginPresenter: LoginPresenter by lazy { LoginPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter.getView(this)

        setLoginButton()
    }

    private fun setLoginButton() {
        loginButton.setOnClickListener {
            loginPresenter.startLogin()
        }
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }

    override fun getUserId(): String? {
        val userId =  inputIDEditText.text.trim().toString()

        if (TextUtils.isEmpty(userId)) {
            showError("아이디를 입력해주세요")
            return null
        }

        return userId
    }

    override fun getUserPw(): String? {
        val userPw = inputPWEditText.text.trim().toString()

        if (TextUtils.isEmpty(userPw)) {
            showError("비밀번호를 입력해주세요")
            return null
        }

        return userPw
    }

    override fun showProgress() {
        loginProgress.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        loginProgress.visibility = View.GONE
    }

    override fun onDestroy() {
        super.onDestroy()

        loginPresenter.dropView()
    }

}