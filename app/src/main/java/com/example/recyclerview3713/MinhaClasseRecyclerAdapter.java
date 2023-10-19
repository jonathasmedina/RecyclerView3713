package com.example.recyclerview3713;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MinhaClasseRecyclerAdapter extends RecyclerView.Adapter<MinhaClasseRecyclerAdapter.MyViewHolder> {

    ArrayList<Usuario> usuarioArrayList = new ArrayList<>();

    public MinhaClasseRecyclerAdapter(ArrayList<Usuario> usuarioArrayList) {
        this.usuarioArrayList = usuarioArrayList;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView nome_;
        TextView idade_;
        ImageView imagem_;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nome_ = itemView.findViewById(R.id.nome);
            idade_ = itemView.findViewById(R.id.idade);
            imagem_ = itemView.findViewById(R.id.imageView);
        }
    }


    @NonNull
    @Override
    public MinhaClasseRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.menu_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MinhaClasseRecyclerAdapter.MyViewHolder holder, int position) {
        String nome = usuarioArrayList.get(position).getNome();
        int idade = usuarioArrayList.get(position).getIdade();
        int imagem = usuarioArrayList.get(position).getImagem();

        holder.nome_.setText(nome);
        holder.idade_.setText(idade+"");
        holder.imagem_.setImageResource(imagem);
    }

    @Override
    public int getItemCount() {
        return usuarioArrayList.size();
    }
}
