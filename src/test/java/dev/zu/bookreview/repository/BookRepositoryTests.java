package dev.zu.bookreview.repository;

import dev.zu.bookreview.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTests {
    @Autowired
    private BookRepository bookRepository;

    @Test
    public void BookRepository_findBookByTitle_ReturnsCorrectBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setGenre("Test Genre");
        bookRepository.save(book);

        Book retrievedBook = bookRepository.findByTitle("Test Book");
        assert retrievedBook != null;
        assert retrievedBook.getTitle().equals("Test Book");
        assert retrievedBook.getAuthor().equals("Test Author");
        assert retrievedBook.getGenre().equals("Test Genre");
    }
}
