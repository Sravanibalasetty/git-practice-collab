package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public Iterable<User> list() {
        return userService.list();
    }

    @GetMapping(value = "/bynameasc")
    public List<User> getUserByNameasc() {
        return userService.findAllOrderByNameAsc();
    }

    @GetMapping(value = "/bynamedesc")
    public List<User> getUserByNamedesc() {


        return userService.findAllOrderByNameDesc();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable long id) {
        Optional<User> use = userService.findById(id);
        return ResponseEntity.ok(use);
    }

    @PostMapping("/test")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }


}




