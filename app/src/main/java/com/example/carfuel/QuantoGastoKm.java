package com.example.carfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class QuantoGastoKm extends AppCompatActivity implements View.OnClickListener{
    private QuantoGastoKm.ViewHolder mViewHolder = new ViewHolder();
    private EditText valorKmPorLitro,distanciaPercorrida,valorCombustivel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quanto_gasto_km);
        // Desativa nome do Aplicativo no Topo.
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Mostrar icone no lugar de Texto.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Define qual icone vai aparecer.
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mViewHolder.buttonCalcQuantoGastoKm = findViewById(R.id.button_calc_consumo_percurso);
        this.mViewHolder.buttonCalcQuantoGastoKm.setOnClickListener(this);
        valorKmPorLitro = (EditText) findViewById(R.id.Edittext_KM_por_LITRO);
        distanciaPercorrida = (EditText) findViewById(R.id.Edittext_KM_PERCORRIDA);
        valorCombustivel = (EditText) findViewById(R.id.Edittext_Valor_COMBUSTIVEL);


    }

    public void onClick(View vQuantoGastoKm) {
        int id = vQuantoGastoKm.getId();
            if (valorKmPorLitro.getText().toString().equals("0")){
                Toast.makeText(this,"O valor não pode ser Zero",Toast.LENGTH_LONG).show();
            }
            if (valorCombustivel.getText().toString().equals("0")){
                Toast.makeText(this,"O valor não pode ser Zero",Toast.LENGTH_LONG).show();
            }
            if (distanciaPercorrida.getText().toString().equals("0")){
                Toast.makeText(this,"O valor não pode ser Zero",Toast.LENGTH_LONG).show();
            }

        if (valorKmPorLitro.getText().toString().isEmpty()){
            Toast.makeText(this,"Insira o valor no Campo Consumo do Veículo por Litro 'km / Litro'",Toast.LENGTH_LONG).show();
        }
        else if  (distanciaPercorrida.getText().toString().isEmpty()){
            Toast.makeText(this,"Insira o valor no Campo Distância a Percorrer",Toast.LENGTH_LONG).show();
        }
        else if (valorCombustivel.getText().toString().isEmpty()){
            Toast.makeText(this,"Insira o valor no Campo Valor do Litro de Combustível",Toast.LENGTH_LONG).show();
        }

        else if (id == R.id.button_calc_consumo_percurso) {
            //Logica do Botão
            try {
                float valor_KMporLitro = Float.parseFloat(valorKmPorLitro.getText().toString());
                float valor_Combustivel= Float.parseFloat(valorCombustivel.getText().toString());
                float distantia_Percorrida= Float.parseFloat(distanciaPercorrida.getText().toString());
                DecimalFormat formatador = new DecimalFormat("0.00");
                float resultado1 = distantia_Percorrida / valor_KMporLitro;
                float resultado2 = resultado1 * valor_Combustivel;

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("");

                builder.setMessage("Para percorrer a distância especificada você vai precisar de: " + formatador.format(resultado1)
                                   + "Lt de combustível." + " Gastando R$ " + formatador.format(resultado2) + " Reais.");

                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();

            }catch (Exception errorbyzero){
                Toast.makeText(this,"Não Podemos Dividir por ZERO",Toast.LENGTH_LONG).show();
            }
        }

    }

    public class ViewHolder {
        Button buttonCalcQuantoGastoKm;
    }
}
