package dev.zu.bookreview.service;

import dev.zu.bookreview.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.zu.bookreview.repository.ReviewRepository;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    // Get all Reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get Review by Id
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    // Create Content
    public Review createReview(Review review) {
        return reviewRepository.save(review);
    }
}
