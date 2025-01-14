package dev.zu.bookreview.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

// Annotations in Java are a form of metadata that provide additional information about the program,
// but they do not affect the actual execution of the code. They are used to instruct the compiler,
// provide information to frameworks, or indicate runtime behavior.

@Entity
@Table(name = "book")
public class Book {
    @Id
    // UUID.randomUUID().toString()
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "genre")
    private String genre;

    @OneToMany(mappedBy = "book")  // "book" is the field in the Review class
    private List<Review> reviews;  // List of reviews


    // Getters and Setters

    // ID
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    // Title
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    // Author
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    // Genre
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }

    // Review
    @JsonIgnore
    public List<Review> getReviews() {
        return reviews;
    }
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}