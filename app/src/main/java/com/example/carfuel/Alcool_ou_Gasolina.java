package com.example.carfuel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Alcool_ou_Gasolina extends AppCompatActivity implements View.OnClickListener{
    private Alcool_ou_Gasolina.ViewHolder mViewHolder = new ViewHolder();
    private EditText valorAlcool,valorGasolina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcool_ou__gasolina);
        // Desativa nome do Aplicativo no Topo.
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //Mostrar icone no lugar de Texto.
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //Define qual icone vai aparecer.
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        this.mViewHolder.buttonCalcAlcoolGasolina = findViewById(R.id.button_Calc_Alcool_Gasolina);
        this.mViewHolder.buttonCalcAlcoolGasolina.setOnClickListener(this);
        valorAlcool= (EditText) findViewById(R.id.Edittext_ValorAlcool);
        valorGasolina = (EditText) findViewById(R.id.Edittext_ValorGasolina);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (valorAlcool.getText().toString().equals(0)){
            Toast.makeText(this,"O valor não pode ser Zero",Toast.LENGTH_LONG).show();
        }
        if (valorGasolina.getText().toString().equals(0)){
            Toast.makeText(this,"O valor não pode ser Zero",Toast.LENGTH_LONG).show();
        }

        if (valorAlcool.getText().toString().equals("")){
            Toast.makeText(this,"Insira o valor no Campo Preço do Alcool",Toast.LENGTH_LONG).show();
        }
        else if (valorGasolina.getText().toString().equals("")){
            Toast.makeText(this,"Insira o valor no Campo Preço da Gasolina",Toast.LENGTH_LONG).show();
        }

        else if (id == R.id.button_Calc_Alcool_Gasolina) {
            //Logica do Botão
            try {
                float valor_Alcool = Float.parseFloat(valorAlcool.getText().toString());
                float valor_Gasolina = Float.parseFloat(valorGasolina.getText().toString());
                DecimalFormat formatador = new DecimalFormat("0.00");
                float resultado = valor_Alcool / valor_Gasolina;

                if (resultado<0.7){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("");
                    builder.setMessage("É mais vantajoso abastecer com álcool.");
                    builder.setPositiveButton("OK", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }else if (resultado>0.7){
                //Toast.makeText(this,"A quantidade de Litros Abastecido é: " + resultado + " Litros",Toast.LENGTH_LONG).show();

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("");
                builder.setMessage("É mais vantajoso abastecer com Gasolina.");
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
                }

            }catch (Exception errorbyzero){
                Toast.makeText(this,"Não Podemos Dividir por ZERO",Toast.LENGTH_LONG).show();
            }
        }


    }

    public class ViewHolder {
        Button buttonCalcAlcoolGasolina;
    }
}
