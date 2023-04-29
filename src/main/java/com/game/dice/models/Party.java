package com.game.dice.models;

import lombok.Data;

import org.springframework.boot.context.properties.ConstructorBinding;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Data
@ConstructorBinding

public class Party {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String date;
    private Integer score;
    @ManyToMany
    @JoinTable(
        name = "party_player",
        joinColumns = @JoinColumn(name = "party_id"),
        inverseJoinColumns = @JoinColumn(name = "player_id"))
    private List<Player> players;




}
