package Factory;

import doa.EtudiantDAODictionary;
import doa.EtudiantDOA;

public class EtudiantDictFactory implements EtudiantDoaFactory {
    @Override
    public EtudiantDAODictionary createEtudiantDoa() {
        return new EtudiantDAODictionary();
    }
}
