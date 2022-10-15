package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Admin;
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
    public Audience update(Audience a) {
        if (a.getId() != null) {
            Optional<Audience> audi = audienceRepository.getAudience(a.getId());
            if (audi.isPresent()) {
                Audience oldAudi = audi.get();
                if (a.getName() != null) {
                    oldAudi.setName(a.getName());
                }
                if (a.getOwner() != null) {
                    oldAudi.setOwner(a.getOwner());
                }
                if (a.getCapacity() != null) {
                    oldAudi.setCapacity(a.getCapacity());
                }
                if (a.getDescription() != null) {
                    oldAudi.setDescription(a.getDescription());
                }
                if (a.getCategory() != null) {
                    oldAudi.setCategory(a.getCategory());
                }
                return audienceRepository.save(oldAudi);
            }
        }
        return a;
    }

    public boolean delete(int id) {
        Optional<Audience> Audie= audienceRepository.getAudience(id);
        if (Audie.isPresent()) {
            audienceRepository.delete(Audie.get());
            return true;
        } else {
            return false;
        }
    }
}
