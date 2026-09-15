package com.desarrolloweb.matchfinder.controllers;

import com.desarrolloweb.matchfinder.dtos.UserDTO;
import com.desarrolloweb.matchfinder.entities.MatchFinderUser;
import com.desarrolloweb.matchfinder.repositories.UserRepository;
import com.desarrolloweb.matchfinder.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> createUser(@RequestBody MatchFinderUser user) {

        // Mapa reutilizable para estructurar las respuestas JSON de error
        Map<String, String> errorResponse = new HashMap<>();

        try {
            // 1. Validación 400 - Formato de Correo
            if (user.getUserEmail() == null || !user.getUserEmail().contains("@")) {
                errorResponse.put("error", "400 - El campo 'user_Email' no tiene un formato válido");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
            }

            // 2. Validación 422 - Requisitos de Contraseña
            if (user.getUserPassword() == null || user.getUserPassword().length() < 8) {
                errorResponse.put("error", "422 - La contraseña debe tener al menos 8 caracteres");
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponse);
            }

            if (!userService.isUserEmail(user.getUserEmail())) {
                errorResponse.put("error", "409 - El correo electrónico ya está registrado");
                return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
            }

            userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito");

        } catch (Exception e) {
            errorResponse.put("error", "500 - Error interno del servidor");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
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
