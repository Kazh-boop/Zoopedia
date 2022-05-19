package com.ihm.zoopedia;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.net.URI;

public class Animal_view extends AppCompatActivity {

    ImageView avatar;
    Button retour;
    ImageButton son_button;
    TextView nom;
    TextView habitat;
    TextView emplacement;

    TextView nom_i;
    TextView habitat_i;
    TextView emp_i;
    TextView sound_i;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_view);
        avatar = findViewById(R.id.avatar);
        retour = findViewById(R.id.retour_button);
        son_button = findViewById(R.id.son_button);
        nom = findViewById(R.id.nom);
        habitat = findViewById(R.id.habitat);
        emplacement = findViewById(R.id.emplacement);
        nom_i = findViewById(R.id.name_indic);
        habitat_i = findViewById(R.id.habitat_indic);
        emp_i = findViewById(R.id.emp_indic);
        sound_i = findViewById(R.id.sound_i);

        emp_i.setText("Emplacement :");
        habitat_i.setText("Habitat naturel :");
        nom_i.setText("Nom de l'animal :");
        sound_i.setText("Cri de l'animal :");

        Intent intent = getIntent();
        String info = intent.getStringExtra("animal");
        nom.setText(info.split("\\s+")[0]);
        habitat.setText(info.split("\\s+")[2]);
        emplacement.setText(info.split("\\s+")[4]+" "+info.split("\\s+")[5]);
        switch(info.split("\\s+")[0]) {
            case "Girafe":
                avatar.setImageResource(R.drawable.girafe);
                break;
            case "Annaconda":
                avatar.setImageResource(R.drawable.annaconda);
                break;
            case "Suricate":
                avatar.setImageResource(R.drawable.suricate);
                break;
            case "Gorilles":
                avatar.setImageResource(R.drawable.gorille);
                break;
            case "Lémuriens":
                avatar.setImageResource(R.drawable.lemurien);
                break;
            case "Lions":
                avatar.setImageResource(R.drawable.lion);
                break;
            case "Panthère":
                avatar.setImageResource(R.drawable.panthere);
                break;
        }

        //habitat.setText(info[1]);
        //emplacement.setText(info[2]);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Pokedex.class);
                finish();
            }
        });


    }
}
