package com.js.pruebatecnica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    EditText EtNombre,EtCedula,EtEmail,EtTelefono;
    Button BtnRegistrar,BtnBuscar;
    DatabaseReference databaseReference;
    String nombre,identificacion,email,telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ComunicacionGrafica();

        BtnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    saveuser();

            }
        });
        BtnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,BuscarDatos.class);
                startActivity(i);
            }
        });
    }
    private void EditText(){
        // EXTRAER TEXTO DE LOS EDIT TEXT
        nombre=EtNombre.getText().toString();
        identificacion=EtCedula.getText().toString();
        email=EtEmail.getText().toString();
        telefono=EtTelefono.getText().toString();

    }
     private void saveuser(){
         EditText();
         databaseReference= FirebaseDatabase.getInstance().getReference();
         HashMap<String,String>user = new HashMap<>();
         user.put("Nombre",nombre);
         user.put("Identificacion",identificacion);
         user.put("Email",email);
         user.put("Telefono",telefono);

        //GUARDAR DATOS EN FIREBASE DATA BASE
         if(!nombre.isEmpty()&&!identificacion.isEmpty()&&!email.isEmpty()&&!telefono.isEmpty()){
        databaseReference.child("Usuarios").push().setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(MainActivity.this,"REGISTRO EXITOSO",Toast.LENGTH_SHORT).show();
                }
            }
        });
         }
    }
    private void ComunicacionGrafica(){
        EtNombre=findViewById(R.id.nombre);
        EtCedula=findViewById(R.id.identificacion);
        EtEmail=findViewById(R.id.email);
        EtTelefono=findViewById(R.id.telefono);
        BtnRegistrar=findViewById(R.id.registrar);
        BtnBuscar=findViewById(R.id.buscar);

    }
}