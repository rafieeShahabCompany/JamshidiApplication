package com.shahab.jamshidiapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DesignAdapter extends RecyclerView.Adapter<DesignAdapter.DesignHolder> {

    List<String> MENU;


    public DesignAdapter(List<String> menu){
        MENU = menu;

    }

    @NonNull
    @Override
    public DesignHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_design,parent,false);
       DesignHolder holder = new DesignHolder(V);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DesignHolder holder, int position) {
       String item = MENU.get(position);
       holder.txtMenu.setText(item);

    }

    @Override
    public int getItemCount() {

        return MENU.size();
    }



    class DesignHolder extends RecyclerView.ViewHolder {

        TextView txtMenu;

        public DesignHolder(@NonNull View itemView) {
            super(itemView);
            txtMenu = itemView.findViewById(R.id.txtMenu);
        }


        }
    }


