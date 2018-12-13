package com.didispace;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.util.List;

public class JedisTest {

    public static void main(String[] args) {

//        Jedis ss = new Jedis("127.0.0.1", 8080);
//        ss.set("hello", "redis");
//        System.out.println(ss.get("hello"));

        Jedis jedis = new Jedis("127.0.0.1", 8080);
        Pipeline pipeline = jedis.pipelined();
        pipeline.set("hello", "redis");
        pipeline.incr("counter");
        List<Object> listResult = pipeline.syncAndReturnAll();
        for (Object o: listResult) {
            System.out.println(o);
        }
    }
}
