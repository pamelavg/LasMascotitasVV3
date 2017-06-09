package com.krivic.lasmascotitasv3.fragment;

import com.krivic.lasmascotitasv3.adapter.Adaptador;
import com.krivic.lasmascotitasv3.pojo.Mascotas;

import java.util.ArrayList;



public interface IFragmentrecycle {
    public void configuracionLayout();

    public Adaptador crearAdaptador(ArrayList<Mascotas> mascotas);

    public void inicializarAdaptadorRV(Adaptador contactoAdaptador);
}
