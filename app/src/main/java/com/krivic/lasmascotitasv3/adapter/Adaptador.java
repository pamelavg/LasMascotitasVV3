package com.krivic.lasmascotitasv3.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.krivic.lasmascotitasv3.DB.ConstructorMascotas;
import com.krivic.lasmascotitasv3.pojo.Mascotas;
import com.krivic.lasmascotitasv3.R;

import java.util.ArrayList;

/**
 * Created by krivic on 5/22/2017.
 */


public class Adaptador extends RecyclerView.Adapter<Adaptador.MascotaVHolder> {

    ArrayList<Mascotas> mascotas;
    Activity activity;

    public Adaptador(ArrayList<Mascotas> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity=activity;
    }

    @Override
    public MascotaVHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_mascotas, parent, false);
        return new MascotaVHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaVHolder mascotaVHolder, final int position) {
        final Mascotas mascota = mascotas.get(position);
        mascotaVHolder.fotoPet.setImageResource(mascota.getFoto());
        mascotaVHolder.nombrePet.setText(mascota.getNombre());
        mascotaVHolder.likesPet.setText("" + mascota.getLikes());

        mascotaVHolder.imgHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mascota.setAumentarLikes();
                notifyItemChanged(position);
            }
        });
        ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
        constructorMascotas.darLikeMascotas(mascota);
        mascotaVHolder.likesPet.setText(constructorMascotas.obtenerLikesMascota(mascota)+" Likes");
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaVHolder extends RecyclerView.ViewHolder{
        ImageView fotoPet;
        TextView nombrePet;
        TextView likesPet;
        ImageView imgHueso;
        ImageView btnEstrella;


        public MascotaVHolder(View itemView) {
            super(itemView);
            fotoPet = (ImageView) itemView.findViewById(R.id.imgFoto);
            nombrePet = (TextView) itemView.findViewById(R.id.tvNombre);
            likesPet = (TextView) itemView.findViewById(R.id.tvLike);
            imgHueso = (ImageView) itemView.findViewById(R.id.imgHueso);
            btnEstrella = (ImageView) itemView.findViewById(R.id.btnEstrella);
        }
    }
}

