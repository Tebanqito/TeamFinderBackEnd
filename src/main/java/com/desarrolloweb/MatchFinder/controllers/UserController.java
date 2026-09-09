package com.desarrolloweb.matchfinder.controllers;

import com.desarrolloweb.matchfinder.dtos.UserDTO;
import com.desarrolloweb.matchfinder.entities.MatchFinderUser;
import com.desarrolloweb.matchfinder.repositories.UserRepository;
import com.desarrolloweb.matchfinder.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserRepository userRepository;
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getAllUser());
    }

    @GetMapping("/get/users/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> createUser(@RequestBody MatchFinderUser user){
        UserDTO userCreated = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
    }

    @PatchMapping("update/user/{id}")
    public ResponseEntity<?> updateUser(@RequestBody MatchFinderUser matchFinderUser) {
        UserDTO userDTO = userService.updateUser(matchFinderUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

}
