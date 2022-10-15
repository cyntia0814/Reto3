package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Admin;
import com.ciclo3.reto3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll(){
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin a){
        if(a.getId()==null){
            return adminRepository.save(a);
        }else{
            Optional<Admin> admiaux= adminRepository.getAdmin(a.getId());
            if (admiaux.isPresent()){
                return adminRepository.save(a);
            }else {
                return a;
            }
        }
    }
}
