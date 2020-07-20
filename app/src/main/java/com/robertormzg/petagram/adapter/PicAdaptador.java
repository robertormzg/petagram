package com.robertormzg.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.robertormzg.petagram.R;
import com.robertormzg.petagram.pojo.Pet;

import java.util.ArrayList;

public class PicAdaptador extends RecyclerView.Adapter<PicAdaptador.PicViewHolder> {

    ArrayList<Pet> pets;
    Activity activity;

    public PicAdaptador(ArrayList<Pet> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PicAdaptador.PicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pic, parent, false);
        return new PicAdaptador.PicViewHolder(v);
    }
    @Override
    public void onBindViewHolder(@NonNull final PicAdaptador.PicViewHolder picViewHolder, int position) {
        final Pet pet = pets.get(position);

        picViewHolder.imgFotoMiPet.setImageResource(pet.getFoto());
        picViewHolder.tvFavoritoMiPet.setText(pet.getFavorito() + "");

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PicViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgFotoMiPet;
        private TextView tvFavoritoMiPet;

        public PicViewHolder(View itemView){
            super(itemView);
            imgFotoMiPet = itemView.findViewById(R.id.imgFotoMiPet);
            tvFavoritoMiPet = itemView.findViewById(R.id.tvFavoritoMiPet);
        }
    }
}
