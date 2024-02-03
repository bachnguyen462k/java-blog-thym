package com.blankjee.service.impl;

import com.blankjee.dao.UserRepository;
import com.blankjee.model.User;
import com.blankjee.service.UserService;
import com.blankjee.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
        return user;
    }
}
