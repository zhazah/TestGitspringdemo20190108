package com.example.springdemo.dao;

import com.example.springdemo.ectity.User;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    Page<User> findAllUser();
    int deleteUser(String id);
    int insertUser(User user);
    User findUserById(String id);
    int updateUser(User user);
}
