package com.example.demo.user;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
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


    @Test
    void testTableLogic() {
        int deleted = userMapper.deleteBatchIds(Arrays.asList(1635974306502017032L, 1635974306502017031L));
        System.out.println(deleted);
    }


    @Test
    void testPage() {
        Page<User> page = new Page<>(1,3);
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println(userPage.getRecords());
        System.out.println(userPage.getSize());

    }


}