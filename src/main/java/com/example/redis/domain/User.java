package com.example.redis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhuzhe
 * @date 2018/5/20 17:13
 * @email 1529949535@qq.com
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -1L;

    private String username;
    private Integer age;

    public User(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
    public User() {}
}
