package com.krivic.lasmascotitasv3.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.krivic.lasmascotitasv3.pojo.Mascotas;

import java.util.ArrayList;


public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {

        super(context, com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.DATABASE_NAME, null, com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String queryCrearTablaContacto = "CREATE TABLE " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_MASCOTA
                + "(" + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_MASCOTA_ID   + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE       + " TEXT," +
                com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_MASCOTA_FOTO         + " INTEGER" +
                ")";

        String queryCrearTablaLikesContacto = "CREATE TABLE " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA
                + "(" + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA     + " INTEGER," +
                com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES    + " INTEGER," +
                " FOREIGN KEY (" + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID + ") " +
                " REFERENCES " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_MASCOTA + "(" + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_MASCOTA_ID +")" +
                ")";

        sqLiteDatabase.execSQL(queryCrearTablaContacto);
        sqLiteDatabase.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_MASCOTA);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA);

        this.onCreate(sqLiteDatabase);
    }

    public ArrayList<Mascotas> obtenerAllMascotas() {
        ArrayList<Mascotas> contactos = new ArrayList<>();
        String query = "SELECT * FROM " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_MASCOTA;

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor registros = sqLiteDatabase.rawQuery(query, null);
        Mascotas mascota;
        String queryLikes;
        Cursor registroLikes;

        while(registros.moveToNext()){

            mascota = new Mascotas();
            mascota.setId(registros.getInt(0));
            mascota.setNombre(registros.getString(1));
            mascota.setFoto(registros.getInt(2));

            queryLikes = "SELECT COUNT ( " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES + ")" +
                    " FROM " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA +
                    " WHERE " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " = " + mascota.getId();

            registroLikes = sqLiteDatabase.rawQuery(queryLikes, null);
            if(registroLikes.moveToNext()){
                mascota.setLikes(registroLikes.getInt(0));

            }else{

                mascota.setLikes(0);
            }


            contactos.add(mascota);
        }

        sqLiteDatabase.close();
        return contactos;
    }

    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_MASCOTA, null, contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA, null, contentValues);
        db.close();
    }


    public int obtenerLikesContacto(Mascotas mascota){

        int likes = 0;

        String query = "SELECT COUNT ( " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA_NUMERO_LIKES + ")" +
                " FROM " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA +
                " WHERE " + com.krivic.lasmascotitasv3.DB.ConstantesBaseDatos.TABLE_LIKE_MASCOTA_ID_MASCOTA + " = " + mascota.getId();

        SQLiteDatabase database = this.getWritableDatabase();
        Cursor registros = database.rawQuery(query, null);

        Toast.makeText(context, "Like " + registros.getCount(), Toast.LENGTH_SHORT).show();

        while(registros.moveToNext()){
            likes = registros.getInt(0);
        }

        database.close();

        return likes;
    }

}
