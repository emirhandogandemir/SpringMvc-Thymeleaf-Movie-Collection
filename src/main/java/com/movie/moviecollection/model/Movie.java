package com.movie.moviecollection.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="release_year",nullable = false)
    private String releaseYear;

    @Column(name="type",nullable = false)
    private String type;

    @Column(name="explanation",nullable = false)
    private String explanation;

    @Column(name="media",nullable = false)
    private String media;

    @Column(name="language",nullable = false)
    private String language;

    @OneToMany(mappedBy = "movie",fetch = FetchType.EAGER,cascade =CascadeType.ALL)
    private Set<Actor> actors = new HashSet<>();

    public Movie(){

    }

    public Movie(int id, String releaseYear, String type, String explanation, String media, String language, Set<Actor> actors) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.type = type;
        this.explanation = explanation;
        this.media = media;
        this.language = language;
        this.actors = actors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", releaseYear=" + releaseYear +
                ", type='" + type + '\'' +
                ", explanation='" + explanation + '\'' +
                ", media='" + media + '\'' +
                ", language='" + language + '\'' +
                ", actors=" + actors +
                '}';
    }
}
