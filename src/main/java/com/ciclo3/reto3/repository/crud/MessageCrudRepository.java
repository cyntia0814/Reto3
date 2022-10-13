package com.ciclo3.reto3.repository.crud;

import com.ciclo3.reto3.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
