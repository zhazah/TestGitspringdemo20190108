package com.example.springdemo.service.Impl;
import com.example.springdemo.dao.UserDao;
import com.example.springdemo.ectity.User;
import com.example.springdemo.service.UserService;
import com.example.springdemo.util.PageUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public Page<User> findAllUser(PageUtil pageUtil) {
        PageHelper.startPage(pageUtil.getPageNum(), pageUtil.getPageSize());
        return userDao.findAllUser();
    }

    @Override
    public int deleteUser(String id) {
        return userDao.deleteUser(id);
    }

    @Override
    public int insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
}
