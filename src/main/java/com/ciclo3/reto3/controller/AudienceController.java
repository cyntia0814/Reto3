package com.ciclo3.reto3.controller;

import com.ciclo3.reto3.entities.Admin;
import com.ciclo3.reto3.entities.Audience;
import com.ciclo3.reto3.services.AudienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Audience")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AudienceController {
    @Autowired
    private AudienceService audienceService;

    @GetMapping("/all")
    public List<Audience> getAll(){
        return audienceService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Audience> getAudience(@PathVariable("id")int id){
        return audienceService.getAudience(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience save(@RequestBody Audience a){
        return audienceService.save(a);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Audience update(@RequestBody Audience a){
        return audienceService.update(a);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return audienceService.delete(id);
    }
}
