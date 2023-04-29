package com.game.dice.models;

import javax.persistence.*;

@Entity
@lombok.Data

public class Tournament {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String name;
    private String date;
    private Integer price;
    @ManyToMany
    @JoinTable(
        name = "tournament_player",
        joinColumns = @JoinColumn(name = "tournament_id"),
        inverseJoinColumns = @JoinColumn(name = "player_id"))
    private java.util.List<Player> players;
    @ManyToMany
    @JoinTable(
        name = "tournament_party",
        joinColumns = @JoinColumn(name = "tournament_id"),
        inverseJoinColumns = @JoinColumn(name = "party_id"))
    private java.util.List<Party> parties;

}
