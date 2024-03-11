package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
@RestController
@RequestMapping("/users")
public class UserController {
    String field ="";
    @Autowired
    private UserService userService;
    @GetMapping("/list")
    public Iterable<User> list() {
        return userService.list();
    }

    @GetMapping(value = "/field")
    public List<User> getUserByNameasc(@RequestParam(required = false) String field) {

        List<User> allOrderByNameAsc = userService.findAllOrderByNameAsc(field); return allOrderByNameAsc;
    }

    /*@GetMapping(value = "/bydesc")
    public List<User> getUserByNamedesc() {
        return userService.findAllOrderByNameDesc(field);
    }*/

    @GetMapping("/id")
    public ResponseEntity<Optional<User>> getUserById(@RequestParam(required = false, defaultValue = "1") long id) {
        Optional<User> use = userService.findById(id);
        return ResponseEntity.ok(use);
    }

    @PostMapping("/test")
    public ResponseEntity<User> postUser(@RequestBody User user) {
        return ResponseEntity.ok(user);
    }
@GetMapping("/pagination")
    public ResponseEntity<Page<User>> page(@RequestParam(required = false, defaultValue = "0") Integer offset,@RequestParam(required = false, defaultValue = "5") Integer pageSize){
     Page<User> WithPagination=userService.Pagination(offset, pageSize);
     return ResponseEntity.ok(WithPagination);
}

}




