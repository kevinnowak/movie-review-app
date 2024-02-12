package com.github.kevinowak.movies.persistence.repository;

import com.github.kevinowak.movies.persistence.entity.Review;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, ObjectId> {
}
