package com.example.Cricbuzz.repository;

import com.example.Cricbuzz.model.Enum.Gender;
import com.example.Cricbuzz.model.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayersRepository  extends JpaRepository<Players,Integer> {

    List<Players> findByGenderAndAgeGreaterThan(Gender gender, int age);

    @Query(value = "select * from players where gender = :gender AND speciality = : speciality ",nativeQuery = true)
    List<Players> getByGenderAndSpeciality(String gender, String speciality);

}
