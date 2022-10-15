package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Score;
import com.ciclo3.reto3.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {

    @Autowired
    private ScoreRepository scoreRepository;

    public List<Score> getAll(){
        return scoreRepository.getAll();
    }

    public Optional<Score> getScore(int idScore){
        return scoreRepository.getScore(idScore);
    }

    public Score save(Score s){
        if(s.getIdScore()==null){
            return scoreRepository.save(s);
        }else{
            Optional<Score> scoaux= scoreRepository.getScore(s.getIdScore());
            if (scoaux.isPresent()){
                return scoreRepository.save(s);
            }else {
                return s;
            }
        }
    }
}
