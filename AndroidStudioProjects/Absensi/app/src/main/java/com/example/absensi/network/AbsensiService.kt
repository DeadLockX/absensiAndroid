package com.example.absensi.network

import com.example.absensi.activity.login.ResultLogin
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface AbsensiService {
    @FormUrlEncoded
    @POST("users/read.php")
    fun loginUser(
        @Field("username") username: String?,
        @Field("password") password: String?
    ): Call<ResultLogin>

    @FormUrlEncoded
    @POST("users/create.php")
    fun addRegister(
        @Field("id_user") id_user:Int?,
        @Field("username") username: String?,
        @Field("password") password: String?,
        @Field("hp") hp:String?

    )

}