package com.learningspring.course.controllers;

import com.learningspring.course.entities.User;
import com.learningspring.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController
{
    UserService userService;
    
    @Autowired
    public UserController( UserService userService )
    {
        this.userService = userService;
    }
    
    @GetMapping
    public ResponseEntity<List<User>> findAll()
    {
        List<User> users = userService.findAll();
        
        return ResponseEntity.ok().body( users );
    }
    
    @GetMapping( value = "/{id}" )
    public ResponseEntity<User> findById( @PathVariable Long id )
    {
        return ResponseEntity.ok().body( userService.findById( id ) );
    }
}
