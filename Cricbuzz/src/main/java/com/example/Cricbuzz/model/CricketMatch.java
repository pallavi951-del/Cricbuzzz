package com.example.Cricbuzz.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class CricketMatch {


            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            int id;

            String title;

            String venue;

            @CreationTimestamp
            Date created;


            @ManyToMany
            @JsonManagedReference
            @JoinTable(name = "match_team",
            joinColumns = @JoinColumn(name = "match_id"),
                    inverseJoinColumns =@JoinColumn(name = "team_id") )

            List<Team> team;

}
