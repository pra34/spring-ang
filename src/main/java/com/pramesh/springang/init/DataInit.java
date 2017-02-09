/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.springang.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.pramesh.springang.service.UserService;
import com.pramesh.springang.model.User;

/**
 *
 * @author prames
 */
@Component
public class DataInit {
    
    @Autowired
    UserService userService;
    
    public DataInit() {
    }
    
    public void init() {
        userService.saveUser(new User("Tim", "Florida", "tim@florida.com"));
        userService.saveUser(new User("Jack", "Oakland", "jack@oakland.com"));
        userService.saveUser(new User("Ben", "El cesa", "ben@elcesa.com"));
    }
}
