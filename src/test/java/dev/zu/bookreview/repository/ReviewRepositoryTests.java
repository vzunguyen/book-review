package dev.zu.bookreview.repository;

import dev.zu.bookreview.model.Book;
import dev.zu.bookreview.model.Review;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReviewRepositoryTests {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void ReviewRepository_findByBookId_ReturnsSingleReview() {
        // Arrange: Create and save a book
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Author A");
        book.setGenre("Genre X");
        book = bookRepository.save(book);

        // Arrange
        Review review = new Review();
        review.setBook(book);
        review.setContent("Great book!");
        review.setRating(5);
        reviewRepository.save(review);

        // Act
        List<Review> reviews = reviewRepository.findByBookId(book.getId());

        // Assert
        assert reviews != null;
        assert reviews.size() == 1;
        assert reviews.contains(review);
        assert reviews.get(0).getBook().getId().equals(book.getId());
    }
    @Test
    public void ReviewRepository_findByBookId_ReturnsMultipleReviews() {
        // Arrange: Create and save a book
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Author A");
        book.setGenre("Genre X");
        book = bookRepository.save(book);

        // Arrange
        Review review1 = new Review();
        review1.setBook(book);
        review1.setContent("Great book!");
        review1.setRating(5);
        reviewRepository.save(review1);

        Review review2 = new Review();
        review2.setBook(book);
        review2.setContent("Interesting read.");
        review2.setRating(4);
        reviewRepository.save(review2);

        Review review3 = new Review();
        review3.setBook(book);
        review3.setContent("Fun read.");
        review3.setRating(4);
        reviewRepository.save(review3);

        // Act
        List<Review> reviews = reviewRepository.findByBookId(book.getId());

        // Assert
        assert reviews != null;
        assert reviews.size() == 3;
        assert reviews.contains(review1);
        assert reviews.contains(review2);
        assert reviews.contains(review3);
    }

    @Test
    void findByBookId_shouldReturnEmptyListForNonExistentBook() {
        // Act: Try to fetch reviews for a non-existent book ID
        List<Review> reviews = reviewRepository.findByBookId(999L);

        // Assert: Verify the result is an empty list
        assert reviews.isEmpty();
    }
}
