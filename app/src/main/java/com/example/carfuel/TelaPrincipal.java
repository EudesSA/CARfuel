package com.example.carfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TelaPrincipal extends AppCompatActivity implements View.OnClickListener {
    private  ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Desativa nome do Aplicativo no Topo.
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Mostrar icone no lugar de Texto.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Define qual icone vai aparecer.
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mViewHolder.buttonConsumo_percurso = findViewById(R.id.button_consumo_percurso);
        this.mViewHolder.buttonConsumo_percurso.setOnClickListener(this);
        this.mViewHolder.buttonMediaKmLitro = findViewById(R.id.button_media_km);
        this.mViewHolder.buttonMediaKmLitro.setOnClickListener(this);
        this.mViewHolder.buttonAlcool_Gasolina = findViewById(R.id.button_gasolinaOUalcool);
        this.mViewHolder.buttonAlcool_Gasolina.setOnClickListener(this);
        this.mViewHolder.buttonQuantidadeLitros = findViewById(R.id.button_quantidadeLitros);
        this.mViewHolder.buttonQuantidadeLitros.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_consumo_percurso) {
            //Logica do Botão
            Intent intent = new Intent(this, QuantoGastoKm.class);
            startActivity(intent);
        }else if (id == R.id.button_media_km) {
            //Logica do Botão
            Intent intent = new Intent(this, MediaKmLitro.class);
            startActivity(intent);
        }else if (id == R.id.button_gasolinaOUalcool) {
            //Logica do Botão
            Intent intent = new Intent(this, Alcool_ou_Gasolina.class);
            startActivity(intent);
        }else if (id == R.id.button_quantidadeLitros) {
            //Logica do Botão
            Intent intent = new Intent(this, QuantidadeLitros.class);
            startActivity(intent);
        }

    }

    private static class ViewHolder {
        Button buttonConsumo_percurso;
        Button buttonMediaKmLitro;
        Button buttonAlcool_Gasolina;
        Button buttonQuantidadeLitros;
    }
}
