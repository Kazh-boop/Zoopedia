package com.ihm.zoopedia;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.widget.ImageView;

import java.io.Serializable;

public class Animal implements Serializable {

    private String nom;
    private String habitat;
    private String emplacement_zoo;

    public Animal(String nom, String habitat, String emplacement) {
        this.nom = nom;
        this.habitat = habitat;
        this.emplacement_zoo = emplacement;
    }

    public String getNom() {
        return nom;
    }

    public String getHabitat() {
        return habitat;
    }

    public String getEmplacement_zoo() {
        return emplacement_zoo;
    }

    public String toString() {
        return (nom + " / " + habitat+  " / " + emplacement_zoo);
    }


}
