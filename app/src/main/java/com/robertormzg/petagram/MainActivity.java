package com.robertormzg.petagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.robertormzg.petagram.adapter.PageAdaptador;
import com.robertormzg.petagram.vista_fragment.MiPetFragment;
import com.robertormzg.petagram.vista_fragment.RecyclerViewFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        setUpViewpager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

        camaraFAB();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;

        switch (item.getItemId()){
            case R.id.btnFavoritos:
                intent = new Intent(this, PetFavorito.class);
                startActivity(intent);
                break;
            case R.id.btnContacto:
                intent = new Intent(this, Contacto.class);
                startActivity(intent);
                break;
            case R.id.btnAbout:
                intent = new Intent(this, About.class);
                startActivity(intent);
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

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new RecyclerViewFragment());
        fragments.add(new MiPetFragment());

        return fragments;
    }
    private void setUpViewpager() {
        viewPager.setAdapter(new PageAdaptador(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_dog_48);
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_dog_64);
    }
}