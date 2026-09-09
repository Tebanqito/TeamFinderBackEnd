package com.desarrolloweb.matchfinder.repositories;

import com.desarrolloweb.matchfinder.entities.MatchFinderUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MatchFinderUser, Integer> {
}
