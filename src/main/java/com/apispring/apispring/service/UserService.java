package com.apispring.apispring.service;

import com.apispring.apispring.models.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<User> findAll();
    User findByUserId(UUID id);
    User save(User user);
    User delete(UUID id);
}
