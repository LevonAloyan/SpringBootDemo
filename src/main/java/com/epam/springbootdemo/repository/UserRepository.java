package com.epam.springbootdemo.repository;

import com.epam.springbootdemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByEmailAndPassword(String email, String password);
}
