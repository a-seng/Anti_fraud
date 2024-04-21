package com.example.anti_fraud.util;

import lombok.Data;

/**
 * 用于封装后端返回的数据格式，包括状态码、消息、总条目数和数据内容。
 * @param <T> 数据的类型
 */
@Data
public class Result<T> {
    private int code; // 状态码，例如200表示成功，其他表示错误
    private String msg; // 返回的消息，通常用于错误信息或确认信息
    private long total; // 返回数据的总条目数，适用于分页
    private T data; // 返回的具体数据

    // 快速创建成功结果的方法
    public static <T> Result<T> success(String msg, long total, T data) {
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setMsg(msg);
        result.setTotal(total);
        result.setData(data);
        return result;
    }

    // 快速创建失败结果的方法
    public static <T> Result<T> error(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
