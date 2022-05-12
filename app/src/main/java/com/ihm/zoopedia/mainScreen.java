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

        // CARTE DU ZOO
        final Button map = (Button) findViewById(R.id.zooMap);
        map.setOnClickListener(new View.OnClickListener() {
           public void onClick(View view) {
               Intent openMap = new Intent(getApplicationContext(),carte.class);
               startActivity(openMap);
           }
        });
        // APPAREIL PHOTO POUR QR CODES
        final Button photo = (Button) findViewById(R.id.photo);
        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent openPhoto = new Intent(getApplicationContext(),photo.class);
                startActivity(openPhoto);
            }
        });
        // POKEDEX
        final ImageButton pokedex = (ImageButton) findViewById(R.id.pokedex);
        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent openPokedex = new Intent(getApplicationContext(),pokedex.class);
                startActivity(openPokedex);
            }
        });

        // QUIZZ
        final Button quizz = (Button) findViewById(R.id.quizz);
        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent openQuizz = new Intent(getApplicationContext(),quizz.class);
                startActivity(openQuizz);
            }
        });

        // ACHATS ET RESERVATIONS
        final Button achats = (Button) findViewById(R.id.preorder);
        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent openPreorder = new Intent(getApplicationContext(),preorder.class);
                startActivity(openPreorder);
            }
        });
        // INFORMATIONS SUR LE ZOO (BROCHURE)
        final Button infos = (Button) findViewById(R.id.info);
        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent openInfo = new Intent(getApplicationContext(),info.class);
                startActivity(openInfo);
            }
        });
        // HORAIRES
        final Button time = (Button) findViewById(R.id.time);
        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent openTime = new Intent(getApplicationContext(),time.class);
                startActivity(openTime);
            }
        });
        // PARAMETRES
        final Button parameters = (Button) findViewById(R.id.parameters);
        map.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent openParameters = new Intent(getApplicationContext(),parameters.class);
                startActivity(openParameters);
            }
        });

    }

}