package com.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Movie;
import com.app.repositories.MovieRepository;

@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;

	public ArrayList<Movie> obtenerMovies(){
		return (ArrayList<Movie>) movieRepository.findAll();
	}

    public List<Movie> moviesByParams(String title){
    	return movieRepository.findMovieByParams(title);
    }

	public Movie guardarMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Optional<Movie> obtenerPorId(Long id){
        return movieRepository.findById(id);
    }

    public boolean eliminarMovie(Long id) {
        try{
        	movieRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


}
