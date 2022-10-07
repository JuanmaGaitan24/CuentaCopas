package com.example.cuentacopas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static final String NUMERO = "NUMERO";

    TextView Ncopas;
    TextView TamText;
    SeekBar BarraTam;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Ncopas = findViewById(R.id.TextViewCantCopas);
        TamText = findViewById(R.id.textViewTamText);
        BarraTam = findViewById(R.id.seekBarTamanno);

        Intent intent = getIntent();

        int copas = Integer.parseInt(intent.getStringExtra(MainActivity.COPAS));
        int amigos = Integer.parseInt(intent.getStringExtra(MainActivity.AMIGOS));

        Ncopas.setText(Ncopas.getText() + " " + copas);
        TamText.setText(TamText.getText() + " " + BarraTam.getProgress());



    }
}