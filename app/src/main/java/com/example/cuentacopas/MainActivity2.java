package com.example.cuentacopas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static final String NUMERO = "NUMERO";

    TextView Ncopas;
    TextView Namigos;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String copas = intent.getStringExtra(MainActivity.COPAS);
        int amigos = Integer.parseInt(intent.getStringExtra(MainActivity.AMIGOS));



    }
}