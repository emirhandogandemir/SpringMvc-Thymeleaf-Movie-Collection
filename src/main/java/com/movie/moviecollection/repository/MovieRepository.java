package com.movie.moviecollection.repository;

import com.movie.moviecollection.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Integer> {

    Optional<Movie> getByName(String name); // film adına göre tek bir adet döndürme

    Optional<List<Movie>> findAllByNameContaining(String name); // verilen isme içerenlere göre sıralama

    List<Movie> findByOrderByReleaseYear(); // yayınlanma yılına göre

    Optional<List<Movie>> findAllByTypeContaining(String name); // film türünü içeren filmleri listeleme

}
