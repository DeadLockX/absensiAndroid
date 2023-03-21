package com.example.absensi.model

import com.google.gson.annotations.SerializedName
import javax.annotation.Generated

@Generated("com.robohorse.robopojogenerator")
data class User(

	@field:SerializedName("password")
	var password: String? = null,

	@field:SerializedName("create date")
	var createDate: String? = null,

	@field:SerializedName("hp")
	var hp: String? = null,

	@field:SerializedName("id_user")
	var idUser: Int? = null,

	@field:SerializedName("email")
	var email: String? = null,

	@field:SerializedName("username")
	var username: String? = null
):java.io.Serializable