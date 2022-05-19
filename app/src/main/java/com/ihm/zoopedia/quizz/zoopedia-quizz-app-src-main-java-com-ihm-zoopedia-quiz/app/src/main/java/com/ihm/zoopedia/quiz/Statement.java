package com.ihm.zoopedia.quiz;

/**
 * Classe représentant un enonce
 * @Author Baptiste Lelievre
 */
public class Statement {

    /** texte de l'enonce */
    private String text;

    /** image de l'enonce */
    //@DrawableRes
    private String image;

    /**
     * Constructeur
     * @param text texte de l'enonce
     * @param image image de l'enonce
     */
    public Statement(String text, String image) {
        this.text = text;
        this.image = image;
    }

    /**
     * getter du texte de l'enonce
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * getter de l'image de l'enonce
     * @return image
     */
    //@DrawableRes
    public String getImage() {
        return image;
    }

}
