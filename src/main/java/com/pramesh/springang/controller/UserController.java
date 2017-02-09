/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pramesh.springang.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pramesh.springang.service.UserService;
import com.pramesh.springang.model.User;

/**
 *
 * @author prames
 */
@RestController
public class UserController {
    
    @Autowired
    private UserService userService;
 
    @RequestMapping(value = "/users",
            method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUser();
        System.out.println("users " + users.toString());
        if(users.isEmpty())
            return new ResponseEntity<List<User>> (HttpStatus.NO_CONTENT);
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/user/{id}", 
            method = RequestMethod.GET
    )
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        if(user == null)
                return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
     
    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {

            if (user == null) {
            	return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
            } else {
                User savedUser = userService.saveUser(user);
                
                if (savedUser.getId() == null)
                        return new ResponseEntity<User>(HttpStatus.EXPECTATION_FAILED);
                else
                    return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
            }
    }
    
    @RequestMapping(value = "/user/edit", method = RequestMethod.POST)
    public ResponseEntity<User> editUser(@RequestBody User user) {
        if(user == null) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        } else if(user.getId() == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }else {
            User fetchedUser = userService.findById(user.getId());
            
            fetchedUser.setUsername(user.getUsername());
            fetchedUser.setEmail(user.getEmail());
            fetchedUser.setAddress(user.getAddress());
            
            userService.editUser(fetchedUser);
            return new ResponseEntity<User>(fetchedUser, HttpStatus.OK);
        }
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value="/user/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {
        User fetchedUser;
        if(id == null) {
            return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        } else {
            fetchedUser = userService.findById(id);
            if (fetchedUser == null) {
                return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
            }
            
            userService.deleteUserById(id);
            return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
        }
    }
    
    @RequestMapping(method = RequestMethod.DELETE, value="/users")
    public ResponseEntity<User> deleteAllUser() {
        userService.deleteAllUser();
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    
}
