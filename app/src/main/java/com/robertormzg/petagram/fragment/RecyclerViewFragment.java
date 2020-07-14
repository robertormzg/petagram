package com.robertormzg.petagram.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.robertormzg.petagram.pojo.Pet;
import com.robertormzg.petagram.R;
import com.robertormzg.petagram.adapter.PetAdaptador;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    private RecyclerView listaPets;
    ArrayList<Pet> pets;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        listaPets = (RecyclerView) v.findViewById(R.id.rvPets);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 1);

        listaPets.setLayoutManager(glm);

        inicializarListaPets();
        inicializarAdaptador();

        /*

        listaContactos = (RecyclerView) v.findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaContactos.setLayoutManager(llm);

        inicializarListaContactos();
        inicializarAdaptador();
*/
        return v;
    }

    private void inicializarAdaptador() {
        PetAdaptador adaptador = new PetAdaptador(pets, getActivity());
        listaPets.setAdapter(adaptador);
    }

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
}