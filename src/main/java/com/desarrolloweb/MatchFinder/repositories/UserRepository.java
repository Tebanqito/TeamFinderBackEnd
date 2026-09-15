package com.desarrolloweb.matchfinder.repositories;

import com.desarrolloweb.matchfinder.dtos.UserDTO;
import com.desarrolloweb.matchfinder.entities.MatchFinderUser;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<MatchFinderUser, Integer> {

    @Query(value = "SELECT * FROM match_finder_user WHERE user_email LIKE :email", nativeQuery = true)
    List<User> getUserByEmail(@Param("email") String email);

}
