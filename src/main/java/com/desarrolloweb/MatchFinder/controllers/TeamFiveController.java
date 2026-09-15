package com.desarrolloweb.matchfinder.controllers;

import com.desarrolloweb.matchfinder.dtos.TeamFiveDTO;
import com.desarrolloweb.matchfinder.entities.MatchFinderTeamFive;
import com.desarrolloweb.matchfinder.repositories.TeamFiveRepository;
import com.desarrolloweb.matchfinder.services.TeamFiveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TeamFiveController {

    private TeamFiveRepository teamFiveRepository;
    private TeamFiveService teamFiveService;

    public TeamFiveController(TeamFiveService teamFiveService) {
        this.teamFiveService = teamFiveService;
    }

    @GetMapping("/get/teamsFive")
    public ResponseEntity<List<TeamFiveDTO>> getTeamsFive() {
        return ResponseEntity.ok(teamFiveService.getAllTeams());
    }

    @GetMapping("/get/teamsFive/{id}")
    public ResponseEntity<TeamFiveDTO> getTeamsFive(@PathVariable Integer id) {
        return ResponseEntity.ok(teamFiveService.getTeamsById(id));
    }

    @PatchMapping("update/teamsFive/{id}")
    public ResponseEntity<?> updateTeamsFive(@RequestBody MatchFinderTeamFive matchFinderTeamFive) {
        TeamFiveDTO teamFiveDTO = teamFiveService.updateTeamFive(matchFinderTeamFive);
        return ResponseEntity.status(HttpStatus.CREATED).body(teamFiveDTO);
    }

    @DeleteMapping("/delete/teamsFive/{id}")
    public ResponseEntity<Void> deleteTeamsFive(@PathVariable Integer id) {
        teamFiveService.deleteTeamFiveById(id);
        return ResponseEntity.noContent().build();
    }

}