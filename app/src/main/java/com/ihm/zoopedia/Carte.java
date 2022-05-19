package com.ihm.zoopedia;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private Button AfficherMasquerAnimaux;
    private Button AfficherMasquerInfluence;
    private Button Retour;
    private ImageView Carte;
    private Boolean carteBool = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AfficherMasquerAnimaux = findViewById(R.id.AfficherMasquerAnimaux);
        AfficherMasquerInfluence = findViewById(R.id.AfficherMasquerInfluence);
        Retour = findViewById(R.id.Retour);
        Carte = findViewById(R.id.Carte);

        AfficherMasquerAnimaux.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carteBool){
                    Carte.setImageResource(R.drawable.zoo);
                    AfficherMasquerAnimaux.setText("Afficher Animaux");
                    carteBool = false;
                    AfficherMasquerInfluence.setEnabled(true);
                }else{
                    Carte.setImageResource(R.drawable.zoo2);
                    AfficherMasquerAnimaux.setText("Masquer Animaux");
                    carteBool = true;
                    AfficherMasquerInfluence.setEnabled(false);
                }
            }
        });

        AfficherMasquerInfluence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(carteBool){
                    Carte.setImageResource(R.drawable.zoo);
                    AfficherMasquerInfluence.setText("Afficher Influence");
                    carteBool = false;
                    AfficherMasquerAnimaux.setEnabled(true);
                }else{
                    Carte.setImageResource(R.drawable.zoo3);
                    AfficherMasquerInfluence.setText("Masquer Influence");
                    carteBool = true;
                    AfficherMasquerAnimaux.setEnabled(false);
                }
            }
        });

        Retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), mainScreen.class);
                finish();
            }
        });
    }
}
