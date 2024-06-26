package it.manager.tournamentmanager.entities;

import it.manager.tournamentmanager.entities.enums.MatchState;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Tournament {

    @Id
    @GeneratedValue
    private UUID id;

    private String avatar;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private String name;

    @ManyToMany
    @JoinTable(
            name = "tournament_participants",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> participants;

    @OneToOne
    @JoinColumn(name = "bracket_id")
    private Bracket bracket;

    @Enumerated(EnumType.STRING)
    private MatchState tournamentState;

    @OneToOne
    @JoinColumn(name = "manager_id")
    private User tournamentManager;

    private String description;
    private String prize;
    private LocalDate startingDate;
    private LocalDate endingDate;
    private LocalTime startingTime;

    @OneToOne
    @JoinColumn(name = "winner_id")
    private Team winner;


    @ManyToMany
    @JoinTable(
            name = "tournament_losers",
            joinColumns = @JoinColumn(name = "tournament_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
    private List<Team> losers;

}
