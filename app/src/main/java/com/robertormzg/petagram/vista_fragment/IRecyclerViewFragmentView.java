package com.robertormzg.petagram.vista_fragment;

import com.robertormzg.petagram.adapter.PetAdaptador;
import com.robertormzg.petagram.pojo.Pet;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearlayoutVertical();

    public PetAdaptador crearAdaptador(ArrayList<Pet> pets);

    public void inicializarAdaptadorRV(PetAdaptador adaptador);

}
