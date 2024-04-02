package doa;

import metier.EtudiantManager;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public interface EtudiantDOA {


    // Add Student
    public void addStudent(Etudiant e);

    // Get Student
    public List<Etudiant> getAllStudents();

    public Etudiant serachById(int id) throws Exception ;

    public void updateStudent(Etudiant et);
}
