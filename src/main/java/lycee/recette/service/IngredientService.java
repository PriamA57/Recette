package lycee.recette.service;
import lycee.recette.entity.Ingredient;
import lycee.recette.repository.IngredientRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> listerTous() {
        return ingredientRepository.findAll();
    }

    public Ingredient enregistrer(Ingredient r) {
        return ingredientRepository.save(r);
    }

    public Ingredient trouverParId(Long id) {
        return ingredientRepository.findById(id).orElseThrow();
    }
}
