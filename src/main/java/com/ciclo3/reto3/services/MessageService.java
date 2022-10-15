package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Admin;
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
            if (mesaux.isPresent()){
                return messageRepository.save(m);
            }else {
                return m;
            }
        }
    }
    public Message update(Message m) {
        if (m.getIdMessage() != null) {
            Optional<Message> mes = messageRepository.getMessage(m.getIdMessage());
            if (mes.isPresent()) {
                Message oldMes = mes.get();
                if (m.getMessageText() != null) {
                    oldMes.setMessageText(m.getMessageText());
                }
                return messageRepository.save(oldMes);
            }
        }
        return m;
    }

    public boolean delete(int id) {
        Optional<Message> Mess = messageRepository.getMessage(id);
        if (Mess.isPresent()) {
            messageRepository.delete(Mess.get());
            return true;
        } else {
            return false;
        }
    }
}
