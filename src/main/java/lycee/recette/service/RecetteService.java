package lycee.recette.service;
import lycee.recette.entity.Recette;
import lycee.recette.repository.RecetteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetteService {

    private final RecetteRepository recetteRepository;

    public RecetteService(RecetteRepository recetteRepository) {
        this.recetteRepository = recetteRepository;
    }

    public List<Recette> listerTous() {
       return recetteRepository.findAll();
    }

    public Recette trouverParId(Long id) {
        return recetteRepository.findById(id).orElseThrow();
    }

    public Recette enregistrer(Recette recette) {
        return recetteRepository.save(recette);
    }

    public void supprimer(Long id){
        recetteRepository.deleteById(id);
    }
}