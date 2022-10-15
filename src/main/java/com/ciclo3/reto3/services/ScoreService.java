package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Admin;
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
    public Score update(Score s) {
        if (s.getIdScore() != null) {
            Optional<Score> score = scoreRepository.getScore(s.getIdScore());
            if (score.isPresent()) {
                Score oldSco = score.get();
                if (s.getMessageText() != null) {
                    oldSco.setMessageText(s.getMessageText());
                }
                if (s.getStars() != null) {
                    oldSco.setStars(s.getStars());
                }
                return scoreRepository.save(oldSco);
            }
        }
        return s;
    }

    public boolean delete(int id) {
        Optional<Score> sc = scoreRepository.getScore(id);
        if (sc.isPresent()) {
            scoreRepository.delete(sc.get());
            return true;
        } else {
            return false;
        }
    }
}
