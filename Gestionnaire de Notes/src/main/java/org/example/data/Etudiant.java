package org.example.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Etudiant {

    private String nom;
    private ArrayList<Matier> matiers;

    public String getNom() {
        return nom;
    }

    public void setMatiers(List<Matier> matiers) {
        this.matiers.clear();
        this.matiers.addAll(matiers);
    }

    public Etudiant(String nom) {
        this.nom = nom;
        matiers = new ArrayList<>();
        initMatiers();
    }

    public void setNom(String nom) {
        this.nom = nom;

    }

    public List<Matier> getMatiers() {
        return matiers;
    }

    //Ajouter Matiers
    public void ajouterMatiers(String nomMatier) {
        Matier matier = new Matier(nomMatier);
        matiers.add(matier);
    }

    private void initMatiers() {
        ajouterMatiers("Physique");
        ajouterMatiers("Math");
        ajouterMatiers("Svt");
        ajouterMatiers("Islamic");
        ajouterMatiers("Arab");
        ajouterMatiers("Sport");

    }

    public void printNomMatiers() {

        for (Matier matier : this.matiers
        ) {
            System.out.print(matier.getNom() + " | ");
        }
        System.out.println("");
    }

    public Optional<Matier> getMatierParNom(String nom) {
        return this.matiers.stream().filter(m -> m.getNom().equalsIgnoreCase(nom)).findFirst();
    }

    public int getIndexMatier(Matier matier) {
        return this.matiers.indexOf(matier);
    }

}
