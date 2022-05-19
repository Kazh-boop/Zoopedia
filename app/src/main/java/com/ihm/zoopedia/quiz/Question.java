package com.ihm.zoopedia.quiz;


import java.util.ArrayList;

public class Question {

    private Statement statement;

    private ArrayList<Clause> clauses;

    public Question(Statement statement, ArrayList<Clause> clauses) {
        this.statement = statement;
        this.clauses = clauses;
    }

    public String getStatementText() {
        return statement.getText();
    }

    public Clause getClause(int n) {
        return clauses.get(n);
    }

    @Override
    public String toString() {
        return statement.getText();
    }


}
