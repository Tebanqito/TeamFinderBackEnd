package com.desarrolloweb.matchfinder.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class MatchFinderTeamFive {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id_Adm;
    private Integer id_Team;
    private Integer id_PlayerTwo;
    private Integer id_PlayerThree;
    private Integer id_PlayerFour;
    private Integer id_PlayerFive;
    private String team_Name;
    private String team_Description;

    public Integer getId_Adm() {
        return id_Adm;
    }

    public void setId_Adm(Integer idAdm) {
        this.id_Adm = idAdm;
    }

    public Integer getId_PlayerTwo() {
        return id_PlayerTwo;
    }

    public void setId_PlayerTwo(Integer idPlayerTwo) {
        this.id_PlayerTwo = idPlayerTwo;
    }

    public Integer getId_PlayerThree() {
        return id_PlayerThree;
    }

    public void setId_PlayerThree(Integer idPlayerThree) {
        this.id_PlayerThree = idPlayerThree;
    }

    public Integer getId_PlayerFour() {
        return id_PlayerFour;
    }

    public void setId_PlayerFour(Integer idPlayerFour) {
        this.id_PlayerFour = idPlayerFour;
    }

    public Integer getId_PlayerFive() {
        return id_PlayerFive;
    }

    public void setId_PlayerFive(Integer idPlayerFive) {
        this.id_PlayerFive = idPlayerFive;
    }

    public Integer getId_Team() {
        return id_Team;
    }

    public void setId_Team(Integer idTeam) {
        this.id_Team = idTeam;
    }

    public String getTeam_Name() {
        return team_Name;
    }

    public void setTeam_Name(String teamName) {
        this.team_Name = teamName;
    }

    public String getTeam_Description() {
        return team_Description;
    }

    public void setTeam_Description(String teamDescription) {
        this.team_Description = teamDescription;
    }
}
