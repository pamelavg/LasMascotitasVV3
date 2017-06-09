package com.krivic.lasmascotitasv3.pojo;

import java.io.Serializable;


public class Mascotas  implements Serializable {
    private String Nombre;
    private int Foto;
    private int Likes=0;
    private int id;
    public Mascotas()
    {}
    public Mascotas(String nombre, int foto, int likes,int identificador) {
        Nombre = nombre;
        Foto = foto;
        Likes = likes;
        id=identificador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }

    public int getLikes() {
        return Likes;
    }

    public void setLikes(int likes) {
        Likes = likes;
    }

    public void setAumentarLikes() {
        this.Likes = ++Likes;
    }
}
