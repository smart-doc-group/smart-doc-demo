package com.smartdoc.example.repository;

import com.smartdoc.example.model.User;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author yu 2020/12/27.
 */
@Repository
public class UserRepository {

    private static final Map<Long, User> users = new ConcurrentHashMap<>();

    static {
        User user = new User();
        user.setId(1);
        user.setEmail("123@gmail.com");
        user.setFirstName("Tom");
        user.setLastName("King");
        users.put(1L,user);
    }

    public Optional<User> findById(long id) {
        return Optional.ofNullable(users.get(id));
    }

    public User add(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public List<User> getUsers() {
        return users.values().stream().collect(Collectors.toList());
    }

    public boolean delete(User user) {
        return users.remove(user.getId(),user);
    }

}
