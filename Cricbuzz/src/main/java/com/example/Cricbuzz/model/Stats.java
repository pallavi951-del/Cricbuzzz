package com.example.Cricbuzz.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Stats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    int  runs;

    int wickets;

    double battingAvg;

    double bowlingAvg;


    @OneToOne
    @JsonBackReference
    @JoinColumn
    Players player;



}
