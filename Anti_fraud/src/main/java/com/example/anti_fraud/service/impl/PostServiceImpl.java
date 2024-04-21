package com.example.anti_fraud.service.impl;

import com.example.anti_fraud.entity.Post;
import com.example.anti_fraud.mapper.PostMapper;
import com.example.anti_fraud.service.IPostService;
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
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

}
