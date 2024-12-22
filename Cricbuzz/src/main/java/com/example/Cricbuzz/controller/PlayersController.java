package com.example.Cricbuzz.controller;


import com.example.Cricbuzz.dto.reponse.PlayersResponse;
import com.example.Cricbuzz.dto.request.PlayersRequest;
import com.example.Cricbuzz.model.Enum.Gender;
import com.example.Cricbuzz.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/players")
public class PlayersController {

    @Autowired
    PlayersService playersService;

      @PostMapping
    public PlayersResponse addPlayer(@RequestBody PlayersRequest playersRequest){
      return PlayersService.addPlayer(playersRequest);

    }
     @GetMapping("/id/{id}")
    public PlayersResponse getPlayersById(@PathVariable("id") int id){
        return PlayersService.getPlayersById(id);
   }

   // gender and age
    @GetMapping("/gender/{gender}/age/{age}")
   public List<PlayersResponse> getByGenderAndAgeGreaterThan(@PathVariable("gender") Gender gender,
                                                             @PathVariable("age") int age ){
          return PlayersService.getByGenderAndAgeGreaterThan(gender,age);

   }
   // speciality and gender
     @GetMapping("/gender/{gender}/speciality/{speciality}")
    public List<PlayersResponse> getByGenderAndSpeciality(@PathVariable("gender")String gender,
                                                          @PathVariable("speciality") String  speciality){
          return PlayersService.getByGenderAndSpeciality(gender,speciality);

    }





}
