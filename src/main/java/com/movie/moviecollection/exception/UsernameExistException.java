package com.movie.moviecollection.exception;

public class UsernameExistException extends IllegalArgumentException{
    public UsernameExistException(){
        super("Username already in use .");
    }
}
