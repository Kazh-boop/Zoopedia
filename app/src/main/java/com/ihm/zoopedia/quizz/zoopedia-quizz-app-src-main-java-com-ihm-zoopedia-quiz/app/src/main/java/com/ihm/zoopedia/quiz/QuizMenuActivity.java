package com.ihm.zoopedia.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.ihm.zoopedia.R;

public class QuizMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_menu_activity);

        Button startButton = (Button) findViewById(R.id.start);
        Button backButton = (Button) findViewById(R.id.back);

        startButton.setOnClickListener(view -> {
            startActivity(new Intent(this, QuizActivity.class));
        });

        backButton.setOnClickListener(view -> {
            this.finish();
        });

    }

    public void gotoQuizz(View view) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
    }

    public void goBack(View view) {
        finish();
    }
}
