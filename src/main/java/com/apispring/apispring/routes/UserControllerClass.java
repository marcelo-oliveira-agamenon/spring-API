package com.apispring.apispring.routes;

import com.apispring.apispring.models.User;
import com.apispring.apispring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class UserControllerClass {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public User saveUser(User user) {
        return userService.save(user);
    }
}
