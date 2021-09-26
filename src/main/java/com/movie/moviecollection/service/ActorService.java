package com.movie.moviecollection.service;

import com.movie.moviecollection.dto.ActorDto;
import com.movie.moviecollection.model.Actor;

import java.util.List;
import java.util.Optional;

public interface ActorService {

    void addNewActor(Actor actor);

    List<Actor> getAllActors();

    Actor findActorById(int id);

    Actor updateActor(Actor actor);

    void deleteByActorId(int id);

}
