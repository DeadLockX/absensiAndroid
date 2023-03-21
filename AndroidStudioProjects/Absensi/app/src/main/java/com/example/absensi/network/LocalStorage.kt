package com.example.absensi.network

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

class LocalStorage(context: Context) {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: Editor
    lateinit var context: Context

    init {
        this.context=context
        sharedPreferences=context.getSharedPreferences("STORAGE_LOGIN_API", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }
    fun setIdUser(id_user:Int){
        editor.putInt("ID_USER", id_user)
        editor.commit()
    }

    fun getIdUser():Int{
        return sharedPreferences.getInt("ID_USER", 0)
    }

    fun setUsername(username:String){
        editor.putString("USERNAME", username)
        editor.commit()
    }
    fun getUsername():String?{
        return sharedPreferences.getString("USERNAME","")
    }
    fun deleteAll(){
        editor.clear()
        editor.commit()
    }

}