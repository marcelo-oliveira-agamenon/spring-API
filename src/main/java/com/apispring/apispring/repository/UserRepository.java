package com.apispring.apispring.repository;

import com.apispring.apispring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT * FROM users WHERE users.userId = ?1")
    User findById(UUID id);
}
