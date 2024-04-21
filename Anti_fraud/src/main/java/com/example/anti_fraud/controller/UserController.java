package com.example.anti_fraud.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.anti_fraud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Your Name
 * @since 2024-04-20
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    // 获取所有用户
    @GetMapping
    public ResponseEntity<List<com.example.anti_fraud.entity.User>> getAllUsers() {
        List<com.example.anti_fraud.entity.User> users = userService.list();
        return ResponseEntity.ok(users);
    }

    // 根据ID获取单个用户
    @GetMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.User> getUserById(@PathVariable Long id) {
        com.example.anti_fraud.entity.User user = userService.getById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // 创建新用户
    @PostMapping
    public ResponseEntity<com.example.anti_fraud.entity.User> createUser(@RequestBody com.example.anti_fraud.entity.User user) {
        boolean saved = userService.save(user);
        return saved ? ResponseEntity.status(HttpStatus.CREATED).body(user) : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    // 更新用户
    @PutMapping("/{id}")
    public ResponseEntity<com.example.anti_fraud.entity.User> updateUser(@PathVariable Long id, @RequestBody com.example.anti_fraud.entity.User user) {
        user.setId(Math.toIntExact(id));
        boolean updated = userService.updateById(user);
        return updated ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    // 删除用户
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        boolean isDeleted = userService.removeById(id);
        return isDeleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @GetMapping("/paginate")
    public Page<com.example.anti_fraud.entity.User> getPaginatedUsers(@RequestParam(value = "page", defaultValue = "1") int page,
                                                                      @RequestParam(value = "size", defaultValue = "10") int size) {
        return userService.findPaginated(page, size);
    }


}

