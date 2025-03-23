package api.movieapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.movieapi.entity.Movie;
import api.movieapi.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepo;
	
	public List<Movie> fetchAllMovies(){
		return movieRepo.findAll();
	}
	
	public Optional<Movie> fetchMovie(String imdbId) {
		return movieRepo.findMovieByImdbId(imdbId);
	}
}
