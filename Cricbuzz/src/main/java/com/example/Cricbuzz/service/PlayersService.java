package com.example.Cricbuzz.service;


import com.example.Cricbuzz.Convertor.PlayerConvertor;
import com.example.Cricbuzz.dto.reponse.PlayersResponse;
import com.example.Cricbuzz.dto.request.PlayersRequest;
import com.example.Cricbuzz.exception.PlayersNotFondExceptions;
import com.example.Cricbuzz.model.Enum.Gender;
import com.example.Cricbuzz.model.Players;
import com.example.Cricbuzz.repository.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayersService {

   @Autowired
   static PlayersRepository playersRepository;

    public static PlayersResponse addPlayer(PlayersRequest playersRequest) {

        Players player = PlayerConvertor.PlayerRequestToPlayer(playersRequest);
        Players savedPlayer = playersRepository.save(player);
        return PlayerConvertor.PlayerRequestToPlayer(savedPlayer);


    }
    public static PlayersResponse getPlayersById(int id){
       Optional<Players> playersOptional = playersRepository.findById(id);

        if(playersOptional.isEmpty()){
           throw new PlayersNotFondExceptions("Player with id " + id + " doesn't exist");
        }
        return PlayerConvertor.PlayerRequestToPlayer(playersOptional.get());
    }

    public static List<PlayersResponse> getByGenderAndAgeGreaterThan(Gender gender, int age) {
      List<Players> players =  playersRepository.findByGenderAndAgeGreaterThan(gender,age);

      List<PlayersResponse> playersResponses = new ArrayList<>();
      for(Players players1:players){
          playersResponses.add(PlayerConvertor.PlayerRequestToPlayer(players1));
      }
      return playersResponses;

    }

    public static List<PlayersResponse> getByGenderAndSpeciality(String gender, String speciality) {
        List<Players> players =  playersRepository.getByGenderAndSpeciality(gender,speciality);




        List<PlayersResponse> playersResponses = new ArrayList<>();
        for(Players players1:players){
            playersResponses.add(PlayerConvertor.PlayerRequestToPlayer(players1));
        }
        return playersResponses;
    }
}
