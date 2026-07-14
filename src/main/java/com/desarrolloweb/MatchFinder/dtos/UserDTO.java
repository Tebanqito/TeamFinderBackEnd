package com.desarrolloweb.matchfinder.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Integer idUser;
    private String userName;
    private String userEmail;
}
