package com.learningspring.course.config;

import com.learningspring.course.entities.Order;
import com.learningspring.course.entities.OrderStatus;
import com.learningspring.course.entities.User;
import com.learningspring.course.repositories.OrderRepositories;
import com.learningspring.course.repositories.UserRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile( "test" )
public class TestConfig implements CommandLineRunner
{
    final UserRepositories userRepositories;
    final OrderRepositories orderRepositories;
    
    public TestConfig( UserRepositories userRepositories, OrderRepositories orderRepositories )
    {
        this.userRepositories = userRepositories;
        this.orderRepositories = orderRepositories;
    }
    
    @Override
    public void run( String... args ) throws Exception
    {
        User user = new User(null, "Leo", "leonardo@gmail.com", "51987654321", "teste123" );
        User user2 = new User(null, "Pedro Pedroso", "pedropedroso@pedros.com", "51987654321", "pedroPedroso@123" );
        
        userRepositories.saveAll( List.of( user, user2 ) );
        
        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), user, OrderStatus.PAID );
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), user2, OrderStatus.WAITING_PAYMENT );
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), user, OrderStatus.SHIPPED );
        
        orderRepositories.saveAll( List.of( o1, o2, o3 ) );
    }
}
