package com.robertormzg.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.robertormzg.petagram.pojo.Email;

public class Contacto extends AppCompatActivity {

    private TextInputEditText nombre;
    private TextInputEditText correo;
    private TextInputEditText mensaje;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = findViewById(R.id.edtNombre);
        correo = findViewById(R.id.edtCorreo);
        mensaje = findViewById(R.id.edtMensaje);
    }

    public void onClickBtnSubmit(View v){
        String to = correo.getText().toString();
        String subject = "Mensaje de "+nombre.getText().toString();
        String body = mensaje.getText().toString();

        try {
            if(to.isEmpty()){
                Toast.makeText(Contacto.this, "Escribe un correo electrónico valido", Toast.LENGTH_LONG).show();
            }else if(nombre.getText().toString().isEmpty()){
                Toast.makeText(Contacto.this, "Escribe tu nombre", Toast.LENGTH_LONG).show();
            }else if(body.isEmpty()){
                Toast.makeText(Contacto.this, "Escribe un mensaje", Toast.LENGTH_LONG).show();
            }else {
                new Email().sendEmail(to, subject, body);
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
            }
        } catch (Exception e) {
            Toast.makeText(Contacto.this, "Error: "+e.getMessage(), Toast.LENGTH_LONG).show();
            System.out.println("Exception: "+ e.getMessage());
            e.printStackTrace();
        }

    }
}