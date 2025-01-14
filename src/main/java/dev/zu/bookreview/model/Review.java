package dev.zu.bookreview.model;

import jakarta.persistence.*;
import dev.zu.bookreview.model.Book;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @ManyToOne  // Each review is associated with one book
    @JoinColumn(name = "book_id")  // This creates a foreign key in the review table to reference the book
    private Book book;

    @Column(name = "reviewer")
    private String reviewer;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "content")
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