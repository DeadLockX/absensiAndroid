package com.example.absensi.activity.login

import com.example.absensi.model.User
import com.example.absensi.network.NetworkConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(var loginView: LoginView) {

    fun login(user: User) {
        NetworkConfig.service()
            .loginUser(user.username, user.password)
            .enqueue(object : Callback<ResultLogin> {
                override fun onResponse(call: Call<ResultLogin>, response: Response<ResultLogin>) {
                    val body = response.body()

                    if (body?.status == "200") {
                        loginView.onSuccessLogin(body?.user as User?)
                    } else {
                        loginView.onErrorLogin(body?.message)
                    }
                }
                override fun onFailure(call: Call<ResultLogin>, t: Throwable) {
                    loginView.onErrorLogin(t.localizedMessage)
                }

            })

    }

}