package com.ihm.zoopedia.quiz;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import com.ihm.zoopedia.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Question> questions = new ArrayList<>();
    private final int maxQuestion = 10;

    private JSONArray jsonArray;

    private int currentQuestion = 1, idQuestion = 0;

    private TextView statement, textScore, textCurrentQuestion;
    private Button clause1, clause2, clause3, clause4;

    private Button button_next_question;

    private Button button_menu;

    private int score;

    private String stringCurrentQuestion;

    private String stringTextScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_activity);

        button_menu = findViewById(R.id.button_menu);
        button_menu.setOnClickListener(this);

        textCurrentQuestion = findViewById(R.id.current_question);

        statement = findViewById(R.id.statement);

        textScore = findViewById(R.id.textScore);

        button_next_question = findViewById(R.id.button_next_question);
        button_next_question.setOnClickListener(this);

        clause1 = findViewById(R.id.clause1);
        clause1.setOnClickListener(this);
        clause2 = findViewById(R.id.clause2);
        clause2.setOnClickListener(this);
        clause3 = findViewById(R.id.clause3);
        clause3.setOnClickListener(this);
        clause4 = findViewById(R.id.clause4);
        clause4.setOnClickListener(this);

        // lecture du fichier json
        InputStream inputStream = ((Context)this).getResources().openRawResource(R.raw.questions);
        String jsonString = new Scanner(inputStream).useDelimiter("\\A").next();
        try {
            jsonArray = new JSONArray(jsonString);
            for (int i=0; i < maxQuestion; i++)
                questions.add(loadQuestion(i+1));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        statement.setText(questions.get(idQuestion).getStatementText());
        clause1.setText(questions.get(idQuestion).getClause(0).getText());
        clause2.setText(questions.get(idQuestion).getClause(1).getText());
        clause3.setText(questions.get(idQuestion).getClause(2).getText());
        clause4.setText(questions.get(idQuestion).getClause(3).getText());
        textCurrentQuestion.setText("Question "+currentQuestion+" sur "+maxQuestion);
        textScore.setText("Score : "+score+" / "+maxQuestion);
    }

    /**
     *
     * Recuperer les questions dans le fichier .json
     * @param id
     * @return
     * @throws JSONException
     */
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
        if (currentQuestion > 10) {
            statement.setText("Vous avez fini le quiz avec un score de "+score+" sur "+maxQuestion+" !\n" +
                    "Cliquez sur le bouton menu pour revenir au menu.");
            setButtonNextEnable(false);
            setButtonClauseEnable(false);
        } else {
            if (currentQuestion == 10)
                button_next_question.setText("Finir");
            textCurrentQuestion.setText("Question "+currentQuestion+" sur "+maxQuestion);
            idQuestion++;
            statement.setText(questions.get(idQuestion).getStatementText());
            clause1.setText(questions.get(idQuestion).getClause(0).getText());
            clause2.setText(questions.get(idQuestion).getClause(1).getText());
            clause3.setText(questions.get(idQuestion).getClause(2).getText());
            clause4.setText(questions.get(idQuestion).getClause(3).getText());
            setButtonNextEnable(false);
            setDefaultButtonColorClause();
            setButtonClauseEnable(true);
        }
    }

    protected void checkAnswer(Button button, int id) {
        setButtonClauseEnable(false);
        if (questions.get(idQuestion).getClause(id).isAnswer()) {
            score++;
            textScore.setText("Score : "+score+" / "+maxQuestion);
            button.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.green_right_answer, null));
        } else {
            button.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.red_wrong_answer, null));
        }
        setButtonNextEnable(true);
    }

    private void setButtonClauseEnable(boolean enable) {
        if (!enable) {
            clause1.setEnabled(false);
            clause2.setEnabled(false);
            clause3.setEnabled(false);
            clause3.setEnabled(false);
        } else {
            clause1.setEnabled(true);
            clause2.setEnabled(true);
            clause3.setEnabled(true);
            clause3.setEnabled(true);
        }
    }

    private void setButtonNextEnable(boolean enable) {
        if (!enable) {
            button_next_question.setEnabled(false);
            button_next_question.setTextColor(ResourcesCompat.getColor(getResources(), R.color.grey_disable, null));
        } else {
            button_next_question.setEnabled(true);
            button_next_question.setTextColor(ResourcesCompat.getColor(getResources(), R.color.blue_dark, null));
        }
    }

    private void setDefaultButtonColorClause() {
        clause1.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.red_clause, null));
        clause2.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.blue_clause, null));
        clause3.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.yellow_clause, null));
        clause4.setBackgroundColor(ResourcesCompat.getColor(getResources(), R.color.green_clause, null));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.clause1:
                checkAnswer((Button)findViewById(R.id.clause1), 0);
                break;
            case R.id.clause2:
                checkAnswer((Button)findViewById(R.id.clause2), 1);
                break;
            case R.id.clause3:
                checkAnswer((Button)findViewById(R.id.clause3), 2);
                break;
            case R.id.clause4:
                checkAnswer((Button)findViewById(R.id.clause4), 3);
                break;
            case R.id.button_next_question:
                nextQuestion();
                break;
            case R.id.button_menu:
                finish();
                break;
        }
    }
}
