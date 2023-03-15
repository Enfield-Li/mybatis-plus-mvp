package com.example.demo.service;

import com.example.demo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;


    @Test
    void testGetCount() {
//        for (int i = 0; i < 10; i++) {
//            User user = User.builder().name("user  " + i).age(10 + i).build();
//            userService.save(user);
//        }

        long count = userService.count();
        System.out.println(count);
    }

    @Test
    void testBatchInsert() {
        List<User> userList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = User.builder().name("new user  " + i).age(10 + i).build();
            userList.add(user);
        }
        System.out.println(userList.size());

        boolean saved = userService.saveBatch(userList);
        System.out.println(saved);
        System.out.println(userList);

    }

    @Test
    void testTableLogic() {
        boolean removed = userService.removeById(1635974306502017033L);
        System.out.println(removed);
    }

    @Test
    void testTableLogicSelect() {
        List<User> userList = userService.list();
        System.out.println(userList);
    }
}