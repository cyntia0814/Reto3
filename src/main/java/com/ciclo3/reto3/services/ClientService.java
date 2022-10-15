package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Admin;
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
            if (cliaux.isPresent()){
                return clientRepository.save(c);
            }else {
                return c;
            }
        }
    }
    public Client update(Client c) {
        if (c.getIdClient() != null) {
            Optional<Client> client = clientRepository.getClient(c.getIdClient());
            if (client.isPresent()) {
                Client oldClient = client.get();
                if (c.getEmail() != null) {
                    oldClient.setEmail(c.getEmail());
                }
                if (c.getPassword() != null) {
                    oldClient.setPassword(c.getPassword());
                }
                if (c.getName() != null) {
                    oldClient.setName(c.getName());
                }
                if (c.getAge() != null) {
                    oldClient.setAge(c.getAge());
                }
                return clientRepository.save(oldClient);
            }
        }
        return c;
    }

    public boolean delete(int id) {
        Optional<Client> Cli = clientRepository.getClient(id);
        if (Cli.isPresent()) {
            clientRepository.delete(Cli.get());
            return true;
        } else {
            return false;
        }
    }
}
