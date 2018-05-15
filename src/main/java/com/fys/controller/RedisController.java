package com.fys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/testRedis")
    public String testRedis() {
        /*stringRedisTemplate.opsForValue().set("fys", "111");*/
        //  Hash数据类型操作
        /*HashOperations<String, Object, Object> hashOperations = stringRedisTemplate.opsForHash();
        hashOperations.put("fys", "fyskey", "fysvalue");
        System.out.println(hashOperations.get("fys", "fyskey"));*/

        // list 数据类型
        /*ListOperations<String, String> stringStringListOperations = stringRedisTemplate.opsForList();
        stringStringListOperations.leftPush("fyslist", "leftvalule");
        System.out.println(stringStringListOperations.range("fyslist", 0, -1));*/

        // zset 数据类型
        ZSetOperations<String, String> zSetOperation = stringRedisTemplate.opsForZSet();
        zSetOperation.add("fyszset2", "heihei1", 1);
        zSetOperation.add("fyszset2", "heihei2", 1);
        zSetOperation.add("fyszset2", "heihei3", 1);
        zSetOperation.add("fyszset2", "heihei4", 1);
        zSetOperation.add("fyszset2", "heihei5", 2);
        System.out.println(zSetOperation.count("fyszset2", 2, 2));
        System.out.println(zSetOperation.rangeByScore("fyszset2", 2, 2));
        return "";
    }
}
