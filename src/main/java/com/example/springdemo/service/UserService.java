package com.example.springdemo.service;

import com.example.springdemo.ectity.User;
import com.example.springdemo.util.PageUtil;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserService {
    public Page<User> findAllUser(PageUtil pageUtil);
    int deleteUser(String id);
    int insertUser(User user);
    User findUserById(String id);
    int updateUser(User user);
}
