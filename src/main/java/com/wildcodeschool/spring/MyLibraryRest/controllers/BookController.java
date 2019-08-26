package com.wildcodeschool.spring.MyLibraryRest.controllers;

import com.wildcodeschool.spring.MyLibraryRest.models.Book;
import com.wildcodeschool.spring.MyLibraryRest.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> index() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book show(@PathVariable Integer id) {
        return bookRepository.findById(id).get();
    }

    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body) {
        String searchTerm = body.get("text");
        return bookRepository.findByTitleContainingOrAuthorContainingOrDescriptionContaining(searchTerm, searchTerm, searchTerm);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book blog) {
        return bookRepository.save(blog);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable Integer id, @RequestBody Book book) {
        Book bookTemp = bookRepository.findById(id).get();
        bookTemp.setTitle(book.getTitle());
        bookTemp.setAuthor((book.getAuthor()));
        bookTemp.setDescription(book.getDescription());
        return bookRepository.save(bookTemp);
    }

    @DeleteMapping("books/{id}")
    public Boolean delete(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return true;
    }

}
