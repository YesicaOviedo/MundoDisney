package com.app.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Character;
import com.app.model.Movie;
import com.app.model.MovieDTO;
import com.app.services.CharacterService;
import com.app.services.MovieService;

@RestController
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	MovieService movieService;
	@Autowired
	CharacterService characterService;

    @GetMapping()
    public List<Movie> obtenerMovies(@RequestParam(required=false) String title){
        return movieService.moviesByParams(title);
    }

    public List<Character> charactersMovie(MovieDTO movieDTO){
    	List<Long> idsPersEnMovie = movieDTO.getIdsCharacters();
    	List<Character> charactersInMovie = new ArrayList<Character>();
    	for(int i=0; i<idsPersEnMovie.size();i++) {
    		Optional<Character> resultado = characterService.obtenerPorId(idsPersEnMovie.get(i));
    		if(resultado.isPresent()) {
    			charactersInMovie.add(resultado.get());
    		}
    	}
    	return charactersInMovie;
    }

    @PostMapping()
    public Movie guardarMovie(@RequestBody MovieDTO movieDTO){
    	Movie movie = new Movie();
    	movie.setRating(movieDTO.getRating());
    	movie.setDate(movieDTO.getDate());
    	movie.setTitle(movieDTO.getTitle());
    	movie.setCharacters(charactersMovie(movieDTO));
    	movie.validate();
    	return this.movieService.guardarMovie(movie);
    }

    @GetMapping( path = "/{id}")
    public Optional<Movie> obtenerMoviePorId(@PathVariable("id") Long id) {
        return this.movieService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.movieService.eliminarMovie(id);
        if (ok){
            return "Se eliminó la pelicula con id " + id;
        }else{
            return "No pudo eliminar el pelicula con id" + id;
        }
    }

}
