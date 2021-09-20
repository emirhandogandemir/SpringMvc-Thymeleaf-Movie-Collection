package com.movie.moviecollection.service.impl;

import com.movie.moviecollection.dto.ActorDto;
import com.movie.moviecollection.mapper.ActorMapper;
import com.movie.moviecollection.model.Actor;
import com.movie.moviecollection.repository.ActorRepository;
import com.movie.moviecollection.service.ActorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;


    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;

    }


    @Override
    public void addNewActor(Actor actor) {
        this.actorRepository.save(actor);
    }

    @Override
    public List<Actor> getAllActors() {
        return this.actorRepository.findAll();
    }

    @Override
    public Actor findActorById(int id) {
        return this.actorRepository.getById(id);
    }

    @Override
    public Actor updateActor(Actor actor) {
        return this.actorRepository.save(actor);
    }

    @Override
    public void deleteMovieById(int id) {
        this.actorRepository.deleteById(id);
    }
}
