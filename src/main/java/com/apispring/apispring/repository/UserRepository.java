package com.apispring.apispring.repository;

import com.apispring.apispring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    /*@Query("SELECT * FROM users u WHERE u.userId = ?1")
    User findByUUIDIs(UUID id);*/
    @Modifying
    @Query("DELETE FROM users u WHERE u.userId = :userId")
    User deleteUser (UUID id);
}
