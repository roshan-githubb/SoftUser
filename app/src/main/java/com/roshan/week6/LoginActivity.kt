package com.roshan.week6

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etname: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)
        etname = findViewById(R.id.etname)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if (TextUtils.isEmpty(etname!!.text)) {
            etname!!.error = "Please enter your username"
            etname!!.requestFocus()
            return
        } else if (TextUtils.isEmpty(etPassword!!.text)) {
            etPassword!!.error = "please enter your password"
            etPassword!!.requestFocus()
            return
        }
        val user = etname!!.text.toString()
        val pwd = etPassword!!.text.toString()
        if (user == "softwarica" && pwd == "coventry") {
            Toast.makeText(applicationContext, "Successfully Login", Toast.LENGTH_LONG).show()
            val dashboard = Intent(this@LoginActivity, MainActivity::class.java)
            startActivity(dashboard)
        } else {
            Toast.makeText(this@LoginActivity, "Login failed", Toast.LENGTH_LONG).show()
        }
        etname!!.setText("")
        etPassword!!.setText("")
        etname!!.visibility = View.VISIBLE
        etname!!.setBackgroundColor(Color.RED)
        etPassword!!.setBackgroundColor(Color.RED)
    }
}