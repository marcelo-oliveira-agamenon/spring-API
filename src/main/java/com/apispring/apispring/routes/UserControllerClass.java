package com.apispring.apispring.routes;

import com.apispring.apispring.models.User;
import com.apispring.apispring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/api")
public class UserControllerClass {
    @Autowired
    UserService userService;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> userList = userService.findAll();
        if(userList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id")UUID id) {
        Optional<User> resp = Optional.ofNullable(userService.findByUserId(id));
        if(resp.isPresent()) {
            return new ResponseEntity<User>(resp.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Optional<User> resp = Optional.ofNullable(userService.save(user));
        if(resp.isPresent()) {
            return new ResponseEntity<String>("User created", HttpStatus.OK);
        } else {
            return  new ResponseEntity<String>("This user doesn't exists",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("id")UUID id) {
        Optional<User> resp = Optional.ofNullable(userService.delete(id));
        if (resp.isPresent()) {
            return new ResponseEntity<String>("User deleted",HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("User Not found",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> update(@PathVariable("id")UUID id, @RequestBody User user) {
        Optional<User> resp = Optional.ofNullable(userService.findByUserId(id));
        if (resp.isPresent()){
            user.setUserId(resp.get().getUserId());
            user.setCreatedAt(resp.get().getCreatedAt());
            user.setModifiedAt(new Date());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.save(user);
            return new ResponseEntity<String>("User Updated",HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("This user doesn't exist",HttpStatus.NOT_FOUND);
        }
    }
}
