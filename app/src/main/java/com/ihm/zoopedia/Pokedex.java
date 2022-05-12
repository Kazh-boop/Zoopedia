package com.ihm.zoopedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class Pokedex extends AppCompatActivity {
    SearchView searchView;
    ListView listView;
    ArrayList list;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokedex);
        searchView = findViewById(R.id.searchView);
        listView = findViewById(R.id.listView);
        list = new ArrayList<String>();
        list.add(new Animal("Girafe", "Jungle", "Enclos 09").toString());
        list.add(new Animal("Annaconda", "Forêt-Tropicale", "Enclos 10").toString());
        list.add(new Animal("Suricate", "Savane/Desert", "Enclos 07").toString());
        list.add(new Animal("Gorilles", "Jungle", "Enclos 14").toString());
        list.add(new Animal("Lémuriens", "Forêt-Tropicale", "Enclos 01").toString());
        list.add(new Animal("Lions", "Savane", "Enclos 02").toString());
        list.add(new Animal("Panthère", "Jungle", "Enclos 03").toString());

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(list.contains(query)){
                    adapter.getFilter().filter(query);
                }else{
                    Toast.makeText(Pokedex.this, "Pas de résultats...",Toast.LENGTH_LONG).show();
                }
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), Animal_view.class);
                String itemChosen = (String) listView.getAdapter().getItem(position);
                intent.putExtra("animal", itemChosen);
                startActivity(intent);
            }
        });
    }
}