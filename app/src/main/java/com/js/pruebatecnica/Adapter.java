package com.js.pruebatecnica;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import Models.DatosUser;

public class Adapter extends RecyclerView.Adapter<Adapter.AdapterUsuarioviewHolder>{
    List<DatosUser> users;

    public Adapter(List<DatosUser> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public AdapterUsuarioviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.vistarv,parent,false);
        AdapterUsuarioviewHolder holder=new AdapterUsuarioviewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUsuarioviewHolder holder, int position) {
        DatosUser datosUser=users.get(position);
        holder.tvNombre.setText(datosUser.getNombre());
        holder.tvIdentificacion.setText(datosUser.getIdentificacion());
        holder.tvEmail.setText(datosUser.getEmail());
        holder.tvTelefono.setText(datosUser.getTelefono());

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class AdapterUsuarioviewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre,tvIdentificacion,tvEmail,tvTelefono;

        public AdapterUsuarioviewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre=itemView.findViewById(R.id.nombrefirebase);
            tvIdentificacion=itemView.findViewById(R.id.identificacionfirebase);
            tvEmail=itemView.findViewById(R.id.emailfirebase);
            tvTelefono=itemView.findViewById(R.id.telefonofirebase);

        }
    }
}
