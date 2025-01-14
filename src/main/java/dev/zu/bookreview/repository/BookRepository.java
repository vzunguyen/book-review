package dev.zu.bookreview.repository;

import dev.zu.bookreview.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT book FROM Book book WHERE book.title = :title")
    Book findByTitle(String title);
}

