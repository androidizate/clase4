package com.androidizate.clase4a

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // seteamos la accion al presion al boton de login
        bt_login.setOnClickListener { login() }
    }

    private fun login() {
        if (et_username.text.toString().trim().isEmpty()) { // si el edittext de username es vacio, entonces mostramos un error
            displayError(getString(R.string.user_error))
        } else if (et_email.text.toString().trim().isEmpty()) { // si el edittext de email es vacio, entonces mostramos un error
            displayError(getString(R.string.email_error))
        } else if (DEFAULT_PASSWORD != et_password.text.toString().trim()) { // si el password no es igual al DEFAULT, entonces mostramos un error
            displayError(getString(R.string.error_password))
        } else {
            openSecondActivity() // si la info completa es correcta navegamos a la segunda activity
        }
    }

    private fun openSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        // ponemos "extras" en el bundle para acceder desde la segunda activity
        intent.putExtra("username", et_username.text.toString().trim())
        intent.putExtra("email", et_email.text.toString().trim())
        // iniciamos la activity
        startActivity(intent)
        // si no queremos volver al login agregamos el finish()
        // finish()
    }

    private fun displayError(string: String) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val DEFAULT_PASSWORD = "1234"
    }
}