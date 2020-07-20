package com.robertormzg.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.robertormzg.petagram.pojo.Pet;

import java.util.ArrayList;


public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBD.DATABASE_NAME, null, ConstantesBD.DATABASE_VERSION);
        this.context = context  ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCreateTablePet = "CREATE TABLE " + ConstantesBD.TABLE_PET + "(" +
                        ConstantesBD.TABLE_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        ConstantesBD.TABLE_PET_NOMBRE + " TEXT, " +
                        ConstantesBD.TABLE_PET_FOTO + " INTEGER " +
                        ")";

        String queryCreateTablePetLikes = "CREATE TABLE " + ConstantesBD.TABLE_LIKES_PET+ " (" +
                ConstantesBD.TABLE_LIKES_PET_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBD.TABLE_LIKES_PET_ID_PET + " INTEGER, " +
                ConstantesBD.TABLE_LIKES_PET_NUMERO_LIKES + " INTEGER, " +
                " FOREIGN KEY (" + ConstantesBD.TABLE_LIKES_PET_ID_PET + ")" +
                " REFERENCES " + ConstantesBD.TABLE_PET + "(" + ConstantesBD.TABLE_PET_ID + ")" +
                ")";
        
        db.execSQL(queryCreateTablePet);
        db.execSQL(queryCreateTablePetLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_PET);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBD.TABLE_LIKES_PET);
        onCreate(db);
    }

    public ArrayList<Pet> obtenetTodosLosPets() {
        ArrayList<Pet> pets = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBD.TABLE_PET;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Pet petActual = new Pet();
            petActual.setId(registros.getInt(0));
            petActual.setNombre(registros.getString(1));
            petActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT (" + ConstantesBD.TABLE_LIKES_PET_NUMERO_LIKES + ")" +
                    " FROM " + ConstantesBD.TABLE_LIKES_PET +
                    " WHERE " + ConstantesBD.TABLE_LIKES_PET_ID_PET + " = " + petActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()) {
                petActual.setFavorito(registrosLikes.getInt(0));
            } else {
                petActual.setFavorito(0);
            }

            pets.add(petActual);
        }

        db.close();

        return pets;
    }

    public void insertarPet(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_PET, null, contentValues);
        db.close();
    }

    public void insertaLikePet(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBD.TABLE_LIKES_PET, null, contentValues);
        db.close();
    }

    public int obtenerLikesPet(Pet pet) {
        int likes = 0;
        String query = "SELECT COUNT (" + ConstantesBD.TABLE_LIKES_PET_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBD.TABLE_LIKES_PET +
                " WHERE " + ConstantesBD.TABLE_LIKES_PET_ID_PET + " = " + pet.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()) {
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }

    public boolean checkEmptyTablePet() {
        int cuenta = 0;
        String query = "SELECT COUNT (*)" +
                " FROM " + ConstantesBD.TABLE_PET;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        try {
            if(registros != null)
                if(registros.getCount() > 0){
                    registros.moveToFirst();
                    cuenta = registros.getInt(0);
                }
        }finally {
            if (registros != null && !registros.isClosed()) {
                registros.close();
            }
        }

        db.close();

        if(cuenta>0)
            return false;
        else
            return true;
    }
}
