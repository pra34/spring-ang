/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.springang.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pramesh.springang.dao.UserDAO;
import com.pramesh.springang.model.User;

/**
 *
 * @author prames
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findById(Long id) {
        return userDAO.findOne(id);
    }

    @Override
    public User findByName(String username) {
        return userDAO.findOneByUsername(username);
    }

    @Override
    public List<User> findAllUser() {
        return userDAO.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User editUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userDAO.delete(id);
    }

    @Override
    public void deleteAllUser() {
        userDAO.deleteAll();
    }

    @Override
    public boolean isUserExist(User user) {
        return (userDAO.findOneByUsername(user.getUsername()) == null);
    }
    
}

