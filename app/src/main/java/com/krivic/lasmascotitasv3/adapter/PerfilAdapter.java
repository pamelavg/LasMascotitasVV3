package com.krivic.lasmascotitasv3.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.krivic.lasmascotitasv3.R;
import com.krivic.lasmascotitasv3.pojo.Mascotas;

import java.util.ArrayList;



public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.PerfilAdapterViewHolder>{

    ArrayList<Mascotas> mascotas;
    Activity activity;


    public PerfilAdapter(ArrayList<Mascotas> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public PerfilAdapter.PerfilAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_perfil, parent, false);
        return new PerfilAdapter.PerfilAdapterViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final PerfilAdapter.PerfilAdapterViewHolder holder, int position) {

        final Mascotas mascota = mascotas.get(position);
        holder.imgFotoPerfil.setImageResource(mascota.getFoto());

        holder.tvLikeMascotaCVPerfil.setText(mascota.getLikes() + " Likes");


    }


    @Override
    public int getItemCount() {
        return this.mascotas.size();
    }


    public static class PerfilAdapterViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFotoPerfil;
        private TextView tvLikeMascotaCVPerfil;
        private ImageButton btnCantLikePerfil;

        public PerfilAdapterViewHolder(View itemView) {
            super(itemView);

            this.imgFotoPerfil = (ImageView)itemView.findViewById(R.id.imgFotoPerfil);
            this.tvLikeMascotaCVPerfil = (TextView)itemView.findViewById(R.id.tvLikeMascotaCVPerfil);
            this.btnCantLikePerfil = (ImageButton)itemView.findViewById(R.id.btnCantLikePerfil);
        }
    }

}

