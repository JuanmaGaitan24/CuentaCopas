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
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    public static final String NUMERO = "NUMERO";

    TextView Ncopas;
    TextView TamText;
    SeekBar BarraTam;
    ScrollView ListAmigos;

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

        Intent intent = getIntent();

        int copas = Integer.parseInt(intent.getStringExtra(MainActivity.COPAS));
        int amigos = Integer.parseInt(intent.getStringExtra(MainActivity.AMIGOS));

        Ncopas.setText(Ncopas.getText() + " " + copas);
        TamText.setText(TamText.getText() + " " + BarraTam.getProgress());

        AdaptadorAmigos adaptadoramigos = new AdaptadorAmigos(this, R.layout.amigo, amigos);



    }

    private class AdaptadorAmigos extends ArrayAdapter<String>{

        public AdaptadorAmigos(@NonNull Context context, int resource, int amigos) {
            super(context, resource);
        }

        @Override
        public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            return rellenarfila(position, convertView, parent);
        }

        private View rellenarfila(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            View miFila = inflater.inflate(R.layout.amigo,parent, false);

            TextView Namigo = findViewById(R.id.textViewAmigo);
            TextView cantcop = findViewById(R.id.textViewCantCop);
            Button sumarcop = findViewById(R.id.buttonMas);
            Button restarcop = findViewById(R.id.buttonMenos);

            return miFila;

        }


    }

}