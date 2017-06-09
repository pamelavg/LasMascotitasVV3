package com.krivic.lasmascotitasv3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.krivic.lasmascotitasv3.R.id.txtNombre;

public class Contacto extends AppCompatActivity {

    Toolbar actionBar;
    private TextView txNombre;
    private TextView txEmail;
    private TextView txDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
        toolbar(actionBar);

    }

    public void mensajeEnviado(View v){

        Toast.makeText(v.getContext(), "Comentario enviado", Toast.LENGTH_SHORT).show();
        txNombre=(EditText) findViewById(txtNombre);
        txDescripcion=(EditText)findViewById(R.id.txtMensaje);
        txEmail=(EditText)findViewById(R.id.txtCorreo);

        txNombre.setText("");
        txDescripcion.setText("");
        txEmail.setText("");
    }

    public void irMascotas(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void toolbar(Toolbar miActionBar) {
        miActionBar = (Toolbar) findViewById(R.id.toolB2);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        miActionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}


