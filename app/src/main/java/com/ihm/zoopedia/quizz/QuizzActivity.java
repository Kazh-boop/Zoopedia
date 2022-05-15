package com.ihm.zoopedia.quizz;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.ihm.zoopedia.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizzActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Question> questions = new ArrayList<>();
    private final int maxQuestion = 1;

    private JSONArray jsonArray;

    private int currentQuestion = 0;

    private TextView statement;
    private Button clause1;
    private Button clause2;
    private Button clause3;
    private Button clause4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quizz_activity);


        // lecture du fichier json
        InputStream inputStream = ((Context)this).getResources().openRawResource(R.raw.questions);
        String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();
        try {
            jsonArray = new JSONArray(jsonString);
            for (int i=0; i < jsonArray.length(); i++)
                questions.add(loadQuestion(i+1));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        statement = findViewById(R.id.statement);
        clause1 = findViewById(R.id.clause1);
        clause1.setOnClickListener(this);
        clause2 = findViewById(R.id.clause2);
        clause2.setOnClickListener(this);
        clause3 = findViewById(R.id.clause3);
        clause3.setOnClickListener(this);
        clause4 = findViewById(R.id.clause4);
        clause4.setOnClickListener(this);


        statement.setText(questions.get(currentQuestion).getStatementText());
        clause1.setText(questions.get(currentQuestion).getClause(0).getText());
        clause2.setText(questions.get(currentQuestion).getClause(1).getText());
        clause3.setText(questions.get(currentQuestion).getClause(2).getText());
        clause4.setText(questions.get(currentQuestion).getClause(3).getText());

    }

    private Question loadQuestion(int id) throws JSONException {
        Question question = null;
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject object = jsonArray.getJSONObject(i);
            int idj = object.optInt("id");
            if (id == idj) { // question trouvée
                Statement statement = new Statement(object.optString("statement"), object.optString("image"));
                ArrayList<Clause> clauses = new ArrayList<>();
                JSONArray jclauses = object.getJSONArray("clauses"); // liste de clauses
                for (int j = 0; j < jclauses.length(); j++) {
                    JSONArray jclause = jclauses.getJSONArray(j); // une clause
                    clauses.add(new Clause(jclause.optString(0), jclause.optBoolean(1)));
                }
                question = new Question(statement, clauses);
                break;
            } else {
                continue;
            }
        }
        return question;
    }

    protected void nextQuestion() {
        currentQuestion++;
        statement.setText(questions.get(currentQuestion).getStatementText());
        clause1.setText(questions.get(currentQuestion).getClause(0).getText());
        clause2.setText(questions.get(currentQuestion).getClause(1).getText());
        clause3.setText(questions.get(currentQuestion).getClause(2).getText());
        clause4.setText(questions.get(currentQuestion).getClause(3).getText());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clause1:
            case R.id.clause2:
            case R.id.clause3:
            case R.id.clause4:
                nextQuestion();
                break;
        }
    }
}
