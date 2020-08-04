package com.apispring.apispring.routes;

import com.apispring.apispring.models.User;
import com.apispring.apispring.service.ResponseWithJson;
import com.apispring.apispring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api")
public class UserControllerClass {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public ResponseWithJson saveUser(@RequestBody User user) {
        User userResp = userService.save(user);
        return new ResponseWithJson("User created", userResp);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable("id")UUID id) {
        return userService.findByUserId(id);
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable("id")UUID id) {
        return userService.delete(id);
    }
}
