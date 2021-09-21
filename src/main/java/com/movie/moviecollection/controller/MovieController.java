package com.movie.moviecollection.controller;

import com.movie.moviecollection.model.Actor;
import com.movie.moviecollection.model.Movie;
import com.movie.moviecollection.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @GetMapping("/showNewMovieForm")
    public String showNewMovieForm(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie",movie);
        return "new_movie";
    }

    @GetMapping("/getAllMovies")
    public List<Movie> getAllMovies(){
        return this.movieService.getAllMovies();
    }

    @PostMapping("/saveMovie")
    public String saveActor(@ModelAttribute("movie") Movie movie) {
        // save actor to database
        this.movieService.addNewMovie(movie);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdateMovie/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
        // get Actor
        Movie movie = this.movieService.findByMovie(id);
        model.addAttribute("movie", movie);
        return "update_movie";
    }

    @PostMapping("/deleteMovie/{id}")
    public String deleteActor(@PathVariable(value = "id") int id, Model model) {

        this.movieService.deleteByMovieId(id);
        return "redirect:/";

    }


}
