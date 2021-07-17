package com.test;

import com.Application;
import com.dao.UserDao;
import com.entity.User;
import com.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Test
    public void test() throws Exception {
    /*    userDao.save(new User("AAA", "10"));
        userDao.save(new User("BBB", "20"));
        userDao.save(new User("CCC", "30"));*/
        //userService.create("aa","111");
        //Assert.assertEquals(3, userDao.findAll().size());
        // 插入5个用户
      /*  userService.create("a", "111");
        userService.create("b", "222");
        userService.create("c", "333");
        userService.create("d", "444");
        userService.create("e", "555");*/

        // 查数据库，应该有5个用户
        //Assert.assertEquals(5, userService.getAllUsers().intValue());

        // 删除两个用户
        //userService.deleteByName("a");
        //userService.deleteByName("e");


        // 查数据库，应该有5个用户
        //Assert.assertEquals(3, userService.getAllUsers().intValue());

        //userService.createName("aa");
    }

}


