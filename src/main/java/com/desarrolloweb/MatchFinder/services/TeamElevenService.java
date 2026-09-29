package com.desarrolloweb.matchfinder.services;

import com.desarrolloweb.matchfinder.entities.TeamEleven;
import com.desarrolloweb.matchfinder.repositories.TeamElevenRepository;
import org.springframework.stereotype.Service;

@Service
public class TeamElevenService {
    private TeamElevenRepository teamElevenRepository;

    public TeamEleven createTeamEleven (TeamEleven teamEleven) {
        teamElevenRepository.save(teamEleven);
        return teamEleven;
    }



}
