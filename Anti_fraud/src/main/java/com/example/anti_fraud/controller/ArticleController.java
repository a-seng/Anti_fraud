package com.example.anti_fraud.controller;

//import com.example.anti_fraud.Entity.Article;
import com.example.anti_fraud.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping
    public ResponseEntity<List<com.example.anti_fraud.entity.Article>> getAllArticles() {
        List<com.example.anti_fraud.entity.Article> articles = articleService.list();
        return ResponseEntity.ok(articles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Article> getArticleById(@PathVariable Long id) {
        com.example.anti_fraud.entity.Article article = articleService.getById(id);
        return article != null ? ResponseEntity.ok(article) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<com.example.anti_fraud.entity.Article> createArticle(@RequestBody com.example.anti_fraud.entity.Article article) {
        boolean saved = articleService.save(article);
        return saved ? ResponseEntity.status(HttpStatus.CREATED).body(article) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Article> updateArticle(@PathVariable Long id, @RequestBody com.example.anti_fraud.entity.Article article) {
        article.setId(Math.toIntExact(id));
        boolean updated = articleService.updateById(article);
        return updated ? ResponseEntity.ok(article) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        boolean isDeleted = articleService.removeById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
