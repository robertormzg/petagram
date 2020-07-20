package com.robertormzg.petagram.vista_fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robertormzg.petagram.pojo.Pet;
import com.robertormzg.petagram.R;
import com.robertormzg.petagram.adapter.PetAdaptador;
import com.robertormzg.petagram.presentador.IRecyclerViewFragmentPresenter;
import com.robertormzg.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private RecyclerView listaPets;
    ArrayList<Pet> pets;
    private IRecyclerViewFragmentPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaPets = (RecyclerView) v.findViewById(R.id.rvPets);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }

    /*
    public void inicializarListaPets() {
        pets = new ArrayList<Pet>();

        pets.add(new Pet(R.drawable.pet_01,"Toby", "0"));
        pets.add(new Pet(R.drawable.pet_02,"Rocky", "0"));
        pets.add(new Pet(R.drawable.pet_03,"Max", "0"));
        pets.add(new Pet(R.drawable.pet_04,"Pancho", "0"));
        pets.add(new Pet(R.drawable.pet_05,"Jack", "0"));
        pets.add(new Pet(R.drawable.pet_06,"Zeus", "0"));
        pets.add(new Pet(R.drawable.pet_07,"Firuláis", "0"));
        pets.add(new Pet(R.drawable.pet_08,"Coco", "0"));
        pets.add(new Pet(R.drawable.pet_09,"Chispa", "0"));

    }
    */


    @Override
    public void generarLinearlayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaPets.setLayoutManager(llm);
    }

    @Override
    public PetAdaptador crearAdaptador(ArrayList<Pet> pets) {
        PetAdaptador adaptador = new PetAdaptador(pets, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(PetAdaptador adaptador) {
        listaPets.setAdapter(adaptador);
    }
}