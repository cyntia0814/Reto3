package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Audience;
import com.ciclo3.reto3.repository.AudienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AudienceService {

    @Autowired
    private AudienceRepository audienceRepository;

    public List<Audience> getAll(){
        return audienceRepository.getAll();
    }

    public Optional<Audience> getAudience(int id){
        return audienceRepository.getAudience(id);
    }

    public Audience save(Audience a){
        if(a.getId()==null){
            return audienceRepository.save(a);
        }else{
            Optional<Audience> audiaux=audienceRepository.getAudience(a.getId());
            if (audiaux.isPresent()){
                return audienceRepository.save(a);
            }else {
                return a;
            }
        }
    }
}
