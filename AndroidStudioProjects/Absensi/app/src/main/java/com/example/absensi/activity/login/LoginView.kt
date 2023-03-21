package com.example.absensi.activity.login

import com.example.absensi.model.User

interface LoginView {
    fun onSuccessLogin(user: User?)
    fun onErrorLogin(msg:String?)
}