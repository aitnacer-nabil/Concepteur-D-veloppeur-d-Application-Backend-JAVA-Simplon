package org.example.Controller;

import org.example.data.Etudiant;

import java.util.ArrayList;
import java.util.Optional;

public class ControllerEtudiants {
    private ArrayList<Etudiant> etudiants;

    public ControllerEtudiants() {
        etudiants = new ArrayList<>();
    }

    public ControllerEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public ArrayList<Etudiant> getEtudients() {
        return etudiants;
    }

    public void setEtudients(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    public Etudiant ajouterEtudiant(String name) {
        Etudiant etudiant = new Etudiant(name);
        etudiants.add(etudiant);
        return etudiant;
    }

    public Optional<Etudiant> rechercheEtudiantParNom(String name) {
        return this.etudiants.stream().filter(e -> e.getNom().equalsIgnoreCase(name)).findFirst();
    }
    public int getIndex(Etudiant etudiant){
        return  etudiants.indexOf(etudiant);
    }


}
