package com.example.salvatorebonaccorso.esercitazione04_12_2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity  {

    private TextView textOutput;
    private Button btnBack;

    // crea un identificativo univoco che ci servirà a passarlo nell'intent ( package.text )
    public static final String EXTRA_RETURNED = "com.example.salvatorebonaccorso.esercitazione04_12_2018.returned";

    // col metodo oncreate() l’activity viene creata.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // identifichiamo e colleghiamo le nostre variabili con le risorse tramite l'id
        textOutput = findViewById(R.id.text);
        btnBack = findViewById(R.id.btn_back);

        // assegnamo alla variabile output
        // il metodo getIntent che ci restituisce un extra di tipo int precedentemente settato
        final int output=getIntent().getIntExtra(MainActivity.EXTRA_TEXT, 0);
        // setto la stringa che rappresentano interi (output)
        textOutput.setText(String.valueOf(output));


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int finalNumber = output*10;
                // mi creo un nuovo Intent vuoto che mi permette di tornare indietro
                Intent returned = new Intent();
                returned.putExtra(EXTRA_RETURNED, finalNumber);
                setResult(RESULT_OK, returned);
                finish();

        /*// il metodo finish distrugge l'activity e ritorna a quella precedente se c'è se no esce dall'app
        finish();*/

            }
        });



    }
}
