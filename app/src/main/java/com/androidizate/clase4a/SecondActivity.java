package com.androidizate.clase4a;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView bienvenida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String username = getIntent().getStringExtra("username");
        String email = getIntent().getStringExtra("email");

        bienvenida = (TextView) findViewById(R.id.tv_bienvenida);

        bienvenida.setText(String.format(getString(R.string.mensaje_bienvenida), username, email));
    }
}
