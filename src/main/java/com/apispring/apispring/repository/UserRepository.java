package com.apispring.apispring.repository;

import com.apispring.apispring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(UUID id);
}
