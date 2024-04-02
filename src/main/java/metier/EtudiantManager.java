package metier;

import doa.*;

import java.util.List;


public class EtudiantManager {
    public EtudiantDOA etudiantDOA;

    public EtudiantManager(EtudiantDOA et){
        etudiantDOA = et;
    }

    public Etudiant addStudent(Etudiant et) throws Exception{
        boolean bl =  etudiantDOA.getAllStudents().stream().anyMatch(etu->{
            return etu.getEmail().equals(et.getEmail());
        });
        if(bl){
            throw new Exception("Etudiant existe deja");
        }else{
            etudiantDOA.addStudent(et);
            return et;
        }
    }

    public List<Etudiant> getAllStudents(){
        return etudiantDOA.getAllStudents();
    }
}
