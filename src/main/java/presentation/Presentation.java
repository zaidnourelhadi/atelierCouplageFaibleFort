package presentation;

import Factory.EtdiantListFactory;
import Factory.EtudiantDictFactory;
import Factory.EtudiantDoaFactory;
import doa.Etudiant;
import doa.EtudiantDAODictionary;
import doa.EtudiantDOA;
import metier.EtudiantManager;

import java.util.ArrayList;
import java.util.List;

public class Presentation {
    public static void main(String[] args) {
        EtudiantDoaFactory factory = new EtdiantListFactory();

        EtudiantDOA etudiantDAO = factory.createEtudiantDoa();

        EtudiantManager etudiantManager = new EtudiantManager(etudiantDAO);

        // Créer et ajouter 4 étudiants
        Etudiant etudiant1 = new Etudiant("Nom1", "Prenom1", "email1@example.com");
        Etudiant etudiant2 = new Etudiant("Nom2", "Prenom2", "email2@example.com");
        Etudiant etudiant3 = new Etudiant("Nom3", "Prenom3", "email3@example.com");
        Etudiant etudiant4 = new Etudiant("Nom4", "Prenom4", "email4@example.com");

        try {
            etudiantManager.addStudent(etudiant1);
            etudiantManager.addStudent(etudiant2);
            etudiantManager.addStudent(etudiant3);
            etudiantManager.addStudent(etudiant4);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Récupérer tous les étudiants
        List<Etudiant> etudiants = etudiantManager.getAllStudents();

        for (Etudiant etudiant : etudiants) {
            System.out.println(etudiant);
        }


        // Mettre un etudiant en mise a jour des donnes
        try {
            etudiantManager.etudiantDOA.updateStudent(new Etudiant("Nom4", "Prenom4", "email4@emsi-edu.ma"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
