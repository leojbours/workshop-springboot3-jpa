package com.learningspring.course.repositories;

import com.learningspring.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositories extends JpaRepository<User, Long>
{

}
