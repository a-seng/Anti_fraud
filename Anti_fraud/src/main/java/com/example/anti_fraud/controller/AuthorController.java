package com.example.anti_fraud.controller;

import com.example.anti_fraud.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private IAuthorService authorService;

    @GetMapping
    public ResponseEntity<List<com.example.anti_fraud.entity.Author>> getAllAuthors() {
        List<com.example.anti_fraud.entity.Author> authors = authorService.list();
        return ResponseEntity.ok(authors);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Author> getAuthorById(@PathVariable Long id) {
        com.example.anti_fraud.entity.Author author = authorService.getById(id);
        return author != null ? ResponseEntity.ok(author) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<com.example.anti_fraud.entity.Author> createAuthor(@RequestBody com.example.anti_fraud.entity.Author author) {
        boolean saved = authorService.save(author);
        return saved ? ResponseEntity.status(HttpStatus.CREATED).body(author) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Author> updateAuthor(@PathVariable Long id, @RequestBody com.example.anti_fraud.entity.Author author) {
        author.setId(Math.toIntExact(id));
        boolean updated = authorService.updateById(author);
        return updated ? ResponseEntity.ok(author) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        boolean isDeleted = authorService.removeById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
