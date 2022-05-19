package com.ihm.zoopedia;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokedex);
    }

    public void horaires(View view)
    {
        Intent horaires = new Intent(this,HorairesAdapter.class);
        startActivity(horaires);
    }
}