package com.example.demo.user;

import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * <p>
 * UserMapperTest
 * </p>
 *
 * @author enfield
 * @since 2023-03-15
 */
@SpringBootTest
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @BeforeEach
    void init() {
    }

    @Test
    void testSelectList() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

}