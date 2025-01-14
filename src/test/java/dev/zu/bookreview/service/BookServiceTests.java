package dev.zu.bookreview.service;

import dev.zu.bookreview.model.Book;
import dev.zu.bookreview.repository.BookRepository;
import dev.zu.bookreview.repository.ReviewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookServiceTests {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private BookService bookService;

    private Book book;

    @BeforeEach
    public void setup() {
        book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setGenre("Test Genre");
    }


    @Test
    public void BookService_getBookById_ReturnsBook() {
        when(bookRepository.findById(book.getId())).thenReturn(Optional.of(book)); // Setting up Mock behaviour

        // Act
        Book retrievedBook = bookService.getBookById(book.getId());

        // Assert
        assert retrievedBook != null;
        assert retrievedBook.getId().equals(book.getId());
    }

    @Test
    public void BookService_getBookById_ReturnsNull() {
        when(bookRepository.findById(2L)).thenReturn(Optional.empty()); // Setting up Mock behaviour
        // Act
        Book retrievedBook = bookService.getBookById(2L);

        // Assert
        assert retrievedBook == null;
    }


}
