package com.example.redis.test;

import com.example.redis.common.RedisCacheObject;
import com.example.redis.domain.User;
import com.example.redis.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author zhuzhe
 * @date 2018/5/20 18:16
 * @email 1529949535@qq.com
 */
@RestController
public class ApplicationTests {

    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("/test")
    public String test() throws IOException {

        User user = new User("zzz",12);
        RedisCacheObject<User> r = new RedisCacheObject<User>(user);
        redisUtils.saveString("zhuzhe","zhuzhe123");

        redisUtils.saveBean("aaa",user);

        String zhuzhe = redisUtils.getString("zhuzhe");

        User aaa = redisUtils.getBean("aaa", User.class);

        System.out.println(aaa);

        return zhuzhe;
    }
}
