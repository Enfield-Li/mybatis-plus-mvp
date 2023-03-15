package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * UserMapper
 * </p>
 *
 * @author enfield
 * @since 2023-03-15
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
}
