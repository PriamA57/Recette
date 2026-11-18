package lycee.recette.controller;

import lycee.recette.entity.Recette;
import lycee.recette.service.RecetteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/recettes")
public class RecetteController {
    private final RecetteService service;

    public RecetteController(RecetteService service) {
        this.service = service;
    }

    @GetMapping
    public String lister(Model model) {
        model.addAttribute("recettes", service.listerTous());
        return "recettes/liste";
    }

    @GetMapping("/nouveau")
    public String formulaire(Model model) {
        model.addAttribute("recette", new Recette());
        return "recettes/formulaire";
    }

    @PostMapping
    public String enregistrer(@ModelAttribute Recette recette) {
        service.enregistrer(recette);
        return "redirect:/recettes";
    }
}
