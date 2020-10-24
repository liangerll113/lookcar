package com.lookcar.xsyz.ntfirst.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

    @RequestMapping(value = "/getFromRedis", method = RequestMethod.GET)
    public String getFromRedis() {
        return stringRedisTemplate.opsForValue().get("name");
    }

    @RequestMapping("/getRedisByKey")
    public String getRedisByKey(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

    @RequestMapping("/setRedis")
    public String setRedis(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return "success";
    }

}
