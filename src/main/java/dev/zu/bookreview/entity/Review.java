package dev.zu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import Book;

public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "book_id")  // Foreign key column in the Review table
    private Book book;

    private String reviewer;
    private Integer rating;
    private String content;

    // Getters and Setters

    // Id
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Book
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }

    // Reviewer
    public String getReviewer() {
        return reviewer;
    }
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    // Rating
    public Integer getRating() {
        return rating;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    // Content
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}