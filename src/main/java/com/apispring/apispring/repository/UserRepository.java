package com.apispring.apispring.repository;

import com.apispring.apispring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
