package com.example.hrido.mvptest.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

import com.example.hrido.mvptest.Controller.ILoginPresenter
import com.example.hrido.mvptest.Presenter.LoginPresenter
import com.example.hrido.mvptest.Controller.ILoginView
import com.example.hrido.mvptest.R

import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(), ILoginView {

    internal lateinit var edit_email: EditText
    internal lateinit var edit_password: EditText
    internal lateinit var btn_login: Button
    internal lateinit var loginPresenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Init view
        btn_login = findViewById<View>(R.id.btn_login) as Button
        edit_email = findViewById<View>(R.id.edit_email) as EditText
        edit_password = findViewById<View>(R.id.edit_password) as EditText
        //Init
        loginPresenter = LoginPresenter(this)
        //Event
        btn_login.setOnClickListener { loginPresenter.onLogin(edit_email.text.toString(), edit_password.text.toString()) }
    }


    override fun onLoginSuccess(message: String) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginError(message: String) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show()
    }
}
