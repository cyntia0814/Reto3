package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Client;
import com.ciclo3.reto3.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int idClient){
        return clientRepository.getClient(idClient);
    }

    public Client save(Client c){
        if(c.getIdClient()==null){
            return clientRepository.save(c);
        }else{
            Optional<Client> cliaux= clientRepository.getClient(c.getIdClient());
            if (cliaux.isEmpty()){
                return clientRepository.save(c);
            }else {
                return c;
            }
        }
    }
}
