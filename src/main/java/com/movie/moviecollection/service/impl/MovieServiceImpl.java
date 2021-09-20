package com.movie.moviecollection.service.impl;

import com.movie.moviecollection.dto.MovieDto;
import com.movie.moviecollection.model.Movie;
import com.movie.moviecollection.repository.MovieRepository;
import com.movie.moviecollection.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    @Override
    public Movie addNewMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie findByMovieDto(int id) {
        return this.movieRepository.getById(id);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return this.movieRepository.save(movie);
    }

    @Override
    public void deleteByMovieId(int id) {
        this.movieRepository.deleteById(id);
    }
}
