package com.lookcar.xsyz.ntfirst.controller;

import com.lookcar.xsyz.ntfirst.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private HelloService helloService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return helloService.getName();
    }

    @RequestMapping(value = "/getNameById", method = RequestMethod.GET)
    public String hello(int id) {
        return helloService.getNameById(id);
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
