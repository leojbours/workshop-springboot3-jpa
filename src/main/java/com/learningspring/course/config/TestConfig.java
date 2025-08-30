package com.learningspring.course.config;

import com.learningspring.course.entities.User;
import com.learningspring.course.repositories.UserRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile( "test" )
public class TestConfig implements CommandLineRunner
{
    final UserRepositories userRepositories;
    
    public TestConfig( UserRepositories userRepositories )
    {
        this.userRepositories = userRepositories;
    }
    
    @Override
    public void run( String... args ) throws Exception
    {
        User user = new User(null, "Leo", "leonardo@gmail.com", "51987654321", "teste123" );
        User user2 = new User(null, "Pedro Pedroso", "pedropedroso@pedros.com", "51987654321", "pedroPedroso@123" );
        
        userRepositories.saveAll( List.of( user, user2 ) );
    }
}
