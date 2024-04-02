package doa;

import Factory.EtudiantDoaFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Etudiant implements EtudiantDOA {
    ArrayList<Etudiant> ListEtudiant = new ArrayList<>();
    public static int counter = 1;
    private int id;
    private String name;
    private String prenom;
    private String email;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Etudiant() {
        this.id = Etudiant.counter++;
    }

    public Etudiant(String name, String prenom, String email) {
        this.id = Etudiant.counter++;
        this.name = name;
        this.prenom = prenom;
        this.email = email;
    }

    @Override
    public void addStudent(Etudiant e) {
        ListEtudiant.add(e);

    }


    @Override
    public List<Etudiant> getAllStudents() {
        return ListEtudiant;
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

    public Etudiant createStudent() {
        Etudiant st = new Etudiant();
        Scanner sc = new Scanner(System.in);
        System.out.println("Entrer votre nom : ");
        st.setName(sc.next());
        System.out.println("Entrer votre prenom : ");
        st.setPrenom(sc.next());
        System.out.println("Entrer votre mail : ");
        st.setEmail(sc.next());
        return st;
    }

    @Override
    public void updateStudent(Etudiant et) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Saisir l'identifient d'utilisateur : ");
        Etudiant find = null;
        try {
            int index = sc.nextInt();
            find = serachById(index) != null ? ListEtudiant.set(index,et) : null;
            if (find != null){
                System.out.println("coordonees de etudiant bien modifier");
            }else {
                System.out.println("etudiant n'existe pas dans la liste");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Etudiant{" +
                "id='" + +this.getId() + '\'' +
                "name='" + name + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

}
