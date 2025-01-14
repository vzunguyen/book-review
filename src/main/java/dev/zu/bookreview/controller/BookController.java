package dev.zu.bookreview.controller;

import dev.zu.bookreview.model.Book;
import dev.zu.bookreview.service.BookService;
import dev.zu.bookreview.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
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
    public void deleteBook(@PathVariable  Long id) {
        bookService.deleteBook(id);
    }
}
