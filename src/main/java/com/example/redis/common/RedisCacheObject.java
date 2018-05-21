package com.example.redis.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhuzhe
 * @date 2018/5/20 16:03
 * @email 1529949535@qq.com
 */
@Data
public class RedisCacheObject<T> implements Serializable {

    private static final long serialVersionUID = -1L;

    private T t;

    public RedisCacheObject(T t) {
        this.t = t;
    }
    public RedisCacheObject() {
    }
}
