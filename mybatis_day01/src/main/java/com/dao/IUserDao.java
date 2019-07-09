package com.dao;

import com.domain.User;
import com.mybaitis.annotations.Select;

import java.util.List;

/**
 * 用户持久层接口
 */
public interface IUserDao {
    /**
     * 查询所有操作
     */
    //基于XML的查询所有操作
    //List<User> findAll();
    //基于注解配置的查询所有操作
    @Select("select * from user")
    List<User> findAll();
}
