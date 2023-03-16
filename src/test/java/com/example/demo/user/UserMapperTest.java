package com.example.demo.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
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

    @Test
    void init() {
        User user = User.builder().name("test new deleuser").build();
        userMapper.insert(user);
//        for (int i = 0; i < 10; i++) {
//            User user = User.builder().name("final???new user" + " " + i).age(40 + i).build();
//            userMapper.insert(user);
//        }

    }

    @Test
    void testSelectList() {
        LambdaQueryWrapper<User> qw = new QueryWrapper<User>().lambda();
        qw.gt(User::getAge, 42);

        List<User> users = userMapper.selectList(null);
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
        map.put("id", 1636174074961223686L);
        userMapper.deleteByMap(map);

        List<User> users = userMapper.selectByMap(map);
        System.out.println(users);
    }


    @Test
    void testTableLogic() {
        int deleted = userMapper.deleteBatchIds(Arrays.asList(1635930897859825667L, 1636175441679372291L));
        System.out.println(deleted);
    }

    @Test
    void testPage() {
        Page<User> page = new Page<>(1, 3);
        Page<User> userPage = userMapper.selectPage(page, null);
        System.out.println(userPage.getRecords());
        System.out.println(userPage.getSize());
    }

    @Test
    void testPage2() {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new QueryWrapper<User>().lambda();
        lambdaQueryWrapper.like(User::getName, "user");

        Page<User> page = new Page<>(1, 2);

        Page<User> userPage = userMapper.selectPage(page, lambdaQueryWrapper);
        System.out.println(userPage.getRecords());
        System.out.println(userPage.hasNext());
        System.out.println(userPage.hasPrevious());
    }


}