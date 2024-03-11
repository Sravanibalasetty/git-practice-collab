package com.example.demo.repository;
import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("FROM User")
    List<User> findAll(Sort sort);
}

