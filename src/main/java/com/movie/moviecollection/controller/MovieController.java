package com.movie.moviecollection.controller;

import com.movie.moviecollection.model.Actor;
import com.movie.moviecollection.model.Movie;
import com.movie.moviecollection.service.MovieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/saveMovie",method = {RequestMethod.GET,RequestMethod.POST})
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

    @GetMapping("/deleteMovie/{id}")
    public String deleteMovie(@PathVariable(value = "id") int id, Model model) {

        this.movieService.deleteByMovieId(id);
        return "redirect:/";

    }
    @RequestMapping("/getById/{id}")
    public String getById(@PathVariable(value = "id") int id, Model model) {
        Movie movie = this.movieService.findByMovie(id);
        model.addAttribute("movie", movie);
        return "movie_detail";

    }

}
