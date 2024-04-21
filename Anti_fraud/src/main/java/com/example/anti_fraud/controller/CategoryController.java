package com.example.anti_fraud.controller;

import com.example.anti_fraud.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<com.example.anti_fraud.entity.Category>> getAllCategories() {
        List<com.example.anti_fraud.entity.Category> categories = categoryService.list();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Category> getCategoryById(@PathVariable Long id) {
        com.example.anti_fraud.entity.Category category = categoryService.getById(id);
        return category != null ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<com.example.anti_fraud.entity.Category> createCategory(@RequestBody com.example.anti_fraud.entity.Category category) {
        boolean saved = categoryService.save(category);
        return saved ? ResponseEntity.status(HttpStatus.CREATED).body(category) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Category> updateCategory(@PathVariable Long id, @RequestBody com.example.anti_fraud.entity.Category category) {
        category.setId(Math.toIntExact(id));
        boolean updated = categoryService.updateById(category);
        return updated ? ResponseEntity.ok(category) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        boolean isDeleted = categoryService.removeById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
