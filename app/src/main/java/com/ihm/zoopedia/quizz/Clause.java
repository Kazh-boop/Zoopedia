package com.ihm.zoopedia.quizz;

/**
 * Classe representant une reponse/proposition
 *
 * @Author Baptiste Lelievre
 */
public class Clause {

    /** Enonce de la proposition */
    private String text;
    /** Valeur de la proposition */
    private boolean answer;

    /**
     * Constructeur
     * @param text Enonce de la proposition
     * @param answer Valeur de la proposition
     */
    public Clause(String text, boolean answer) {
        this.text = text;
        this.answer = answer;
    }

    /**
     * Getter du texte de la proposition
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Getter de la valeur de la proposition
     * true si la proposition est vraie
     * false sinon
     * @return answer
     */
    public boolean isAnswer() {
        return answer;
    }
}
