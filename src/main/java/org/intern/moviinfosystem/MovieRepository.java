package org.intern.moviinfosystem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository <Movie,Long>{
    List<Movie> findByGenre(String genre);
}
