package dev.zu.bookreview.service;

import dev.zu.bookreview.model.Book;
import dev.zu.bookreview.model.Review;
import dev.zu.bookreview.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.zu.bookreview.repository.ReviewRepository;

import java.util.List;

// GET: Ask for information (like checking the menu)
// POST: Create something new (placing a new order)
// PUT/PATCH: Update something (modifying your order)
// DELETE: Remove something (canceling your order)

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    // Get all Reviews
    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    // Get Review by Id
    public Review getReviewById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    // Get Review by Book
    public List<Review> getReviewsByBook(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }

    // Add Review
    public Review addReview(String bookTitle, String reviewer, Integer rating, String content) {
        // Find the book the review is associated with
        Book book = bookRepository.findByTitle(bookTitle);
        if (book == null) {
            // Book not found, throw exception
            throw new IllegalArgumentException("Book not found");
            // IllegalArgumentException is typically used when a method is
            // passed an argument that is invalid or does not meet the method's requirements.
        }
        Review review = new Review();

        review.setBook(book);
        review.setReviewer(reviewer);
        review.setRating(rating);
        review.setContent(content);

        // Save the review to the database
        return reviewRepository.save(review);
    }

    // Delete Review
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }
}
