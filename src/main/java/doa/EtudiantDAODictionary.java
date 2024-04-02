package doa;

import Factory.EtudiantDictFactory;
import Factory.EtudiantDoaFactory;

import java.util.*;
import java.util.stream.Collectors;

public class EtudiantDAODictionary implements EtudiantDOA {
    Map<Integer, Etudiant> MapEtudiant = new HashMap<Integer, Etudiant>();


    public static int counter = 1;
    private int id;

    public EtudiantDAODictionary() {
    }

    public EtudiantDAODictionary(Etudiant et) {
        MapEtudiant.put(counter++, et);
    }

    public EtudiantDAODictionary(Map<Integer, Etudiant> ets) {
        counter += ets.size();
        MapEtudiant.putAll(ets);
    }

    @Override
    public void addStudent(Etudiant etudiant) {
        MapEtudiant.put(etudiant.getId(), etudiant);
    }

    @Override
    public List<Etudiant> getAllStudents() {
        return MapEtudiant.entrySet()
                .stream()
                .map((Map.Entry<Integer, Etudiant> ets) -> ets.getValue())
                .collect(Collectors.toList());

    }

    @Override
    public Etudiant serachById(int id) throws Exception {
        List<Etudiant> dt = getAllStudents().stream().filter((Etudiant ele) -> ele.getId() == id).collect(Collectors.toList());
        if (dt.isEmpty()) {
            throw new Exception("Utilisateur Eroor!!");
        } else {
            return dt.get(0);
        }
    }

    @Override
    public void updateStudent(Etudiant et) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir l'identifient d'utilisateur : ");
        Etudiant find = null;
        try {
            int index = sc.nextInt();
            find = serachById(index) != null ? (MapEtudiant.remove(index) ) : null;
            if (find != null){
                MapEtudiant.put(index,et);
                System.out.println("coordonees de etudiant bien modifier");
            }else {
                System.out.println("etudiant n'existe pas dans la liste");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
