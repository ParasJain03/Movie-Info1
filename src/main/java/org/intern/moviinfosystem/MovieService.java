package org.intern.moviinfosystem;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return movieRepository.findByGenre(genre);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);

        if (optionalMovie.isPresent()) {
            Movie existingMovie = optionalMovie.get();


            existingMovie.setName(updatedMovie.getName());
            existingMovie.setGenre(updatedMovie.getGenre());
            existingMovie.setRating(updatedMovie.getRating());
            existingMovie.setReleaseYear(updatedMovie.getReleaseYear());

            return movieRepository.save(existingMovie);
        } else {
            throw new RuntimeException("Movie with id " + id + " not found.");
        }
    }
}

