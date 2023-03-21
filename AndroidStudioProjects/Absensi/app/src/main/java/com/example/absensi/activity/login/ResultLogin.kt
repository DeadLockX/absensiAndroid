package com.example.absensi.activity.login

import com.example.absensi.model.User
import com.google.gson.annotations.SerializedName

data class ResultLogin(

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("user")
	val user: Any? = null,

	@field:SerializedName("users")
	val users: List<User?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)