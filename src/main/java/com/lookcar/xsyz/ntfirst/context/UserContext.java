package com.lookcar.xsyz.ntfirst.context;

import com.alibaba.druid.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserContext {

    private static final String USER_TOKEN_PREFIX = "user_token_";

    private static StringRedisTemplate stringRedisTemplate;

    public static void setToken(String token, String userName) {
        System.out.println("123");
        stringRedisTemplate.opsForValue().set(getTokenKey(token), userName, 30, TimeUnit.MINUTES);
    }

    public static String getUserName(String token) {
        return stringRedisTemplate.opsForValue().get(getTokenKey(token));
    }

    public static boolean isValid(String token) {
        if (StringUtils.isEmpty(token)) {
            return false;
        }
        return stringRedisTemplate.hasKey(getTokenKey(token));
    }

    public static void delay(String token) {
        stringRedisTemplate.expire(getTokenKey(token), 30, TimeUnit.MINUTES);
    }

    public static void deleteToken(String token) {
        stringRedisTemplate.delete(getTokenKey(token));
    }


    private static String getTokenKey(String token) {
        return USER_TOKEN_PREFIX + token;
    }

    @Autowired
    public void setStringRedisTemplate(StringRedisTemplate stringRedisTemplate) {
        UserContext.stringRedisTemplate = stringRedisTemplate;
    }

    public UserContext() {
        System.out.println("666666666666");
    }
}
