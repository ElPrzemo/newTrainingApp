package com.example.newtrainingapp.part5;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class PcGameController {

    private final PcGameRepository pcGameRepository;

    public PcGameController(PcGameRepository pcGameRepository) {
        this.pcGameRepository = pcGameRepository;
    }

    @GetMapping("/pc-games")
    public String showAddObjectForm(Model model) {
        model.addAttribute("pcGameForm", new PCGameForm());
        return "pcgameCreateForm";
    }

    @PostMapping("/pc-games")
    public String saveObject(@ModelAttribute("pcGameForm") PCGameForm pcGameForm) {
        pcGameRepository.save(pcGameForm);
        return "redirect:/pc-games"; // Możesz przekierować na inny URL po zapisaniu obiektu
    }
}