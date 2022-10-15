package com.ciclo3.reto3.controller;


import com.ciclo3.reto3.entities.Admin;
import com.ciclo3.reto3.entities.Score;
import com.ciclo3.reto3.services.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Score")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreService.getAll();
    }

    @GetMapping("/{idScore}")
    public Optional<Score> getScore(@PathVariable("idScore")int idScore){
        return scoreService.getScore(idScore);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score s){
        return scoreService.save(s);
    }

    @PutMapping("/update")
    public Score update(@RequestBody Score s){
        return scoreService.update(s);
    }
    @DeleteMapping("/{idScore}")
    public boolean delete(@PathVariable("idScore") int id){
        return scoreService.delete(id);
    }
}
