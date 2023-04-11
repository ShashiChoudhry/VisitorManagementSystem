package com.example.visitormanagementsystem

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginForm: AppCompatActivity() {

    private lateinit var id : EditText
    private lateinit var password : EditText


    private lateinit var submit : Button
    private lateinit var forgot : Button

    private var user = "123"
    private var pass = "123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_form)

        id = findViewById(R.id.userField)
        password = findViewById(R.id.passField)

        submit = findViewById(R.id.loginBtn)
        forgot = findViewById(R.id.forgotBtn)

        submit.setOnClickListener()
        {
            var uid = id.text.toString()
            var pas = password.text.toString()

            if(uid.equals(user) && pas.equals(pass)) {
//                Move to LoginForm
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Uid or password does not match", Toast.LENGTH_SHORT).show()
            }
        }
    }


}