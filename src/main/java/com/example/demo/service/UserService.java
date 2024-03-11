package com.example.demo.service;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Iterable<User> list(){
        return userRepository.findAll();
    }
    /*public User save(User user){
        return userRepository.save(user);
    }*/
    public Iterable<User> save(List<User> users){
        return userRepository.saveAll(users);
    }
    public List<User> findAllOrderByNameAsc(String field) {


        var sort = Sort.by(Sort.Direction.DESC, field);
        return userRepository.findAll(sort);
    }

    /*public List<User> findAllOrderByNameDesc(String field) {


        var sort = Sort.by(Sort.Direction.DESC,field);
        return userRepository.findAll(sort);
    }*/
    public Optional<User> findById(long id){
        return userRepository.findById(id);
    }
   public Page<User> Pagination(int offset,int pagesize){
        return userRepository.findAll(PageRequest.of(offset,pagesize));
   }
}

