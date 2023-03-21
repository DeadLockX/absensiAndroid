package com.example.absensi.activity.login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.absensi.MainActivity
import com.example.absensi.R
import com.example.absensi.model.User
import com.example.absensi.network.LocalStorage

class LoginActivity :AppCompatActivity(), LoginView {

    private lateinit var btnLogin: Button
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById<EditText>(R.id.etLoginUsername)
        etPassword = findViewById<EditText>(R.id.etLoginPassword)
        btnLogin = findViewById<Button>(R.id.btn_login)
        btnRegister = findViewById<Button>(R.id.btn_registrasi)

        val sesi = LocalStorage(this)
        if(sesi.getUsername() !=""){
            val intent =Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        initActionButton()

    }
    fun initActionButton(){
        btnLogin.setOnClickListener {
            val user = User()
            user.username = etUsername.text.toString().trim()
            user.password = etPassword.text.toString().trim()

            LoginPresenter(this@LoginActivity).login(user)
        }
    }
    override fun onSuccessLogin(user:User?){
        val sesi = LocalStorage(this)
        sesi.setIdUser(user?.idUser!!.toInt())
        sesi.setUsername(user.username.toString())

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onErrorLogin(msg:String?){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}