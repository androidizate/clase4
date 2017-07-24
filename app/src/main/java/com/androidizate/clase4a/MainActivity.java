package com.androidizate.clase4a;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText email;
    EditText password;
    Button ingresar;

    private static final String DEFAULT_PASSWORD = "1234";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.et_username);
        email = (EditText) findViewById(R.id.et_email);
        password = (EditText) findViewById(R.id.et_password);
        ingresar = (Button) findViewById(R.id.bt_login);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ingresar();
            }
        });
    }

    private void ingresar() {
        if (isEmpty(username.getText().toString().trim())) {
            mostrarError(getString(R.string.error_usuario));
        } else if (isEmpty(email.getText().toString().trim())) {
            mostrarError(getString(R.string.error_email));
        } else if (!DEFAULT_PASSWORD.equals(password.getText().toString().trim())) {
            mostrarError(getString(R.string.error_password));
        } else {
            abrirSecondActivity();
        }
    }

    private void abrirSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        // ponemos "extras" en el bundle para acceder desde la segunda activity
        intent.putExtra("username", username.getText().toString().trim());
        intent.putExtra("email", email.getText().toString().trim());
        startActivity(intent);
    }

    private void mostrarError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }
}
