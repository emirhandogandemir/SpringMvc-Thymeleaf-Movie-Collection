package com.movie.moviecollection.repository;

import com.movie.moviecollection.model.Actor;
import com.movie.moviecollection.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ActorRepository extends JpaRepository<Actor, Integer> {

    Optional<List<Actor>> findAllByNameContaining(String name); // name içeren aktörleri sıralama

    Optional<Actor> getByName(String name); // tam adı verilen tek bir aktörü sıralama
}
