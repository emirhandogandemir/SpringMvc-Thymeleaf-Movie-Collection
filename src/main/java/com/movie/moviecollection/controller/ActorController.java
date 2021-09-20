package com.movie.moviecollection.controller;

import com.movie.moviecollection.model.Actor;
import com.movie.moviecollection.service.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/getAll")
        public String viewHomePage(Model model){
        model.addAttribute("listActors",actorService.getAllActors());
        return "index";
    }

    @GetMapping("/showNewActorForm")
    public String showNewActorForm(Model model){
        Actor actor = new Actor();
        model.addAttribute("actor",actor);
        return "new actor";
    }

    @PostMapping("/saveActor")
    public String saveActor(@ModelAttribute("actor") Actor actor){
        // save actor to database
        this.actorService.addNewActor(actor);
        return "redirect:/";
    }

}
