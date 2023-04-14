package com.example.visitormanagementsystem

import android.content.Intent
import android.content.res.TypedArray
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.graphics.drawable.GradientDrawable
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat

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

//        password.setOnTouchListener() {
//
//        }

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

        forgot.setOnClickListener() {
            // https://ums.lpu.in/lpuums/forgetpassword.aspx
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://ums.lpu.in/lpuums/forgetpassword.aspx")

            startActivity(intent)
        }

    }
}
