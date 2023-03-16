package com.example.demo.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    void testTableLogic() {
        int deleted = userMapper.deleteBatchIds(Arrays.asList(1635974306502017032L, 1635974306502017031L));
        System.out.println(deleted);
    }


    @Test
    void testPage() {
        Page<User> page = new Page<>(1, 3);
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println(userPage.getRecords());
        System.out.println(userPage.getSize());

    }

}