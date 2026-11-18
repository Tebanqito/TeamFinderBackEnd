package com.desarrolloweb.matchfinder.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class UserDTO {
    @Getter
    @Setter
    private Integer idUser;
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String userEmail;

    public Integer getIdUser(){
        return this.idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
