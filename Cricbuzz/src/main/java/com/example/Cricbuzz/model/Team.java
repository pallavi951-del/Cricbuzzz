package com.example.Cricbuzz.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int ranking;

    int iccPoints;

    String coach;

    int matchesPlayed;

    @OneToMany(mappedBy = "team")
    @JsonBackReference
    List<Players> playerList;


    @ManyToMany(mappedBy = "team")
    @JsonBackReference

     List<CricketMatch> cricketMatch;
}
