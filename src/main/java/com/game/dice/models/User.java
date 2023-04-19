package com.game.dice.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConstructorBinding;
<<<<<<< HEAD
import org.springframework.hateoas.server.core.Relation;
=======
>>>>>>> origin/master

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Getter
@Setter
@ConstructorBinding
<<<<<<< HEAD
@Relation(collectionRelation = "users")
=======
>>>>>>> origin/master
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String last_name;
    private  String first_name;
    @Column(unique = true)
    private String email;
    private String password;
    private String phone_number;
    private String address;



}