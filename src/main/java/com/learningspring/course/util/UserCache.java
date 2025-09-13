package com.learningspring.course.util;

import com.learningspring.course.entities.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserCache {
  private static UserCache instance;

  private final Map<Long, User> usersMap = new HashMap<>();

  public static UserCache getInstance() {
    if (instance != null) {
      return instance;
    }
    instance = new UserCache();
    return instance;
  }

  public Optional<User> getUser(Long id) {
    return Optional.ofNullable(usersMap.get(id));
  }

  public void putUser(long id, User user) {
    usersMap.put(id, user);
  }
}
