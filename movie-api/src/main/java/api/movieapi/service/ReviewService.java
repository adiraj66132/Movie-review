package api.movieapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import api.movieapi.entity.Movie;
import api.movieapi.entity.Review;
import api.movieapi.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepo;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public Review createReview(String reviewBody, String imdbId) {
		Review newReview = new Review();
		newReview.setBody(reviewBody);
		
		reviewRepo.insert(newReview);
		
		mongoTemplate.update(Movie.class)
				.matching(Criteria.where("imdbId").is(imdbId))
				.apply(new Update().push("reviewIds").value(newReview))
				.first();
		
		return newReview;
	}
}
