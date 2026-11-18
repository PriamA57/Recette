package lycee.recette.repository;
import lycee.recette.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RecetteRepository
        extends JpaRepository<Recette, Long>{
}
