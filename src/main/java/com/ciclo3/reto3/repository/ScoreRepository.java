package com.ciclo3.reto3.repository;

import com.ciclo3.reto3.entities.Audience;
import com.ciclo3.reto3.entities.Score;
import com.ciclo3.reto3.repository.crud.AudienceCrudRepository;
import com.ciclo3.reto3.repository.crud.ScoreCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {

    @Autowired
    private ScoreCrudRepository scoreCrudRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCrudRepository.findAll();
    }
    public Optional<Score> getScore (int idScore){
        return scoreCrudRepository.findById(idScore);
    }
    public Score save(Score s){
        return scoreCrudRepository.save(s);
    }
    public void delete(Score s){
        scoreCrudRepository.delete(s);
    }
}
