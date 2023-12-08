package org.example.data;

import java.util.ArrayList;
import java.util.List;

public class Matier {
    private String nom;
    private List<Integer> notes;

    public String getNom() {
        return nom;
    }

    public Matier(String nom) {
        this.nom = nom;
        this.notes = new ArrayList<>();
    }

    public List<Integer> getNotes() {
        return notes;
    }

    public void setNotes(List<Integer> notes) {
        this.notes = notes;
    }

    public Matier(String nom, int note) {
        this.nom = nom;

    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    public void ajouterNote(int note){
        notes.add(note);
    }


}
