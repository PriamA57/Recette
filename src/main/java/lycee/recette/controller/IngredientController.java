package lycee.recette.controller;

import lycee.recette.entity.Ingredient;
import lycee.recette.repository.IngredientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IngredientController {

    private final IngredientRepository ingredientRepository;

    public IngredientController(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping("/ingredients")
    public String liste(Model model) {
        model.addAttribute("ingredients", ingredientRepository.findAll());
        return "ingredients/liste";
    }

    @GetMapping("/ingredients/ajouter")
    public String formulaireAjout(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "ingredients/formulaire";
    }

    @GetMapping("/ingredients/modifier/{id}")
    public String formulaireModif(@PathVariable Long id, Model model) {
        model.addAttribute("ingredient", ingredientRepository.findById(id).orElseThrow());
        return "ingredients/formulaire";
    }

    @PostMapping("/ingredients/enregistrer")
    public String enregistrer(@ModelAttribute Ingredient ingredient) {
        ingredientRepository.save(ingredient);
        return "redirect:/ingredients";
    }

    @PostMapping("/ingredients/supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        ingredientRepository.deleteById(id);
        return "redirect:/ingredients";
    }
}
