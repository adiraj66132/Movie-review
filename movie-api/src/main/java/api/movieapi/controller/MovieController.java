package api.movieapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.movieapi.entity.Movie;
import api.movieapi.service.MovieService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping(value = "/api/v1/movies")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies(){
		return new ResponseEntity<List<Movie>>(movieService.fetchAllMovies(), HttpStatus.OK);
	}
	
	@GetMapping("/{imdbId}")
	public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String imdbId){
		return new ResponseEntity<Optional<Movie>>(movieService.fetchMovie(imdbId), HttpStatus.OK);
	}
}
