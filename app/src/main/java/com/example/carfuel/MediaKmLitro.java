package com.example.carfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MediaKmLitro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_km_litro);
        // Desativa nome do Aplicativo no Topo.
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Mostrar icone no lugar de Texto.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Define qual icone vai aparecer.
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }
}
