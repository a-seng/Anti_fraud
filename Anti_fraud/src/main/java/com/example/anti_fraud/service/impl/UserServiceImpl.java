package com.example.anti_fraud.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.anti_fraud.entity.User;
import com.example.anti_fraud.mapper.UserMapper;
import com.example.anti_fraud.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Your Name
 * @since 2024-04-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Page<User> findPaginated(int page, int size) {
        return this.page(new Page<>(page, size));
    }
}
