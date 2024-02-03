package com.blankjee.service;

import com.blankjee.model.User;


public interface UserService {

    User checkUser(String username, String password);
}
