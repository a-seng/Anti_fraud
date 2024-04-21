package com.example.anti_fraud.controller;


import com.example.anti_fraud.service.IAlikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alikes")
public class AlikeController {

    @Autowired
    private IAlikeService alikeService;

    @GetMapping
    public ResponseEntity<List<com.example.anti_fraud.entity.Alike>> getAllAlikes() {
        List<com.example.anti_fraud.entity.Alike> alikes = alikeService.list();
        return ResponseEntity.ok(alikes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Alike> getAlikeById(@PathVariable Long id) {
        com.example.anti_fraud.entity.Alike alike = alikeService.getById(id);
        return alike != null ? ResponseEntity.ok(alike) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<com.example.anti_fraud.entity.Alike> createAlike(@RequestBody com.example.anti_fraud.entity.Alike alike) {
        boolean saved = alikeService.save(alike);
        return saved ? ResponseEntity.status(HttpStatus.CREATED).body(alike) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Alike> updateAlike(@PathVariable Long id, @RequestBody com.example.anti_fraud.entity.Alike alike) {
        alike.setId(Math.toIntExact(id));
        boolean updated = alikeService.updateById(alike);
        return updated ? ResponseEntity.ok(alike) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlike(@PathVariable Long id) {
        boolean isDeleted = alikeService.removeById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
