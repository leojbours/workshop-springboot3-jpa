package com.learningspring.course.service;

import com.learningspring.course.entities.User;
import com.learningspring.course.repositories.UserRepositories;
import com.learningspring.course.util.UserCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    private final UserRepositories USER_REPOSITORIES;
    private final UserCache USER_CACHE = UserCache.getInstance();
    
    @Autowired
    public UserService( UserRepositories userRepositories )
    {
        this.USER_REPOSITORIES = userRepositories;
    }
    
    public List<User> findAll()
    {
        return USER_REPOSITORIES.findAll();
    }
    
    public User findById( long id )
    {
        Optional<User> user = USER_CACHE.getUser( id );
        
        if ( user.isPresent() )
        {
            return user.get();
        }
        
        user = USER_REPOSITORIES.findById( id );
        
        user.ifPresent( value -> USER_CACHE.putUser( value.getId(), value ) );
        
        return user.get();
    }
}
