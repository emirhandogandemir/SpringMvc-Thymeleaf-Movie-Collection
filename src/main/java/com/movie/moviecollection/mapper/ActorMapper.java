package com.movie.moviecollection.mapper;

import com.movie.moviecollection.dto.ActorDto;
import com.movie.moviecollection.model.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel="spring")
public interface ActorMapper
{
    @Named("toEntity")
    Actor actorDtoToActor(ActorDto actorDto);

    @Named("toDto")
    ActorDto userToUserDto(Actor actor);


}
