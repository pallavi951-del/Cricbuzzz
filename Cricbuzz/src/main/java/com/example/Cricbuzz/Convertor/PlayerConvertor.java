package com.example.Cricbuzz.Convertor;

import com.example.Cricbuzz.dto.reponse.PlayersResponse;
import com.example.Cricbuzz.dto.request.PlayersRequest;
import com.example.Cricbuzz.model.Players;

public class PlayerConvertor {


    public static Players PlayerRequestToPlayer(PlayersRequest playersRequest){
        return Players.builder()
                .name(playersRequest.getName())
                .age(playersRequest.getAge())
                .speciality(playersRequest.getSpeciality())
                .gender(playersRequest.getGender())
                .build();

    }

    public static PlayersResponse PlayerRequestToPlayer(Players players){
        return PlayersResponse.builder()
                .name(players.getName())
                .speciality(players.getSpeciality())
                .build();

    }
}
