package com.movie.moviecollection.controller;

import com.movie.moviecollection.model.Actor;
import com.movie.moviecollection.service.ActorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActorController {

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listActors", actorService.getAllActors());
        return "index";
    }

    @GetMapping("/showNewActorForm")
    public String showNewActorForm(Model model) {
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "new_actor";
    }

    @PostMapping("/saveActor")
    public String saveActor(@ModelAttribute("actor") Actor actor) {
        // save actor to database
        this.actorService.addNewActor(actor);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        // get Actor
        Actor actor = this.actorService.findActorById(id);
        model.addAttribute("actor", actor);
        return "update_actor";
    }

    @GetMapping("/deleteActor/{id}")
    public String deleteActor(@PathVariable(value = "id") int id, Model model) {

        this.actorService.deleteActorById(id);
        return "redirect:/";

    }

}
