package com.robertormzg.petagram.presentador;

import android.content.Context;

import com.robertormzg.petagram.db.ConstructorPets;
import com.robertormzg.petagram.pojo.Pet;
import com.robertormzg.petagram.vista_fragment.IRecyclerViewFragmentView;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorPets constructorPet;
    private ArrayList<Pet> pets;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerPetsBaseDatos();
    }

    @Override
    public void obtenerPetsBaseDatos() {
        constructorPet = new ConstructorPets(context);
        pets = constructorPet.obtenerDatos();
        mostrarPetsRV();
    }

    @Override
    public void mostrarPetsRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(pets));
        iRecyclerViewFragmentView.generarLinearlayoutVertical();
    }
}
