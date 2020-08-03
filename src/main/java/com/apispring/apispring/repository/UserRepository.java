package com.apispring.apispring.repository;

import com.apispring.apispring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT * FROM users u WHERE u.userId = ?1")
    User findByUserId(UUID id);
}
