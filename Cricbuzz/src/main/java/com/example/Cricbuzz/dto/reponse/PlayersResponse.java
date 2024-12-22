package com.example.Cricbuzz.dto.reponse;

import com.example.Cricbuzz.model.Enum.Speciality;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class PlayersResponse {

    String name;

    Speciality speciality;
}
