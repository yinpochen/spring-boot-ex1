package cn.ishutter.demo;


import cn.ishutter.demo.entity.AdminUser;
import cn.ishutter.demo.repository.AdminUserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MongoTest {
    @Autowired
    AdminUserRepository adminUserRepository;

    @Before
    public void initData(){
        AdminUser user = new AdminUser(2,"brucechan","123456","chan","chen@163.com");
        adminUserRepository.save(user);
    }
    @Test
    public void testMongo(){
        AdminUser user = adminUserRepository.findByUserName("bruce");
        Assert.assertEquals("chan",user.getName());
    }

}
