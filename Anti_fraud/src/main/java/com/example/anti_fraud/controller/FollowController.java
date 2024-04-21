package com.example.anti_fraud.controller;

import com.example.anti_fraud.service.IFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/follows")
public class FollowController {

    @Autowired
    private IFollowService followService;

    // 获取所有关注关系
    @GetMapping
    public ResponseEntity<List<com.example.anti_fraud.entity.Follow>> getAllFollows() {
        List<com.example.anti_fraud.entity.Follow> follows = followService.list();
        return ResponseEntity.ok(follows);
    }

    // 根据ID获取单个关注关系
    @GetMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Follow> getFollowById(@PathVariable Long id) {
        com.example.anti_fraud.entity.Follow follow = followService.getById(id);
        return follow != null ? ResponseEntity.ok(follow) : ResponseEntity.notFound().build();
    }

    // 创建新的关注关系
    @PostMapping
    public ResponseEntity<com.example.anti_fraud.entity.Follow> createFollow(@RequestBody com.example.anti_fraud.entity.Follow follow) {
        boolean saved = followService.save(follow);
        return saved ? ResponseEntity.status(HttpStatus.CREATED).body(follow) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    // 更新关注关系
    @PutMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Follow> updateFollow(@PathVariable Long id, @RequestBody com.example.anti_fraud.entity.Follow follow) {
        follow.setFollowerId(Math.toIntExact(id));
        boolean updated = followService.updateById(follow);
        return updated ? ResponseEntity.ok(follow) : ResponseEntity.notFound().build();
    }

    // 删除关注关系
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFollow(@PathVariable Long id) {
        boolean isDeleted = followService.removeById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
