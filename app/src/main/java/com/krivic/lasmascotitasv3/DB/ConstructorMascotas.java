package com.krivic.lasmascotitasv3.DB;

import android.content.ContentValues;
import android.content.Context;

import com.krivic.lasmascotitasv3.R;
import com.krivic.lasmascotitasv3.pojo.Mascotas;

import java.util.ArrayList;



public class ConstructorMascotas {

    private static boolean INSERTO_REGISTROS = false;
    private static final int LIKE = 0;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<Mascotas> obtenerDatos() {

        BaseDatos baseDatos = new BaseDatos(context);
        insertarMascotas(baseDatos);

        return baseDatos.obtenerAllMascotas();

    }

    public ArrayList<Mascotas> obtenerConsulta() {

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerAllMascotas();

    }



    public void insertarMascotas(BaseDatos baseDatos){

        if(!INSERTO_REGISTROS) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "MascotaA");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mascota1);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "MascotaB");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mascota2);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "MascotaC");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mascota3);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "MascotaD");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mascota4);
            baseDatos.insertarMascota(contentValues);

            contentValues = new ContentValues();
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE, "MascotaE");
            contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO, R.drawable.mascota5);
            baseDatos.insertarMascota(contentValues);

            INSERTO_REGISTROS = true;
        }

    }

    public void darLikeMascotas(Mascotas mascota){

        BaseDatos baseDatos = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES, LIKE);

        baseDatos.insertarLikeMascota(contentValues);
    }

    public int obtenerLikesMascota(Mascotas mascota){

        BaseDatos baseDatos = new BaseDatos(context);
        return baseDatos.obtenerLikesContacto(mascota);
    }


}

