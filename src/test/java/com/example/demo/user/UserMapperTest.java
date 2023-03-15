package com.example.demo.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
//        for (int i = 0; i < 5; i++) {
//            User user = User.builder().name("user" + " " + i).age(40 + i).build();
//            userMapper.insert(user);
//        }
//
    }

    @Test
    void testSelectList() {
        LambdaQueryWrapper<User> qw = new QueryWrapper<User>().lambda();
        qw.gt(User::getAge, 42);

        List<User> users = userMapper.selectList(qw);
        System.out.println(users);
    }

    @Test
    void testInsertAndGetId() {
        User user = User.builder().name("new User").age(49).build();
        int inserted = userMapper.insert(user);
        System.out.println(inserted);
        System.out.println(user);
    }

    @Test
    void testDeleteByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1635935875743621122L);
        userMapper.deleteByMap(map);

        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }

    @Test
    void testDeleteBatch() {
        userMapper.deleteBatchIds(
                Arrays.asList(1635930897130016769L, 1635930897859825666L));
    }

    @Test
    void testUpdate() {
        User user = User.builder().id(1635930897859825667L).name("user2 updated").build();

        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    void testSelect() {
        userMapper.selectById(1635930897859825667L);
    }
}