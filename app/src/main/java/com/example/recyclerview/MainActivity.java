package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recyclerview
        mRecyclerView = findViewById(R.id.recycler_view);
        //set its properties
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this)); //LinearlAYOUT
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2)); //
        myAdapter = new MyAdapter(getApplicationContext(), getPlayers());
        mRecyclerView.setAdapter(myAdapter);
    }

    //add models to arraylist
    private ArrayList<Model> getPlayers(){
        ArrayList<Model> models = new ArrayList<>();

        Model p = new Model();
        p.setTitle("Birria");
        p.setDescription("Ingredientes. Pasos");
        p.setImg(R.drawable.birria);
        models.add(p);

        p = new Model();
        p.setTitle("Burritos");
        p.setDescription("Ingredientes. Pasos");
        p.setImg(R.drawable.burritos);
        models.add(p);

        p = new Model();
        p.setTitle("Ceviche");
        p.setDescription("Ingredientes. Pasos");
        p.setImg(R.drawable.ceviche);
        models.add(p);

        p = new Model();
        p.setTitle("Enchiladas Rojas");
        p.setDescription("Ingredientes. Pasos");
        p.setImg(R.drawable.enchiladasrojas);
        models.add(p);

        p = new Model();
        p.setTitle("Ensalada");
        p.setDescription("Ingredientes. Pasos");
        p.setImg(R.drawable.ensalada);
        models.add(p);

        p = new Model();
        p.setTitle("Huarache");
        p.setDescription("Ingredientes. Pasos");
        p.setImg(R.drawable.huarache);
        models.add(p);

        p = new Model();
        p.setTitle("Mole Poblano");
        p.setDescription("Ingredientes. Pasos");
        p.setImg(R.drawable.molepoblano);
        models.add(p);

        p = new Model();
        p.setTitle("Pozole");
        p.setDescription("Ingredientes. Pasos");
        p.setImg(R.drawable.pozole);
        models.add(p);

        p = new Model();
        p.setTitle("Quesadilla");
        p.setDescription("Ingredientes. Pasos");
        p.setImg(R.drawable.quesadilla);
        models.add(p);

        p = new Model();
        p.setTitle("Tamal");
        p.setDescription("Ingredientes. Pasos");
        p.setImg(R.drawable.tamal);
        models.add(p);
        return models;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem item = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //called when you click search
                myAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //called whener you type a letter in searchview
                myAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_settings){
            Toast.makeText(this, "Configuración", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
