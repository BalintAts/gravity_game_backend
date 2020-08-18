package com.gravGam.gravityGame.repository;
import com.gravGam.gravityGame.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
