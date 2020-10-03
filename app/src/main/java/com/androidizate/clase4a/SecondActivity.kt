package com.androidizate.clase4a

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import java.lang.String.format

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // recuperamos los extras de la activity anterior
        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        // le seteamos formateado el string al textview de bienvenida
        tv_welcome.text = format(getString(R.string.welcome_message), username, email)
    }
}