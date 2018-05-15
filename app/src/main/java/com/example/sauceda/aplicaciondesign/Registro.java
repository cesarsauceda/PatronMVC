package com.example.sauceda.aplicaciondesign;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sauceda.aplicaciondesign.Modelo.ModeloUsuario;

import java.util.regex.Pattern;

public class Registro extends AppCompatActivity {

    /*
    El Modelo "ModeloUsuario"
    La Clase Registro está actuando como controlador
    Y La Vista es el Layout*/

    TextInputLayout InNombre,InCorreo;
    EditText edtNombre,edtCorreo;
    Button btnIngresar;
    TextView tvMensaje,tvNombre,tvCorreo;

    ModeloUsuario modeloUsuario=new ModeloUsuario();


    public boolean Cor=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        InNombre=findViewById(R.id.InNombre);
        InCorreo=findViewById(R.id.InCorreo);

        tvMensaje=findViewById(R.id.txtmensaje);
        tvNombre=findViewById(R.id.txtNombre);
        tvCorreo=findViewById(R.id.txtCorreo);
        edtNombre=findViewById(R.id.edtNombre);
        edtCorreo=findViewById(R.id.edtCorreo);
        btnIngresar=findViewById(R.id.btnIngresar);

        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrar();
            }
        });


    }
    public void registrar() {

        if(Patterns.EMAIL_ADDRESS.matcher(edtCorreo.getText().toString()).matches()==false){
            InCorreo.setError("Correo Invalido");
        }else{
            InCorreo.setError(null);
            String nombre=edtNombre.getText().toString();
            String correo=edtCorreo.getText().toString();

            //Se Envian los Datos al Modelo
            modeloUsuario.setNombre(nombre);
            modeloUsuario.setCorreo(correo);

            //Se Mandan Los Datos del Modelo Directo a la Vista
            tvNombre.setText(modeloUsuario.getNombre());
            tvCorreo.setText(modeloUsuario.getCorreo());

        }





    }


}

