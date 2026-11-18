package lycee.recette.controller;

import lycee.recette.entity.Recette;
import lycee.recette.repository.RecetteRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecetteController {

    private final RecetteRepository recetteRepository;

    public RecetteController(RecetteRepository recetteRepository) {
        this.recetteRepository = recetteRepository;
    }

    @GetMapping({"/", "/recettes"})
    public String liste(Model model) {
        model.addAttribute("recettes", recetteRepository.findAll());
        return "recettes/liste";
    }

    @GetMapping("/recettes/ajouter")
    public String formulaireAjout(Model model) {
        model.addAttribute("recette", new Recette());
        return "recettes/formulaire";
    }

    @PostMapping("/recettes/enregistrer")
    public String enregistrer(@ModelAttribute Recette recette) {
        recetteRepository.save(recette);
        return "redirect:/recettes";
    }

    @GetMapping("/recettes/modifier/{id}")
    public String formulaireModif(@PathVariable Long id, Model model) {
        Recette recette = recetteRepository.findById(id).orElseThrow();
        model.addAttribute("recette", recette);
        return "recettes/formulaire";
    }

    @PostMapping("/recettes/supprimer/{id}")
    public String supprimer(@PathVariable Long id) {
        recetteRepository.deleteById(id);
        return "redirect:/recettes";
    }
}