package com.apispring.apispring.resources;

import com.apispring.apispring.models.User;
import com.apispring.apispring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> userList() {
        return userRepository.findAll();
    }
}
