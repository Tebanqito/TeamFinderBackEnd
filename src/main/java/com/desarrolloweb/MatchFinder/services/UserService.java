package com.desarrolloweb.matchfinder.services;

import com.desarrolloweb.matchfinder.dtos.UserDTO;
import com.desarrolloweb.matchfinder.entities.MatchFinderUser;
import com.desarrolloweb.matchfinder.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<UserDTO> getAllUser(){
        List<UserDTO> userDTOS = new ArrayList<UserDTO>();


        for (MatchFinderUser user : userRepository.findAll()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserName(user.getUserName());
            userDTO.setUserEmail(user.getUserEmail());
            userDTO.setIdUser(user.getIdUser());

            userDTOS.add(userDTO);
        }

        return userDTOS;
    }

    @Transactional(readOnly = true)
    public UserDTO getUserById(Integer id) {
        UserDTO userDTO = new UserDTO();

        MatchFinderUser user = userRepository.getById(id);

        userDTO.setUserName(user.getUserName());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setIdUser(user.getIdUser());
        return  userDTO;
    }

    public static  UserDTO getUserToDTO(MatchFinderUser user){
        UserDTO userDTO = new UserDTO();

        userDTO.setUserName(user.getUserName());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setIdUser(user.getIdUser());

        return userDTO;
    }

    public UserDTO createUser(MatchFinderUser user) {
        userRepository.save(user);

        return getUserToDTO(user);
    }

    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    public UserDTO updateUser(MatchFinderUser user) {
        MatchFinderUser matchFinderUser = userRepository.findById(user.getIdUser()).orElseThrow(() -> new EntityNotFoundException("ToDo with ID: " + user.getIdUser() + " not found"));
        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserName(user.getUserName());

        return userDTO;
    }
}
