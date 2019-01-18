package com.example.dudas.sushi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList<Profile> profiles;

    public MyAdapter(Context c,ArrayList<Profile> p)
    {
        context=c;
        profiles=p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }
   // String cenaString = Integer.toString(profiles.get(int position).getCena);
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nazwa.setText(profiles.get(position).getNazwa());
        holder.opis.setText(profiles.get(position).getOpis());
        holder.cena.setText(String.valueOf(profiles.get(position).getCena()));
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView nazwa,opis,cena;
        public MyViewHolder(View itemView) {
            super(itemView);
            nazwa = (TextView) itemView.findViewById(R.id.nazwa);
            opis = (TextView) itemView.findViewById(R.id.opis);
            cena = (TextView) itemView.findViewById(R.id.cena);
        }
    }

}
