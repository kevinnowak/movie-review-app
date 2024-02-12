package com.github.kevinowak.movies.persistence.repository;

import com.github.kevinowak.movies.persistence.entity.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    Optional<Movie> getByImdbId(String imdb);
}
