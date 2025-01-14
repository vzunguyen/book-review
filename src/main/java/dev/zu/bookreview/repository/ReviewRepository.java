package dev.zu.bookreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.zu.bookreview.model.Review;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("SELECT review FROM Review review WHERE review.book.id = :bookId")
    List<Review> findByBookId(Long bookId);
}