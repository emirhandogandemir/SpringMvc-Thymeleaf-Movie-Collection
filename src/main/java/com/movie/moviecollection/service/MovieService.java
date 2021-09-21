package com.movie.moviecollection.service;

import com.movie.moviecollection.dto.MovieDto;
import com.movie.moviecollection.model.Movie;

import java.util.List;

public interface MovieService {

    Movie addNewMovie(Movie movie);

    List<Movie> getAllMovies();

    Movie findByMovie(int id);

    Movie updateMovie(Movie movie);

    void deleteByMovieId(int id);
}
