package com.example.Cricbuzz.model;


import com.example.Cricbuzz.model.Enum.Gender;
import com.example.Cricbuzz.model.Enum.Speciality;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Builder
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(EnumType.STRING)
    Speciality speciality;

    @Enumerated(EnumType.STRING)
    Gender gender;



    @OneToOne(mappedBy = "player")
    @JsonManagedReference

    Stats stats;

    @ManyToOne
    @JoinColumn
    @JsonManagedReference
    Team team;



}
