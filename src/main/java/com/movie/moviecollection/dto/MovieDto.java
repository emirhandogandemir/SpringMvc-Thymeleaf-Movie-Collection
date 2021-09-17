package com.movie.moviecollection.dto;

import com.movie.moviecollection.model.Actor;

import java.util.Date;
import java.util.Set;

public class MovieDto {

    private int id;
    private String name;
    private Date releaseYear;
    private String type;
    private String explanation;
    private String media;
    private String language;
    private Set<Actor> actors;
}
