package com.movie.moviecollection.mapper;

import com.movie.moviecollection.dto.ActorDto;
import com.movie.moviecollection.model.Actor;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel="spring")
public interface ActorMapper
{

    Actor actorDtoToActor(ActorDto actorDto);


    ActorDto userToUserDto(Actor actor);

    //@IterableMapping(qualifiedByName = "toDto")
    List<ActorDto> actorsToActorDtos(List<Actor> actors);


}
