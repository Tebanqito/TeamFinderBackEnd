package com.desarrolloweb.matchfinder.services;

import com.desarrolloweb.matchfinder.dtos.TeamFiveDTO;
import com.desarrolloweb.matchfinder.entities.MatchFinderTeamFive;
import com.desarrolloweb.matchfinder.repositories.TeamFiveRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamFiveService {
    private final TeamFiveRepository TeamFiveRepository;

    public TeamFiveService(TeamFiveRepository TeamFiveRepository){
        this.TeamFiveRepository = TeamFiveRepository;
    }

    @Transactional(readOnly = true)
    public List<TeamFiveDTO> getAllTeams(){
        List<TeamFiveDTO> teamFiveDTOS = new ArrayList<>();


        for (MatchFinderTeamFive TeamFive : TeamFiveRepository.findAll()) {
            TeamFiveDTO teamFiveDTO = new TeamFiveDTO();
            teamFiveDTO.setTeam_Name(TeamFive.getTeam_Name());
            teamFiveDTO.setTeam_Description(TeamFive.getTeam_Description());
            teamFiveDTO.setId_Team(TeamFive.getId_Team());
            teamFiveDTO.setId_Adm(TeamFive.getId_Adm());
            teamFiveDTO.setId_PlayerTwo(TeamFive.getId_PlayerTwo());
            teamFiveDTO.setId_PlayerThree(TeamFive.getId_PlayerThree());
            teamFiveDTO.setId_PlayerFour(TeamFive.getId_PlayerFour());
            teamFiveDTO.setId_PlayerFive(TeamFive.getId_PlayerFive());

            teamFiveDTOS.add(teamFiveDTO);
        }

        return teamFiveDTOS;
    }

    @Transactional(readOnly = true)
    public TeamFiveDTO getTeamsById(Integer id) {
        TeamFiveDTO teamFiveDTO = new TeamFiveDTO();

        MatchFinderTeamFive TeamFive = TeamFiveRepository.getById(id);

        teamFiveDTO.setTeam_Name(TeamFive.getTeam_Name());
        teamFiveDTO.setTeam_Description(TeamFive.getTeam_Description());
        teamFiveDTO.setId_Team(TeamFive.getId_Team());
        teamFiveDTO.setId_Adm(TeamFive.getId_Adm());
        teamFiveDTO.setId_PlayerTwo(TeamFive.getId_PlayerTwo());
        teamFiveDTO.setId_PlayerThree(TeamFive.getId_PlayerThree());
        teamFiveDTO.setId_PlayerFour(TeamFive.getId_PlayerFour());
        teamFiveDTO.setId_PlayerFive(TeamFive.getId_PlayerFive());
        return  teamFiveDTO;
    }

    public static  TeamFiveDTO getTeamToDTO(MatchFinderTeamFive TeamFive){
        TeamFiveDTO teamFiveDTO = new TeamFiveDTO();

        teamFiveDTO.setTeam_Name(TeamFive.getTeam_Name());
        teamFiveDTO.setTeam_Description(TeamFive.getTeam_Description());
        teamFiveDTO.setId_Team(TeamFive.getId_Team());
        teamFiveDTO.setId_Adm(TeamFive.getId_Adm());
        teamFiveDTO.setId_PlayerTwo(TeamFive.getId_PlayerTwo());
        teamFiveDTO.setId_PlayerThree(TeamFive.getId_PlayerThree());
        teamFiveDTO.setId_PlayerFour(TeamFive.getId_PlayerFour());
        teamFiveDTO.setId_PlayerFive(TeamFive.getId_PlayerFive());

        return teamFiveDTO;
    }

    public TeamFiveDTO createTeamFive(MatchFinderTeamFive teamFive) {
        TeamFiveRepository.save(teamFive);

        return getTeamToDTO(teamFive);
    }

    public void deleteTeamFiveById(Integer id) {TeamFiveRepository.deleteById(id);
    }

    public TeamFiveDTO updateTeamFive(MatchFinderTeamFive TeamFive) {
        MatchFinderTeamFive matchFinderTeamFive = TeamFiveRepository.findById(TeamFive.getId_Team()).orElseThrow(() -> new EntityNotFoundException("ToDo with ID: " + TeamFive.getId_Team() + " not found"));
        TeamFiveDTO teamFiveDTO = new TeamFiveDTO();
        teamFiveDTO.setTeam_Name(TeamFive.getTeam_Name());
        teamFiveDTO.setTeam_Description(TeamFive.getTeam_Description());
        teamFiveDTO.setId_PlayerTwo(TeamFive.getId_PlayerTwo());
        teamFiveDTO.setId_PlayerThree(TeamFive.getId_PlayerThree());
        teamFiveDTO.setId_PlayerFour(TeamFive.getId_PlayerFour());
        teamFiveDTO.setId_PlayerFive(TeamFive.getId_PlayerFive());

        return teamFiveDTO;
    }
}