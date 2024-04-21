package com.example.anti_fraud.controller;

import com.example.anti_fraud.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private IPostService postService;

    // 获取所有帖子
    @GetMapping
    public ResponseEntity<List<com.example.anti_fraud.entity.Post>> getAllPosts() {
        List<com.example.anti_fraud.entity.Post> posts = postService.list();
        return ResponseEntity.ok(posts);
    }

    // 根据ID获取单个帖子
    @GetMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Post> getPostById(@PathVariable Long id) {
        com.example.anti_fraud.entity.Post post = postService.getById(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    // 创建新帖子
    @PostMapping
    public ResponseEntity<com.example.anti_fraud.entity.Post> createPost(@RequestBody com.example.anti_fraud.entity.Post post) {
        boolean saved = postService.save(post);
        return saved ? ResponseEntity.status(HttpStatus.CREATED).body(post) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    // 更新帖子
    @PutMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Post> updatePost(@PathVariable Long id, @RequestBody com.example.anti_fraud.entity.Post post) {
        post.setId(Math.toIntExact(id)); // 确保ID一致
        boolean updated = postService.updateById(post);
        return updated ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    // 删除帖子
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        boolean isDeleted = postService.removeById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
