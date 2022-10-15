package com.ciclo3.reto3.repository;

import com.ciclo3.reto3.entities.Audience;
import com.ciclo3.reto3.repository.crud.AudienceCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AudienceRepository {

    @Autowired
    private AudienceCrudRepository audienceCrudRepository;

    public List<Audience> getAll(){
        return (List<Audience>) audienceCrudRepository.findAll();
    }
    public Optional<Audience> getAudience (int id){
        return audienceCrudRepository.findById(id);
    }
    public Audience save(Audience a){
        return audienceCrudRepository.save(a);
    }
    public void delete(Audience a){
        audienceCrudRepository.delete(a);
    }
}
