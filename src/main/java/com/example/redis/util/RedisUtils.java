package com.example.redis.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

/**
 * @author zhuzhe
 * @date 2018/5/20 16:22
 * @email 1529949535@qq.com
 */
@Component
public class RedisUtils {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * 保存字符串
     * @param key
     * @param value
     */
    public void saveString(String key,String value){
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 根据key获取字符串
     * @param key
     */
    public String getString(String key){
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 保存对象
     * @param key
     * @param obj
     * @throws JsonProcessingException
     */
    public void saveBean(String key,Object obj) throws JsonProcessingException {
        saveString(key,mapper.writeValueAsString(obj));
    }

    /**
     * 根据key获取对象
     * @param key
     * @return RedisCacheObject
     */
    public <T>T getBean(String key,Class<T> clazz) throws IOException {
        String value = getString(key);
        if (value == null) {
            return null;
        }
        return mapper.readValue(value, clazz);
    }

    /**
     * 从redis中删除
     * @param key
     */
    public void delete(String key){
        stringRedisTemplate.delete(key);
    }

    /**
     * 从redis中批量删除
     * @param keys
     */
    public void delete(Collection<String> keys){
        stringRedisTemplate.delete(keys);
    }
}
