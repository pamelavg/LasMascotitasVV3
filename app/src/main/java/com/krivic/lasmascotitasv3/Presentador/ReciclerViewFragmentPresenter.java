package com.krivic.lasmascotitasv3.Presentador;

import android.content.Context;

import com.krivic.lasmascotitasv3.DB.ConstructorMascotas;
import com.krivic.lasmascotitasv3.fragment.IFragmentrecycle;
import com.krivic.lasmascotitasv3.pojo.Mascotas;

import java.util.ArrayList;


public class ReciclerViewFragmentPresenter implements IReciclerViewFragmentPresenter {

    private IFragmentrecycle iFragmentHome;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    ArrayList<Mascotas> mascotas;

    public ReciclerViewFragmentPresenter(IFragmentrecycle iFragmentHome, Context context) {

        this.iFragmentHome = iFragmentHome;
        this.context = context;

    }

    @Override
    public void obtenerMascotaBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();

        this.mostrarMascotaRV();
    }

    @Override
    public void mostrarMascotaRV() {

        iFragmentHome.inicializarAdaptadorRV(iFragmentHome.crearAdaptador(mascotas));
        iFragmentHome.configuracionLayout();

    }

    @Override
    public void obtenerMascotaFavoritaBaseDatos() {

        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerConsulta();

        this.mostrarMascotaRV();
    }

}
