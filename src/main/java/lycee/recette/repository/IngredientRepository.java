package lycee.recette.repository;
import lycee.recette.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IngredientRepository
        extends JpaRepository<Ingredient, Long>{
}
