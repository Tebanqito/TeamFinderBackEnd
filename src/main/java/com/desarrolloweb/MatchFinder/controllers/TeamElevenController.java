package com.desarrolloweb.matchfinder.controllers;

import com.desarrolloweb.matchfinder.entities.TeamEleven;
import com.desarrolloweb.matchfinder.repositories.TeamElevenRepository;
import com.desarrolloweb.matchfinder.services.TeamElevenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TeamElevenController {

    private TeamElevenRepository teamElevenRepository;
    private TeamElevenService teamElevenService;

    @PostMapping("/team11")
    public ResponseEntity<?> createTeamEleven(@RequestBody TeamEleven teamEleven) {
        return ResponseEntity.ok("idTeam: " + "" + "message: usuario creado con exito." );
    }
}
