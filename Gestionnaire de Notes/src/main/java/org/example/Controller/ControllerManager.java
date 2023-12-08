package org.example.Controller;

import org.example.data.Etudiant;
import org.example.data.Matier;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ControllerManager {
    String  nomUtilisateur= "";
    Scanner scanner;
    ControllerEtudiants controllerEtudiants;


    public ControllerManager() {
        controllerEtudiants = new ControllerEtudiants();

        scanner = new Scanner(System.in);
    }

    public String validInputString(String message) {
        String nom;
        do {
            System.out.println("# ->"+message + " (seulement des lettres) : ");
            //accept only letter [a-zA-Z]+
            while (!scanner.hasNext("[a-zA-Z]+")) {
                System.out.println("Erreur ! Entrez uniquement des lettres.");

                scanner.next(); // consomme l'entrée invalide
            }
            nom = scanner.nextLine();
        } while (nom.isEmpty());
        // System.out.println("Le nom c est "+ nom);
        return nom;
    }

    public int validInputInt(String message) {
        String input;
        int number;

        do {
            System.out.print("Entrez un nombre : ");
            input = scanner.next();
            if (!input.matches("\\d+")) {
                System.out.println(message);
            }
        } while (!input.matches("\\d+"));

        return Integer.parseInt(input);
    }

    public void ajouterDesNotesEtudiant() {

        String nom = validInputString("entrer le nom de l'étudiant.");
        Etudiant etudiant;
        Optional<Etudiant> optionalEtudiant = controllerEtudiants.rechercheEtudiantParNom(nom);
        if (optionalEtudiant.isEmpty()) {
            etudiant = controllerEtudiants.ajouterEtudiant(nom);
        } else {
            etudiant = optionalEtudiant.get();
        }
        aficherEtudient(etudiant);
        // System.out.println(controllerEtudiants.getIndex(etudiant));
        ajouternotes(etudiant);


    }

    private void aficherEtudient(Etudiant etudiant) {
        System.out.println("L'étudiant est " + etudiant.getNom());
        for (Matier matier : etudiant.getMatiers()
        ) {
            System.out.print(matier.getNom() + " : ");
            for (int note : matier.getNotes()
            ) {
                System.out.print(note + " ");
            }
            System.out.println("");
        }

    }

    private void ajouternotes(Etudiant etudiant) {
        int index = controllerEtudiants.getIndex(etudiant);
        System.out.println("Saisir  les notes pour " + etudiant.getNom());

        System.out.print("# ->Pour saisir  les notes pour un seul  Mateir  Taper 1 \n");
        System.out.print("# ->Pour saisir  les notes pour chaque Mateir  Taper 2 \n");
        // System.out.print("les note doit entre 0 et 20. \n");
        int option = validInputInt("Soit tout mateirs 1 ou un matier 2");
        switch (option) {
            case 1:

                Matier matier = getMatier(etudiant);
                int indexMatier = etudiant.getIndexMatier(matier);
                System.out.println("Combien des notes : ");
                int noteSize = validInputInt("Combien des notes");
                for (int i = 0; i < noteSize; i++) {
                    System.out.println("note " + (i + 1) + " : ");
                    int note = note();
                    matier.getNotes().add(note);
                }
                controllerEtudiants.getEtudients().get(index).getMatiers().get(indexMatier).setNotes(matier.getNotes());
                aficherEtudient(etudiant);
                break;
            case 2:
                for (int i = 0; i < etudiant.getMatiers().size(); i++) {
                    System.out.println(etudiant.getMatiers().get(i).getNom() + " : ");
                    System.out.println("Combien des notes : ");
                    int noteSize2 = validInputInt("Combien des notes");
                    for (int j = 0; j < noteSize2; j++) {
                        System.out.println("note " + (j + 1) + " : ");
                        int note = note();
                        etudiant.getMatiers().get(i).getNotes().add(note);
                    }

                }
                controllerEtudiants.getEtudients().get(index).setMatiers(etudiant.getMatiers());
                aficherEtudient(etudiant);

                break;
            default:
                break;

        }


    }

    private Matier getMatier(Etudiant etudiant) {
        etudiant.printNomMatiers();
        String matierNom = validInputString("Saisir  le nom de  matier  seulement set noms ");
        Matier matier = etudiant.getMatierParNom(matierNom).get();
        return matier;
    }

    private boolean checkNote(int note) {
        return note >= 0 && note <= 20;
    }

    private int note() {
        int note = validInputInt("les note doit entre 0 et 20. \\n");
        if (checkNote(note)) {
            return note;
        }

        return note();
    }

    //    Calcul de la Moyenne :
    //    Demandez à l'utilisateur d'entrer le nom de l'étudiant.
    //    Recherchez si l'étudiant existe dans la structure de données.
    //    Utilisez une boucle pour permettre à l'utilisateur de saisir les matières pour lesquelles il souhaite calculer la moyenne.
    //    Assurez-vous que les matières et les notes sont valides.
    //    Calculez la moyenne des notes pour chaque matière et affichez-la.
    //    Calculez la moyenne générale si l'utilisateur le souhaite.
    public void CalculMoyen() {

        String nom = validInputString("entrer le nom de l'étudiant : ");
        Optional<Etudiant> optionalEtudiant = controllerEtudiants.rechercheEtudiantParNom(nom);
        Etudiant etudiant;
        if (optionalEtudiant.isEmpty()) {
            System.out.println("Etudiant not exist");
            System.out.println("# -> Pour entree autre etudiant taper 1");
            System.out.println("# -> c est tu veux ajouter nouveaux etudient taper 2");

            int option = validInputInt("");
            switch (option) {
                case 1:
                    ajouterDesNotesEtudiant();
                    MainMenu();
                    return;
                case 2:
                    CalculMoyen();
                    MainMenu();

                    return;
                default:


            }


        }
        etudiant = optionalEtudiant.get();
        System.out.println("# ->les matières pour lesquelles il souhaite calculer la moyenne.  taper 1");
        System.out.println("# ->Calculez la moyenne des notes pour chaque matière   taper 2");
        System.out.println("# ->Calculez la moyenne générale   taper 3");
        int optionMoyen = validInputInt("Enter le nemuro :");
        switch (optionMoyen) {
            case 1:
                Matier matier = getMatier(etudiant);
                printMatier(matier);
                break;
            case 2:

                for (Matier chaqueMatier : etudiant.getMatiers()
                ) {

                    printMatier(chaqueMatier);
                }
                break;
            case 3:
                float moyenGeneral = 0;
                int moyenGeneraleffctifTotal = etudiant.getMatiers().size() ;
                for (Matier chaqueMatier : etudiant.getMatiers()
                ) {

                    moyenGeneral += moyen(chaqueMatier.getNotes());
                }
                float result= (float)moyenGeneral/ moyenGeneraleffctifTotal;
                System.out.println(" la moyenne générale  c est " + result);
        }

    }

    private void printMatier(Matier matier) {
        System.out.println("Le Moyen de " + matier.getNom() + " c est : " + moyen(matier.getNotes()));
    }

    private float moyen(List<Integer> notes) {
        int effectifTotal;
        if (notes.isEmpty()) {
            return 0;
        } else {
            effectifTotal = notes.size();
        }

        int totalNote = 0;
        for (Integer note : notes
        ) {
            totalNote += note;
        }
        float n = (float) totalNote / effectifTotal;
        return n;

    }

    public void MainMenu() {
        String mainMenuMessage = "# ->Pour Saisie des Notes d'un Étudiant Taper 1 \n" +
                "# ->Pour Aficher les notes des etudiants 2 \n" +
                "# ->Pour Calcul de la Moyenne des Notes d'un Étudiant Taper 3 \n" +
                "# ->Pour exit le programme  Taper 4 \n";
    if (nomUtilisateur.isBlank()){
        nomUtilisateur = validInputString("Entrer ton nom");
    }

        option:
        while (true) {
            System.out.println("#####################################################");
            System.out.println("\t \t \t \t Gestionnaire de Notes");
            System.out.println("\t \t \t \t \t  Bonjour " + nomUtilisateur);
            System.out.println("#####################################################");
            System.out.println(mainMenuMessage);

            int option = validInputInt(mainMenuMessage);
            switch (option) {
                case 1:
                    ajouterDesNotesEtudiant();
                    break ;
                case 2:
                    System.out.println("============================================================");
                    if (controllerEtudiants.getEtudients().isEmpty()){
                        System.out.println("No etudiant Exists");

                    }

                    for (Etudiant etudiant: controllerEtudiants.getEtudients()
                    ) {

                        aficherEtudient(etudiant);
                    }
                    System.out.println("============================================================");
                    MainMenu();
                    break ;
                case 3:
                    CalculMoyen();
                    MainMenu();
                    break ;
                case 4:
                    break option;
                default:
                    break;

            }
        }
    }

}
