package com.desarrolloweb.matchfinder.entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class TeamEleven {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTeam11;

    private String teamName;
    private String teamDescription;
    @OneToMany
    private List<MatchFinderUser> players;
}
