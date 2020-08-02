package com.apispring.apispring.resources;

import com.apispring.apispring.models.User;
import com.apispring.apispring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class UserResource {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    public List<User> userList() {
        return userRepository.findAll();
    }

    /*@GetMapping("/users/{id}")
    public User userFindOne(@PathVariable(value = "id") UUID id) {
        return userRepository.findById(id);
    }
*/
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
