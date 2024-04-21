package com.example.anti_fraud.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.anti_fraud.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Your Name
 * @since 2024-04-20
 */
public interface IUserService extends IService<User> {
    Page<User> findPaginated(int page, int size);
}
