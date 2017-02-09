/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.springang.service;

import java.util.List;
import com.pramesh.springang.model.User;

/**
 *
 * @author prames
 */
public interface UserService {

    User findById(Long id);

    User findByName(String username);

    List<User> findAllUser();

    User saveUser(User user);

    User editUser(User user);

    void deleteUserById(Long id);

    void deleteAllUser();
    
    boolean isUserExist(User user);
}