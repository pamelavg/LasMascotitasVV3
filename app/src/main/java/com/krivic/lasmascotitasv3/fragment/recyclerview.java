package com.krivic.lasmascotitasv3.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krivic.lasmascotitasv3.Presentador.IReciclerViewFragmentPresenter;
import com.krivic.lasmascotitasv3.Presentador.ReciclerViewFragmentPresenter;
import com.krivic.lasmascotitasv3.R;
import com.krivic.lasmascotitasv3.adapter.Adaptador;
import com.krivic.lasmascotitasv3.pojo.Mascotas;

import java.util.ArrayList;



public class recyclerview extends Fragment implements IFragmentrecycle {
    private RecyclerView rvMascotas;
    private LinearLayoutManager LLM;
    ArrayList<Mascotas> listaMascotas;
    private IReciclerViewFragmentPresenter iReciclerViewFragment;
    public recyclerview() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_recyclerview,container,false);


        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        iReciclerViewFragment = new ReciclerViewFragmentPresenter(this, getContext());
        iReciclerViewFragment.obtenerMascotaBaseDatos();

        return v;
    }
    public void configuracionLayout(){
        LLM = new LinearLayoutManager(getActivity());
        LLM.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(LLM);
    }


    @Override
    public Adaptador crearAdaptador(ArrayList<Mascotas> mascotas) {

        Adaptador adaptador = new Adaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(Adaptador mascotaAdaptador) {

        rvMascotas.setAdapter(mascotaAdaptador);
    }

    public void CargarMascotas(){
        listaMascotas = new ArrayList<Mascotas>();
        listaMascotas.add(new Mascotas("MascotaE", R.drawable.mascota5, 0,1));
        listaMascotas.add(new Mascotas("MascotaB", R.drawable.mascota2, 0,2));
        listaMascotas.add(new Mascotas("MascotaA", R.drawable.mascota1, 0,3));
        listaMascotas.add(new Mascotas("MascotaC", R.drawable.mascota3, 0,4));
        listaMascotas.add(new Mascotas("MascotaD", R.drawable.mascota4, 0,5));







    }


}
