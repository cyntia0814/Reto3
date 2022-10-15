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

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin a) {
        if (a.getId() == null) {
            return adminRepository.save(a);
        } else {
            Optional<Admin> admiaux = adminRepository.getAdmin(a.getId());
            if (admiaux.isPresent()) {
                return adminRepository.save(a);
            } else {
                return a;
            }
        }
    }

    public Optional<Admin> getById(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin update(Admin a) {
        if (a.getId() != null) {
            Optional<Admin> ad = adminRepository.getAdmin(a.getId());
            if (ad.isPresent()) {
                Admin oldAdm = ad.get();
                if (a.getName() != null) {
                    oldAdm.setName(a.getName());
                }
                if (a.getPassword() != null) {
                    oldAdm.setPassword(a.getPassword());
                }
                if (a.getEmail() != null) {
                    oldAdm.setEmail(a.getEmail());
                }
                return adminRepository.save(oldAdm);
            }
        }
        return a;
    }

    public boolean delete(int id) {
        Optional<Admin> Adm = adminRepository.getAdmin(id);
        if (Adm.isPresent()) {
            adminRepository.delete(Adm.get());
            return true;
        } else {
            return false;
        }
    }
}
