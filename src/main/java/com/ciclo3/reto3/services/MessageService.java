package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Message;
import com.ciclo3.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int idMessage){
        return messageRepository.getMessage(idMessage);
    }

    public Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> mesaux= messageRepository.getMessage(m.getIdMessage());
            if (mesaux.isEmpty()){
                return messageRepository.save(m);
            }else {
                return m;
            }
        }
    }
}
