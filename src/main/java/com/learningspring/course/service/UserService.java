package com.learningspring.course.service;

import com.learningspring.course.entities.User;
import com.learningspring.course.repositories.UserRepositories;
import com.learningspring.course.util.UserCache;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepositories userRepositories;
  private final UserCache userCache = UserCache.getInstance();

  @Autowired
  public UserService(UserRepositories userRepositories) {
    this.userRepositories = userRepositories;
  }

  public List<User> findAll() {
    return userRepositories.findAll();
  }

  public User findById(Long id) {
    Optional<User> cachedUser = userCache.getUser(id);

    if (cachedUser.isPresent()) {
      return cachedUser.get();
    }

    Optional<User> userFromDb = userRepositories.findById(id);
    userFromDb.ifPresent(value -> userCache.putUser(value.getId(), value));
    return userFromDb.get();
  }
}
