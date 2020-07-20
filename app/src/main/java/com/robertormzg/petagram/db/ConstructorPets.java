package com.robertormzg.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.robertormzg.petagram.R;
import com.robertormzg.petagram.pojo.Pet;

import java.util.ArrayList;

public class ConstructorPets {

    private static final int LIKE = 1;
    private Context context;
    public ConstructorPets(Context context) {
        this.context = context;
    }

    public ArrayList<Pet> obtenerDatos() {
        /*
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
        return pets;
        */

        BaseDatos db = new BaseDatos(context);
        if (db.checkEmptyTablePet()) {
            insertaCincoPets(db);
        }
        return db.obtenetTodosLosPets();
    }

    public void insertaCincoPets(BaseDatos db) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PET_NOMBRE, "Toby");
        contentValues.put(ConstantesBD.TABLE_PET_FOTO, R.drawable.pet_01);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PET_NOMBRE, "Rocky");
        contentValues.put(ConstantesBD.TABLE_PET_FOTO, R.drawable.pet_02);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PET_NOMBRE, "Max");
        contentValues.put(ConstantesBD.TABLE_PET_FOTO, R.drawable.pet_03);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PET_NOMBRE, "Pancho");
        contentValues.put(ConstantesBD.TABLE_PET_FOTO, R.drawable.pet_04);
        db.insertarPet(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_PET_NOMBRE, "Jack");
        contentValues.put(ConstantesBD.TABLE_PET_FOTO, R.drawable.pet_05);
        db.insertarPet(contentValues);

    }

    public void darLikePet(Pet pet) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBD.TABLE_LIKES_PET_ID_PET, pet.getId());
        contentValues.put(ConstantesBD.TABLE_LIKES_PET_NUMERO_LIKES, LIKE);
        db.insertaLikePet(contentValues);
    }

    public int obtenerLikesPet(Pet pet) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesPet(pet);
    }
}
