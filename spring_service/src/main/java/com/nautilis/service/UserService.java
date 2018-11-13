package com.nautilis.service;

import com.nautilis.pojo.User;

import java.util.List;

/**
 * @author: zpf
 **/
public interface UserService {

    int addUser(User user);

    List<User> findAllUser();
}
