package lycee.recette.entity;
import jakarta.persistence.*;

@Entity
public class Recette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @Column(nullable = false)
    private String titre;
    private String description;
    private Long temps;
    private String difficulte;
    private Integer nb_personnes;

    public Recette() {
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getTitre() {return titre;}
    public void setTitre(String titre) {this.titre = titre;}

    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    public Long getTemps() {return temps;}
    public void setTemps(Long temps) {this.temps = temps;}

    public String getDifficulte() {return difficulte;}
    public void setDifficulte(String difficulte) {this.difficulte = difficulte;}

    public Integer getNb_personnes() {return nb_personnes;}
    public void setNb_personnes(Integer nb_personnes) {this.nb_personnes = nb_personnes;}
}