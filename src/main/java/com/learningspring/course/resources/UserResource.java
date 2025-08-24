package com.learningspring.course.resources;

import com.learningspring.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource
{
    @GetMapping
    public ResponseEntity<List<User>> findAll()
    {
        User user = new User(1L, "Leo", "leonardo@gmail.com", "51987654321", "teste123" );
        return ResponseEntity.ok().body( List.of( user ) );
    }
}
