package com.ihm.zoopedia;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.ihm.zoopedia.quiz.QuizMenuActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gotoQuizz(View view) {
        Intent intent = new Intent(this, QuizMenuActivity.class);
        startActivity(intent);
    }

}