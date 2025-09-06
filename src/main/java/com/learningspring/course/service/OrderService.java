package com.learningspring.course.service;

import com.learningspring.course.entities.Order;
import com.learningspring.course.repositories.OrderRepositories;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService
{
    OrderRepositories orderRepositories;
    
    public OrderService( OrderRepositories orderRepositories )
    {
        this.orderRepositories = orderRepositories;
    }
    
    public List<Order> findAll()
    {
        return orderRepositories.findAll();
    }
    
    public Order findById( long id )
    {
        Optional<Order> order = orderRepositories.findById( id );
        
        return order.get();
    }
}
