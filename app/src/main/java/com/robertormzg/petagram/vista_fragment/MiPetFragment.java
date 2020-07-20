package com.robertormzg.petagram.vista_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mikhaellopez.circularimageview.CircularImageView;
import com.robertormzg.petagram.R;
import com.robertormzg.petagram.adapter.PicAdaptador;
import com.robertormzg.petagram.pojo.Pet;

import java.util.ArrayList;

public class MiPetFragment extends Fragment {
    public ArrayList<Pet> fotos;
    public PicAdaptador picAdaptador;
    private RecyclerView picList;
    private CircularImageView circularImageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_mi_pet, container, false);
        circularImageView = v.findViewById(R.id.civFotoPet);
        picList = v.findViewById(R.id.rvFotosPet);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);

        picList.setLayoutManager(gridLayoutManager);

        initPhotos();
        initAdapter();

        return v;
    }


    public void initPhotos() {
        fotos = new ArrayList<>();

        circularImageView.setImageResource(R.drawable.pet_01);

        fotos.add(new Pet(R.drawable.pet_01,"Toby", 10));
        fotos.add(new Pet(R.drawable.pet_01,"Toby", 20));
        fotos.add(new Pet(R.drawable.pet_01,"Toby", 30));
        fotos.add(new Pet(R.drawable.pet_01,"Toby", 10));
        fotos.add(new Pet(R.drawable.pet_01,"Toby", 20));
        fotos.add(new Pet(R.drawable.pet_01,"Toby", 30));
        fotos.add(new Pet(R.drawable.pet_01,"Toby", 10));
        fotos.add(new Pet(R.drawable.pet_01,"Toby", 20));
        fotos.add(new Pet(R.drawable.pet_01,"Toby", 30));
    }

    public void initAdapter() {
        picAdaptador = new PicAdaptador(fotos, getActivity());
        picList.setAdapter(picAdaptador);
    }
}