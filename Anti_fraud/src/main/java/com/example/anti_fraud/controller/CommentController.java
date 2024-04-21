package com.example.anti_fraud.controller;

import com.example.anti_fraud.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @GetMapping
    public ResponseEntity<List<com.example.anti_fraud.entity.Comment>> getAllComments() {
        List<com.example.anti_fraud.entity.Comment> comments = commentService.list();
        return ResponseEntity.ok(comments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Comment> getCommentById(@PathVariable Long id) {
        com.example.anti_fraud.entity.Comment comment = commentService.getById(id);
        return comment != null ? ResponseEntity.ok(comment) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<com.example.anti_fraud.entity.Comment> createComment(@RequestBody com.example.anti_fraud.entity.Comment comment) {
        boolean saved = commentService.save(comment);
        return saved ? ResponseEntity.status(HttpStatus.CREATED).body(comment) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Comment> updateComment(@PathVariable Long id, @RequestBody com.example.anti_fraud.entity.Comment comment) {
        comment.setId(Math.toIntExact(id));
        boolean updated = commentService.updateById(comment);
        return updated ? ResponseEntity.ok(comment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        boolean isDeleted = commentService.removeById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
