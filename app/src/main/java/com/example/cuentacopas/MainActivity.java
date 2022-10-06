package com.example.cuentacopas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String NOMBRE = "NOMBRE";
    public static final int CODIGO = 24;
    TextView NumeroAmigos;
    TextView NumeroCopas;
    Button btnEmpezar;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CODIGO && resultCode == RESULT_OK){

            String numero = data.getStringExtra(MainActivity2.NUMERO);

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumeroAmigos = findViewById(R.id.editTextNamigos);
        NumeroCopas = findViewById(R.id.editTextNcopas);
        btnEmpezar = findViewById(R.id.buttonEmpezar);

        btnEmpezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int namigos = Integer.parseInt(NumeroAmigos.getText().toString());
                int ncopas = Integer.parseInt(NumeroCopas.getText().toString());

                if (namigos > ncopas){

                    Toast toast = Toast.makeText(getApplicationContext(), "La cantidad de copas nos puede superar la cantidad de amigos", Toast.LENGTH_LONG);
                    toast.show();

                }else {

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra(NOMBRE, namigos);
                    intent.putExtra(NOMBRE, ncopas);
                    startActivityForResult(intent, CODIGO);

                }

            }
        });

    }
}