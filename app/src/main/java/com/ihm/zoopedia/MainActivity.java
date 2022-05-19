package com.ihm.zoopedia;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import com.ihm.zoopedia.quiz.QuizMenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // RELATIVE LAYOUT
        RelativeLayout layout1 = new RelativeLayout(this);
        RelativeLayout layout2 = new RelativeLayout(this);

        // CARTE DU ZOO
        final ImageButton map = (ImageButton) findViewById(R.id.zooMap);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openMap = new Intent(getApplicationContext(),Carte.class);
                startActivity(openMap);
            }
        });
        // APPAREIL PHOTO POUR QR CODES
        final ImageButton photo = (ImageButton) findViewById(R.id.photo);
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openPhoto = new Intent(getApplicationContext(),Photo.class);
                startActivity(openPhoto);
            }
        });
        // POKEDEX
        final ImageButton pokedex = (ImageButton) findViewById(R.id.pokedex);
        pokedex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openPokedex = new Intent(getApplicationContext(),Pokedex.class);
                startActivity(openPokedex);
            }
        });

        // QUIZZ
        final ImageButton quizz = (ImageButton) findViewById(R.id.quizz);
        quizz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openQuizz = new Intent(getApplicationContext(), QuizMenuActivity.class);
                startActivity(openQuizz);
            }
        });
        /*
        // ACHATS ET RESERVATIONS
        final ImageButton achats = (ImageButton) findViewById(R.id.preorder);
        achats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openPreorder = new Intent(getApplicationContext(),Achat.class);
                finish();
            }
        });
        */
        /*
        // INFORMATIONS SUR LE ZOO (BROCHURE)
        final ImageButton infos = (ImageButton) findViewById(R.id.info);
        infos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openInfo = new Intent(getApplicationContext(),info.class);
                finish();
            }
        });
        */
        // HORAIRES
        final ImageButton time = (ImageButton) findViewById(R.id.time);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openTime = new Intent(getApplicationContext(),HorairesAdapter.class);
                startActivity(openTime);
            }
        });
        // PARAMETRES
        final ImageButton parameters = (ImageButton) findViewById(R.id.parameters);
        parameters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openParameters = new Intent(getApplicationContext(),Parameters.class);
                startActivity(openParameters);
            }
        });

        // SET UP DES LAYOUTS POUR Y INSERER LES BOUTONS
        //RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        //RelativeLayout.LayoutParams q = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        // layout1.addView(map,photo,pokedex);
        // layout2.addView(achats,info,time,parameters);

    }

}