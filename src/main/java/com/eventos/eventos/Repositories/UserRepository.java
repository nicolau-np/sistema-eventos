package com.eventos.eventos.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.eventos.eventos.Models.User;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value = "select *from user where email=:email and password=:password", nativeQuery = true)
    public User Login(String email, String password);
}
