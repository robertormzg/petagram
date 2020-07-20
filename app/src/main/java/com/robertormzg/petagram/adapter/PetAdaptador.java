package com.robertormzg.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.robertormzg.petagram.db.ConstructorPets;
import com.robertormzg.petagram.pojo.Pet;
import com.robertormzg.petagram.R;

import java.util.ArrayList;


public class PetAdaptador extends RecyclerView.Adapter<PetAdaptador.PetViewHolder> {

    ArrayList<Pet> pets;
    private final Activity activity;

    public PetAdaptador(ArrayList<Pet> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PetViewHolder petViewHolder, int position) {
        final Pet pet = pets.get(position);

        petViewHolder.imgFotoPet.setImageResource(pet.getFoto());
        petViewHolder.tvNombreCV.setText(pet.getNombre());
        petViewHolder.tvFavoritoCV.setText(pet.getFavorito() + "");

        PetViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + pet.getNombre(), Toast.LENGTH_SHORT).show();

                ConstructorPets constructorPets = new ConstructorPets(activity);
                constructorPets.darLikePet(pet);
                petViewHolder.tvFavoritoCV.setText(constructorPets.obtenerLikesPet(pet) + "");
            }
        });

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoPet;
        private TextView tvNombreCV;
        private TextView tvFavoritoCV;
        private static ImageView btnLike;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);

            imgFotoPet = (ImageView) itemView.findViewById(R.id.imgFotoPet);
            tvNombreCV = (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvFavoritoCV = (TextView) itemView.findViewById(R.id.tvFavoritoCV);
            btnLike = itemView.findViewById(R.id.btnLike);

        }
    }
}
