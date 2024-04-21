package com.example.anti_fraud.dto;

import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.HashMap;
import java.util.Map;

@Data
public class QueryPageParam {
    private static int SIZE=20;
    private static int PAGE=1;
    private int page=PAGE;   // 页面编号，从1开始
    private int size=SIZE;   // 每页的项目数量
    @Nullable
    private String search; // 可选的搜索关键词
    private Map<String, Object> para = new HashMap<>(); // 用于存储额外的查询参数


    // 由于使用了@Data注解，所有getter、setter、toString等方法都将自动生成
}
