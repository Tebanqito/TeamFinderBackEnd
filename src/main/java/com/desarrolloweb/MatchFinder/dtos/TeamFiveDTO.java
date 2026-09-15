package com.desarrolloweb.matchfinder.dtos;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TeamFiveDTO {
    @Getter
    @Setter
    private Integer id_Adm;
    @Getter
    @Setter
    private Integer id_Team;
    @Getter
    @Setter
    private Integer id_PlayerTwo;
    @Getter
    @Setter
    private Integer id_PlayerThree;
    @Getter
    @Setter
    private Integer id_PlayerFour;
    @Getter
    @Setter
    private Integer id_PlayerFive;
    @Getter
    @Setter
    private String team_Name;
    @Getter
    @Setter
    private String team_Description;

    public Integer getIdAdm(){
        return this.id_Adm;
    }

    public Integer getIdTeam(){
        return this.id_Team;
    }

    public Integer getIdPlayerTwo(){
        return this.id_PlayerTwo;
    }

    public Integer getIdPlayerThree(){
        return this.id_PlayerThree;
    }

    public Integer getIdPlayerFour(){
        return this.id_PlayerFour;
    }

    public Integer getIdPlayerFive(){
        return this.id_PlayerFive;
    }

    public void setId_Adm(Integer idAdm) {
        this.id_Adm = idAdm;
    }

    public void setId_Team(Integer idTeam) {
        this.id_Team = idTeam;
    }

    public void setId_PlayerTwo(Integer idPlayerTwo) {
        this.id_PlayerTwo = idPlayerTwo;
    }

    public void setId_PlayerThree(Integer idPlayerThree) {
        this.id_PlayerThree = idPlayerThree;
    }

    public void setId_PlayerFour(Integer idPlayerFour) {
        this.id_PlayerFour = idPlayerFour;
    }

    public void setId_PlayerFive(Integer idPlayerFive) {
        this.id_PlayerFive = idPlayerFive;
    }

    public String getTeam_Name() {
        return team_Name;
    }

    public void setTeam_Name(String TeamName) {
        this.team_Name = TeamName;
    }

    public String getTeam_Description() {
        return team_Description;
    }

    public void setTeam_Description(String TeamDescription) {
        this.team_Description = team_Description;
    }
}