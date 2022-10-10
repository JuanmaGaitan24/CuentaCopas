package com.example.cuentacopas;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    public static final String NUMERO = "NUMERO";

    LinearLayout listamigos, listbotonmas, listcantidad, listbotonmenos;
    TextView Ncopas;
    TextView TamText;
    SeekBar BarraTam;
    ScrollView ListAmigos;
    Button btnReset;


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
        ListAmigos = findViewById(R.id.ListaAmigos);
        listamigos = findViewById(R.id.filanombre);
        listcantidad = findViewById(R.id.filacantidad);
        listbotonmas = findViewById(R.id.filabotonmas);
        listbotonmenos = findViewById(R.id.filabotonmenos);
        btnReset = findViewById(R.id.buttonReset);

        Intent intent = getIntent();

        int copas = Integer.parseInt(intent.getStringExtra(MainActivity.COPAS));
        int amigos = Integer.parseInt(intent.getStringExtra(MainActivity.AMIGOS));

        for (int i = 0; i < amigos; i++){



            TextView listamigo = new TextView(MainActivity2.this);
            TextView cantcopas = new TextView(MainActivity2.this);
            Button mas = new Button(MainActivity2.this);
            Button menos = new Button(MainActivity2.this);

            listamigo.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            listamigo.setTextColor(getResources().getColor(com.google.android.material.R.color.material_dynamic_primary40));
            listamigo.setPadding(30, 40,0 ,40);
            listamigo.setTextSize(14);
            listamigo.setId(1000 + i);
            listamigo.setText(getString(R.string.amigo) + " " + (i + 1));

            mas.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            mas.setBackground(getResources().getDrawable(R.drawable.flecha_arriba));


            menos.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            menos.setBackground(getResources().getDrawable(R.drawable.flecha_abajo));

            cantcopas.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            cantcopas.setTextColor(getResources().getColor(com.google.android.material.R.color.material_dynamic_primary40));
            cantcopas.setTextSize(14);
            cantcopas.setPadding(20,40,0,40);
            cantcopas.setText("0");
            cantcopas.setId(i);

            listamigos.addView(listamigo);
            listbotonmas.addView(mas);
            listcantidad.addView(cantcopas);
            listbotonmenos.addView(menos);

            mas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String a = (String) Ncopas.getText();
                    String[] division = a.split(" ");
                    int numerocopas = Integer.valueOf(division[2]);

                    if (numerocopas == 0){
                        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.sincopas), Toast.LENGTH_LONG);
                    }else {
                        int can = Integer.valueOf((String) cantcopas.getText());
                        can ++;
                        numerocopas --;
                        Ncopas.setText(getString(R.string.cantidad_copas) + " " + numerocopas);
                        cantcopas.setText(String.valueOf(can));
                    }

                }
            });

            menos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String a = (String) Ncopas.getText();
                    String[] division = a.split(" ");
                    int numerocopas = Integer.valueOf(division[2]);
                    int can = Integer.valueOf((String) cantcopas.getText());

                    if (numerocopas == copas || can == 0){

                        Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.notienescopas), Toast.LENGTH_LONG);

                    }else {

                        can --;
                        numerocopas ++;
                        Ncopas.setText(getString(R.string.cantidad_copas) + " " + numerocopas);
                        cantcopas.setText(String.valueOf(can));

                    }

                }
            });

        }

        Ncopas.setText(getString(R.string.cantidad_copas) + " " + copas);
        TamText.setText(getString(R.string.TamText) + " " + BarraTam.getProgress());

        BarraTam.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               TamText.setText(getString(R.string.TamText) + " " + BarraTam.getProgress());

               for (int y = 0; y < amigos; y++){

                   TextView nombre = findViewById(1000 + y);
                   TextView catidad = findViewById(y);
                   nombre.setTextSize(BarraTam.getProgress());
                   catidad.setTextSize(BarraTam.getProgress());

               }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int y = 0; y < amigos; y++){

                    TextView catidad = findViewById(y);
                    TextView amigo = findViewById(1000 + y);
                    catidad.setText(String.valueOf(0));
                    catidad.setTextSize(14);
                    amigo.setTextSize(14);

                }

                Ncopas.setText(getString(R.string.cantidad_copas) + " " + copas);
                BarraTam.setProgress(14);
                TamText.setText(getString(R.string.TamText) + " " + 14);

            }
        });

    }

}