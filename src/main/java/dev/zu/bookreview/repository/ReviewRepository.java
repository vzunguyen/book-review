package dev.zu.bookreview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import dev.zu.bookreview.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}