package dev.zu.bookreview.controller;

import dev.zu.bookreview.model.Review;
import dev.zu.bookreview.service.BookService;
import dev.zu.bookreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;;
    }

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable Long id) {
        if (reviewService.getReviewById(id).equals(null)) {
            // Throw Exception
            throw new IllegalArgumentException("Review not found");
        }
        return reviewService.getReviewById(id);
    }

    @GetMapping("/book/{bookId}")
    public List<Review> getReviewsByBook(@PathVariable Long bookId) {
        return reviewService.getReviewsByBook(bookId);
    }

    @PostMapping
    public Review addReview(String bookTitle, String reviewer, Integer rating, String content) {
        return reviewService.addReview(bookTitle, reviewer, rating, content);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReviewById(@PathVariable Long id) {
        reviewService.deleteReviewById(id);
    }
}
