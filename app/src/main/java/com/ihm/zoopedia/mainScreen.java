package com.ihm.zoopedia;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class mainScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RELATIVE LAYOUT
        layout1 = new RelativeLayout(this);
        layout2 = new RelativeLayout(this);

        // CARTE DU ZOO
        final ImageButton map = (Button) findViewById(R.id.zooMap);
        map.setId("mapZoo");
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMap = new Intent(getApplicationContext(),carteZoo.class);
                finish();
            }
        });
        // APPAREIL PHOTO POUR QR CODES
        final ImageButton photo = (Button) findViewById(R.id.photo);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openPhoto = new Intent(getApplicationContext(),photo.class);
                finish();
            }
        });
        // POKEDEX
        final ImageButton pokedex = (ImageButton) findViewById(R.id.pokedex);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openPokedex = new Intent(getApplicationContext(),pokedex.class);
                finish();
            }
        });

        // QUIZZ
        final ImageButton quizz = (Button) findViewById(R.id.quizz);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openQuizz = new Intent(getApplicationContext(),QuizzMenuActivity.class);
                finish();
            }
        });

        // ACHATS ET RESERVATIONS
        final ImageButton achats = (Button) findViewById(R.id.preorder);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openPreorder = new Intent(getApplicationContext(),preorder.class);
                finish();
            }
        });
        // INFORMATIONS SUR LE ZOO (BROCHURE)
        final ImageButton infos = (Button) findViewById(R.id.info);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openInfo = new Intent(getApplicationContext(),info.class);
                finish();
            }
        });
        // HORAIRES
        final ImageButton time = (Button) findViewById(R.id.time);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openTime = new Intent(getApplicationContext(),time.class);
                finish();
            }
        });
        // PARAMETRES
        final ImageButton parameters = (Button) findViewById(R.id.parameters);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openParameters = new Intent(getApplicationContext(),parameters.class);
                finish();
            }
        });

        // SET UP DES LAYOUTS POUR Y INSERER LES BOUTONS
        RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        RelativeLayout.LayoutParams q = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        // layout1.addView(map,photo,pokedex);
        // layout2.addView(achats,info,time,parameters);

    }

}