package com.example.cice.myapplication;

import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);

        //Refencia a los widgets

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButton radioLondon = (RadioButton) findViewById(R.id.radioButtonLondres);
        RadioButton radioBeijing = (RadioButton) findViewById(R.id.radioButtonBeijing);
        RadioButton radioNuevaYork = (RadioButton) findViewById(R.id.radioButtonNuevaYork);
        final EditText texto = (EditText) findViewById(R.id.editText);
        final Button boton = (Button) findViewById(R.id.button2);
        final TextClock clock = (TextClock) findViewById(R.id.textClock);

        final CheckBox checkTransparencia = (CheckBox) findViewById(R.id.checkBoxTransparencia);
        final CheckBox checkTint = (CheckBox) findViewById(R.id.checkBoxTint);
        final CheckBox checkResize = (CheckBox) findViewById(R.id.checkBoxResize);
        final ImageView imagen = (ImageView) findViewById(R.id.imageView);

        Switch switchWeb = (Switch) findViewById(R.id.switchWeb);
        final WebView webView = (WebView) findViewById(R.id.webView);

        // Eventos

        checkTransparencia.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                imagen.setAlpha(1f);
                if (checkTransparencia.isChecked()) {
                    imagen.setAlpha(.1f);
                }
            }
        });

        checkTint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                imagen.setColorFilter(Color.argb(0,0,0,0));
                if (checkTint.isChecked()) {
                    imagen.setColorFilter(Color.argb(255,255,0,0));
                }
            }
        });

        checkResize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                imagen.setScaleX(1f);
                imagen.setScaleY(1f);
                if (checkResize.isChecked()) {
                    imagen.setScaleX(2f);
                    imagen.setScaleY(2f);
                }
            }
        });

        // Radio Buttons
        //Desmarcar los botones

        radioGroup.clearCheck(); //Cuando Carga la aplicacion los desmarcas
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { //Añadimos un listener que hace es ver cual se activa
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {//Este metodo lo llama cuando llama a alguno de ellos
                RadioButton rb = (RadioButton) radioGroup.findViewById(i);
                switch (rb.getId()){
                    case R.id.radioButtonLondres:
                        clock.setTimeZone("Europe/London");
                        break;
                    case R.id.radioButtonBeijing:
                        clock.setTimeZone("CST6CDT");
                        break;
                    case R.id.radioButtonNuevaYork:
                        clock.setTimeZone("America/New_York");
                        break;

                }
            }
        });
        //Listener al boton
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boton.setText(texto.getText());
            }
        });

        //WebView
        //Cargar web

        webView.loadUrl("http://www.google.es");
        webView.setVisibility(View.INVISIBLE);

        //Listener al switch
        switchWeb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                if(ischecked){
                    webView.setVisibility(View.VISIBLE);
                }
                else {
                    webView.setVisibility(View.INVISIBLE);
                }
            }
        });

    }

}
