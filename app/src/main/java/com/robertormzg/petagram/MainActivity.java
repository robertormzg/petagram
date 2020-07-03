package com.robertormzg.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listaPets;
    ArrayList<Pet> pets;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        camaraFAB();

        listaPets = (RecyclerView) findViewById(R.id.rvPets);

        GridLayoutManager glm = new GridLayoutManager(this, 1);

        listaPets.setLayoutManager(glm);

        inicializarListaPets();
        inicializarAdaptador();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.btnFavoritos:
                Intent i = new Intent(this, PetFavorito.class);
                startActivity(i);
                break;
        };
        return super.onOptionsItemSelected(item);
    }

    public void camaraFAB(){
        FloatingActionButton miFAB = findViewById(R.id.btnFloatingButton);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "FAB", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inicializarAdaptador() {
        PetAdaptador adaptador = new PetAdaptador(pets, this);
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