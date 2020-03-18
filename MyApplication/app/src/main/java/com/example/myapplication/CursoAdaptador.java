package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CursoAdaptador extends RecyclerView.Adapter<CursoAdaptador.ViewHolder> {

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView codigo, producto, dueño;

        public ViewHolder(View itemView) {
            super(itemView);
            codigo = (TextView) itemView.findViewById(R.id.tveCodigo);
            producto = (TextView) itemView.findViewById(R.id.tveProducto);
            dueño = (TextView) itemView.findViewById(R.id.tveDueño);
        }

    }

    public List<CursoModelo> cursoLista;

    public CursoAdaptador(List<CursoModelo> cursoLista) {
        this.cursoLista = cursoLista;
    }

    @Override
        public ViewHolder onCreateViewHolder (ViewGroup parent,int viewType){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.codigo.setText(cursoLista.get(position).getCodigo());
        holder.producto.setText(cursoLista.get(position).getProducto());
        holder.dueño.setText(cursoLista.get(position).getDueño());
    }

    @Override
    public int getItemCount() {
        return cursoLista.size();
    }
}