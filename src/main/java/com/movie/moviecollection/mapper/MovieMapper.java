package com.movie.moviecollection.mapper;

import com.movie.moviecollection.dto.MovieDto;
import com.movie.moviecollection.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel ="spring")
public interface MovieMapper {

    @Named("toEntity")
    Movie movieDtoToMovie(MovieDto movieDto);

    @Named("toDto")
    MovieDto movieToMovieDto(Movie movie);
}
