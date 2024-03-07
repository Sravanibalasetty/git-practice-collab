package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public Iterable<User> list(){
        return userRepository.findAll();
    }
    public User save(User user){
        return userRepository.save(user);
    }
    public Iterable<User> save(List<User> users){
        return userRepository.saveAll(users);
    }
    public List<User> findAllOrderByNameAsc() {


        var sort = Sort.by(Sort.Direction.ASC, "name");
        return userRepository.findAllOrderByNameAsc(sort);
    }

    public List<User> findAllOrderByNameDesc() {


        var sort = Sort.by(Sort.Direction.DESC, "name");
        return userRepository.findAllOrderByNameAsc(sort);
    }
    public Optional<User> findById(long id){
        return userRepository.findById(id);
    }
}

