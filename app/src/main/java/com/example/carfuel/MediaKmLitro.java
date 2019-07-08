package com.example.carfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MediaKmLitro extends AppCompatActivity implements View.OnClickListener {
    private MediaKmLitro.ViewHolder mViewHolder= new ViewHolder();
    private EditText valorKM,quantidadeCombustivel;


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

        this.mViewHolder.buttonCalcMediaKmLitros = findViewById(R.id.button_calc_Media_percurso);
        this.mViewHolder.buttonCalcMediaKmLitros.setOnClickListener(this);
        valorKM = (EditText) findViewById(R.id.Edittext_kmRodado);
        quantidadeCombustivel = (EditText) findViewById(R.id.Edittext_LitrosAbastecido);

    }

    public void onClick(View vKM) {
        int id = vKM.getId();
        if (valorKM.getText().toString().equals("0")){
            Toast.makeText(this,"O valor não pode ser Zero",Toast.LENGTH_LONG).show();
        }
        if (quantidadeCombustivel.getText().toString().equals("0")){
            Toast.makeText(this,"O valor não pode ser Zero",Toast.LENGTH_LONG).show();
        }

        if (valorKM.getText().toString().isEmpty()){
            Toast.makeText(this,"Insira o valor no Campo KM Rodado",Toast.LENGTH_LONG).show();
        }
        else if (quantidadeCombustivel.getText().toString().isEmpty()){
            Toast.makeText(this,"Insira o valor no Campo Quantidade Litros Abastecido",Toast.LENGTH_LONG).show();
        }

        else if (id == R.id.button_calc_Media_percurso) {
            //Logica do Botão
            try {
                float valor_KM = Float.parseFloat(valorKM.getText().toString());
                float quantidadeLitros= Float.parseFloat(quantidadeCombustivel.getText().toString());
                DecimalFormat formatador = new DecimalFormat("0.00");
                float resultado = valor_KM / quantidadeLitros;

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("");
                    builder.setMessage("Seu Veículo está Fazendo uma Média de: " + resultado + " KM por Litro");
                    builder.setPositiveButton("OK", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();

            }catch (Exception errorbyzero){
                Toast.makeText(this,"Não Podemos Dividir por ZERO",Toast.LENGTH_LONG).show();
            }
        }



    }
    public class ViewHolder {
        Button buttonCalcMediaKmLitros;
    }
}
