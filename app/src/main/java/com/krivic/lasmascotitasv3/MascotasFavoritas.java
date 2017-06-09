package com.krivic.lasmascotitasv3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.krivic.lasmascotitasv3.Presentador.IReciclerViewFragmentPresenter;
import com.krivic.lasmascotitasv3.Presentador.ReciclerViewFragmentPresenter;
import com.krivic.lasmascotitasv3.adapter.Adaptador;
import com.krivic.lasmascotitasv3.fragment.IFragmentrecycle;
import com.krivic.lasmascotitasv3.pojo.Mascotas;

import java.util.ArrayList;



public class MascotasFavoritas extends AppCompatActivity implements IFragmentrecycle {
    ArrayList<Mascotas> mascotasFavoritas;
    private RecyclerView listaMascotasFavoritas;
    private LinearLayoutManager LLM;
    private IReciclerViewFragmentPresenter iReciclerViewFragment;
    Toolbar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotasfavoritas);

        toolbar(actionBar);


       this.listaMascotasFavoritas = (RecyclerView) findViewById(R.id.rvMascotasFav);

        iReciclerViewFragment = new ReciclerViewFragmentPresenter(this, getBaseContext());
        iReciclerViewFragment.obtenerMascotaFavoritaBaseDatos();

    }

    public void configuracionLayout(){
        LLM = new LinearLayoutManager(this);
        LLM.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFavoritas.setLayoutManager(LLM);
    }

    @Override
    public Adaptador crearAdaptador(ArrayList<Mascotas> mascotas) {

        Adaptador adaptador = new Adaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(Adaptador mascotaAdaptador) {

        listaMascotasFavoritas.setAdapter(mascotaAdaptador);
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

