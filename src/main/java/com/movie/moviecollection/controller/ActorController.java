package com.movie.moviecollection.controller;

import com.movie.moviecollection.model.Actor;
import com.movie.moviecollection.service.ActorService;
import com.movie.moviecollection.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ActorController {

    private final ActorService actorService;
    private final MovieService movieService;

    public ActorController(ActorService actorService,MovieService movieService) {

        this.actorService = actorService;
        this.movieService=movieService;
    }

    @RequestMapping(value="/")
    public String viewHomePage(Model model) {
        model.addAttribute("listActors", actorService.getAllActors());
        model.addAttribute("listMovies",movieService.getAllMovies());
        return "index";
    }

    @RequestMapping("/getByActorId/{id}")
    public String getById(@PathVariable(value = "id") int id ,Model model){
        Actor actor = this.actorService.findActorById(id);
        model.addAttribute("actor",actor);
        return "actor_detail";
    }

    @RequestMapping("/showNewActorForm")
    public String showNewActorForm(Model model) {
        Actor actor = new Actor();
        model.addAttribute("actor", actor);
        return "new_actor";
    }

    @RequestMapping(value = "/saveActor",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
    public String saveActor(Actor actor) {
        this.actorService.addNewActor(actor);
        return "redirect:/";
    }

    @RequestMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        Actor actor = this.actorService.findActorById(id);
        model.addAttribute("actor", actor);
        return "update_actor";
    }

    @RequestMapping(value = "/deleteActor/{id}",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
    public String deleteActor(@PathVariable(value = "id") int id, Model model) {

        this.actorService.deleteActorById(id);
        return "redirect:/";

    }

}
