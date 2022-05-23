package com.ihm.zoopedia.quiz;


import java.util.ArrayList;

/**
 * Classe representant une classe
 * @author Baptiste Lelievre
 */
public class Question {

    // enonce de la question
    private Statement statement;

    // liste des propositions
    private ArrayList<Clause> clauses;

    /**
     * Constructeur
     * @param statement
     * @param clauses
     */
    public Question(Statement statement, ArrayList<Clause> clauses) {
        this.statement = statement;
        this.clauses = clauses;
    }

    /**
     * recupere le texte de l'enonce
     * @return statement.getText()
     */
    public String getStatementText() {
        return statement.getText();
    }

    /**
     * retourne une clause par son emplacemnt dans la liste
     * @param n
     * @return
     */
    public Clause getClause(int n) {
        return clauses.get(n);
    }


}
