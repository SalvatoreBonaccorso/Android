package com.example.salvatorebonaccorso.esercitazione04_12_2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    // dichiarazioni delle variabili
    private EditText textInput;
    private Button btnCheck;

    // crea un identificativo univoco che ci servirà a passarlo nell'intent ( package.text )
    public static final String EXTRA_TEXT = "com.example.salvatorebonaccorso.esercitazione04_12_2018.text";
    // dichiariamo un requestCode che serve ad identificare la richiesta univocamente
    private static final int REQUEST_CODE_CHEAT = 1;


    // col metodo oncreate() l’activity viene creata.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // identifichiamo e colleghiamo le nostre variabili con le risorse tramite l'id
        textInput = findViewById(R.id.exercize_text);
        btnCheck = findViewById(R.id.btn_click_me);


        // metto il pulsante in ascolto di un evento
        btnCheck.setOnClickListener(new View.OnClickListener() {

            // e allo stesso tempo ci crea un metodo da riscrivere
            @Override
            public void onClick(View v) {

                // mi creo una variabile a cui associo il contenuto di textInput
                String boxText = textInput.getText().toString();


                // textUtils è una classe predefinita nell'sdk android che vuole passata una stringa
                // se è presente del testo all'interno della casella di testo,lo mostro nella seconda activity
                if(!TextUtils.isEmpty(boxText))
                {
                    // se il testo è presente faccio il casting della stringa boxText a un intero
                    // e questo cast si mette all'interno del listener e fuori dall'intent .
                    int insertOfNumber = Integer.parseInt(boxText);

                    // definisco l'intenzione di passare dalla prima activity alla seconda
                    Intent openPage2 = new Intent(MainActivity.this,Main2Activity.class);
                    // aggiungo ad openPage2 (sul quale stiamo richiamando il metodo) un dato
                    openPage2.putExtra(EXTRA_TEXT,insertOfNumber);
                    // il requestCode serve ad identificare la richiesta
                    startActivityForResult(openPage2,REQUEST_CODE_CHEAT);

                    /*
                    // avvio la seconda activity
                    startActivity(openPage2);
                    */
                }
                // altrimenti se il campo di testo è vuoto mando un messaggio
                else{
                    Toast toast =Toast.makeText(MainActivity.this,R.string.error_text,Toast.LENGTH_SHORT);
                    // modo per mettere il messaggio in alto a sinistra anzicchè basso al centro
                    toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
                    toast.show();
                }
            }
        });
    }
    // Implementazione del metodo onActivityResult
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_CODE_CHEAT) {
            if(resultCode == RESULT_OK){
                int result=data.getIntExtra(Main2Activity.EXTRA_RETURNED,0);
                Toast toast2 =Toast.makeText(MainActivity.this, String.valueOf(result),Toast.LENGTH_SHORT);
                toast2.show();
            }
        }
    }
}
