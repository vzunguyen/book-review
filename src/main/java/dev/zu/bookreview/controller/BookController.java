package dev.zu.bookreview.controller;

import dev.zu.bookreview.model.Book;
import dev.zu.bookreview.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/id/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/{title}")
    public Book getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @PostMapping
    public Book saveBook(String title, String author, String genre) {
        return bookService.saveBook(title, author, genre);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable  Long id) {
        if (bookService.getBookById(id).equals(false)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Book wasn't able to be deletes.");
        }
        bookService.deleteBook(id);
        // Return message "Book deleted successfully"
        return ResponseEntity.ok("Book deleted successfully");
    }
}
