package Factory;

import doa.Etudiant;
import doa.EtudiantDAODictionary;
import doa.EtudiantDOA;

public class EtdiantListFactory implements EtudiantDoaFactory {
    @Override
    public Etudiant createEtudiantDoa() {
        return new Etudiant();
    }
}
