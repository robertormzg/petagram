package com.robertormzg.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout miIndicadorRefresh;
    ListView lstMiLista;
    Adapter adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        agregarFAV();

        miIndicadorRefresh = (SwipeRefreshLayout) findViewById(R.id.srlMiIndicadorRefresh);
        lstMiLista = (ListView) findViewById(R.id.lstMiVista);

        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));

        miIndicadorRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                RefrescandoContenido();
            }
        });
    }

    public void RefrescandoContenido(){
        String[] planetas = getResources().getStringArray(R.array.planetas);
        lstMiLista.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetas));
        miIndicadorRefresh.setRefreshing(false);
    }

    public void agregarFAV() {
        FloatingActionButton miFav = (FloatingActionButton) findViewById(R.id.miFav);
        miFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ya no estandisponibles los mensajes toast, cambiaron por snackbar
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.favorito), Toast.LENGTH_SHORT).show();
                Snackbar.make(v, getResources().getString(R.string.favorito), Snackbar.LENGTH_SHORT)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        }).setActionTextColor(getResources().getColor(R.color.colorSecondaryText))
                        .show();
            }
        });
    }
}