package cn.ishutter.demo;


import cn.ishutter.demo.entity.User;
import cn.ishutter.demo.repository.UserRedis;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
    @Autowired
    UserRedis userRedis;


    @Before
    public void init(){
        User user = new User();
        user.setId(1);
        user.setName("bruce");
        user.setCreatedate(new Date());
        userRedis.add("1",2L,user);
    }

    @Test
    public void redisTest(){
        User user = userRedis.get("1");
        Assert.assertEquals("bruce",user.getName());
    }
}
