package com.krivic.lasmascotitasv3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.krivic.lasmascotitasv3.adapter.PerfilAdapter;
import com.krivic.lasmascotitasv3.pojo.Mascotas;

import java.util.ArrayList;



public class Perfil extends Fragment {

    ArrayList<Mascotas> mascotas;
    private RecyclerView listaMascotas;
    public Perfil() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        this.listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotasPerfil);
        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        this.listaMascotas.setLayoutManager(glm);

        this.inicializarListaMascotas();
        this.inicializarAdaptador();

        return v;

    }
    public void inicializarAdaptador(){

        PerfilAdapter adaptador = new PerfilAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }
    public void inicializarListaMascotas(){

        mascotas = new ArrayList<>();
        mascotas.add(new Mascotas("MascotaD", R.drawable.mascota4, 2,5));
        mascotas.add(new Mascotas("MascotaD", R.drawable.mascota4, 5,5));
        mascotas.add(new Mascotas("MascotaD", R.drawable.mascota4, 15,5));
        mascotas.add(new Mascotas("MascotaD", R.drawable.mascota4, 20,5));
        mascotas.add(new Mascotas("MascotaD", R.drawable.mascota4, 25,5));
        mascotas.add(new Mascotas("MascotaD", R.drawable.mascota4, 30,5));

    }
}
