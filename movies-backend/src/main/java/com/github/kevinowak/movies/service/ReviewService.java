package com.github.kevinowak.movies.service;

import com.github.kevinowak.movies.persistence.entity.Movie;
import com.github.kevinowak.movies.persistence.entity.Review;
import com.github.kevinowak.movies.persistence.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, MongoTemplate mongoTemplate) {
        this.reviewRepository = reviewRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Review createReview(String reviewBody, String imdbIb) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbIb))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
