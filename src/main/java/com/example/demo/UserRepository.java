package com.example.demo;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Sort;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository

public interface UserRepository extends JpaRepository<User,Long>{
    @Query("FROM User")
    List<User> findAllOrderByNameAsc(Sort sort);
    @Query("FROM User")
    List<User> findAllOrderByNameDesc(Sort sort);


}

