package com.desarrolloweb.matchfinder.repositories;

import com.desarrolloweb.matchfinder.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
