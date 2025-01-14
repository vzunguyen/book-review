package dev.zu.bookreview.repository;

import dev.zu.bookreview.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b FROM Book b WHERE b.title = :title")
    Book findByTitle(String title);
}

