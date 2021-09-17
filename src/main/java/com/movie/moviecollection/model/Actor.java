package com.movie.moviecollection.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="actors")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="surname",nullable = false)
    private String surname;

    @Column(name="role",nullable = true)
    private String role;

    @ManyToOne()
    @JoinColumn(name="movie_id")
    private Movie movie;

    public Actor(){

    }

    public Actor(int id, String name, String surname, String role, Movie movie) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.movie = movie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", role='" + role + '\'' +
                ", movie=" + movie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return id == actor.id && Objects.equals(name, actor.name) && Objects.equals(surname, actor.surname) && Objects.equals(role, actor.role) && Objects.equals(movie, actor.movie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, role, movie);
    }
}
