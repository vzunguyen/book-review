package dev.zu.bookreview.service;

import dev.zu.bookreview.model.Book;
import dev.zu.bookreview.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // GET all Books
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    // CrudRepository findAll() returns Iterable<T>
    // JpaRepository findAll() returns List<T>

    // GET Book by Id
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Get Book by Title
    public Book getBookByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    // Save Book
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    // Delete Book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}