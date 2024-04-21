package com.example.anti_fraud.controller;

import com.example.anti_fraud.service.IMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private IMediaService mediaService;

    @GetMapping
    public ResponseEntity<List<com.example.anti_fraud.entity.Media>> getAllMedia() {
        List<com.example.anti_fraud.entity.Media> media = mediaService.list();
        return ResponseEntity.ok(media);
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Media> getMediaById(@PathVariable Long id) {
        com.example.anti_fraud.entity.Media media = mediaService.getById(id);
        return media != null ? ResponseEntity.ok(media) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<com.example.anti_fraud.entity.Media> createMedia(@RequestBody com.example.anti_fraud.entity.Media media) {
        boolean saved = mediaService.save(media);
        return saved ? ResponseEntity.status(HttpStatus.CREATED).body(media) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.Media> updateMedia(@PathVariable Long id, @RequestBody com.example.anti_fraud.entity.Media media) {
        media.setId(Math.toIntExact(id));
        boolean updated = mediaService.updateById(media);
        return updated ? ResponseEntity.ok(media) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
        boolean isDeleted = mediaService.removeById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
