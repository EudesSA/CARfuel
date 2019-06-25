package com.example.carfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.internal.client.ThinAdSizeParcel;
import com.google.android.gms.maps.SupportMapFragment;

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
        if (valorAbastecido.getText().toString().equals("")){
            Toast.makeText(this,"Insira o valor no Campo Valor Abastecido",Toast.LENGTH_LONG).show();
        }
        else if (precoCombustivel.getText().toString().equals("")){
            Toast.makeText(this,"Insira o valor no Campo Preço do Combustível",Toast.LENGTH_LONG).show();
        }

        else if (id == R.id.button_CALC_QuantidadeLitros) {
            //Logica do Botão
            try {
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

            }catch (Exception errorbyzero){
                Toast.makeText(this,"Não Podemos Dividir por ZERO",Toast.LENGTH_LONG).show();
            }
            }
    }

    public class ViewHolder {
        Button buttonCALC_QuantidadeLitros;
    }
}
