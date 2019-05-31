package com.example.carfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class QuantidadeLitros extends AppCompatActivity implements View.OnClickListener {
    private QuantidadeLitros.ViewHolder mViewHolder = new ViewHolder();
    private EditText valorAbastecido, precoCombustivel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quantidade_litros);
        // Desativa nome do Aplicativo no Topo.
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Mostrar icone no lugar de Texto.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Define qual icone vai aparecer.
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mViewHolder.buttonCALC_QuantidadeLitros = findViewById(R.id.button_CALC_QuantidadeLitros);
        this.mViewHolder.buttonCALC_QuantidadeLitros.setOnClickListener(this);

        valorAbastecido = (EditText) findViewById(R.id.Edittext_ValorAbastecido);
        precoCombustivel = (EditText) findViewById(R.id.Edittext_precoCombustivel);

    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.button_CALC_QuantidadeLitros) {
            //Logica do Botão
            float valorabastecido = Float.parseFloat(valorAbastecido.getText().toString());
            float precocombustivel = Float.parseFloat(precoCombustivel.getText().toString());
            DecimalFormat formatador = new DecimalFormat("0.00");
            float resultado = valorabastecido / precocombustivel;
            //Toast.makeText(this,"A quantidade de Litros Abastecido é: " + resultado + " Litros",Toast.LENGTH_LONG).show();

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("");
            builder.setMessage("A quantidade de Litros Abastecido é: " + formatador.format(resultado) + " Litros");
            builder.setPositiveButton("OK", null);
            AlertDialog dialog = builder.create();
            dialog.show();
        }
    }

    public class ViewHolder {
        Button buttonCALC_QuantidadeLitros;
    }
}
