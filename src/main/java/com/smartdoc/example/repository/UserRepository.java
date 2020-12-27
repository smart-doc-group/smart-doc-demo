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

    private Map<Long, User> books = new ConcurrentHashMap<>();

    public Optional<User> findById(long id) {
        return Optional.ofNullable(books.get(id));
    }

    public void add(User book) {
        books.put(book.getId(), book);
    }

    public List<User> getUsers() {
        return books.values().stream().collect(Collectors.toList());
    }

    public boolean delete(User user) {
        return books.remove(user.getId(),user);
    }

}
