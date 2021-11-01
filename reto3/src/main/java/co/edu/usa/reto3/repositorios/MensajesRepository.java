/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios;

import co.edu.usa.reto3.modelo.Mensajes;
import co.edu.usa.reto3.repositorios.crud.MensajesCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sanyi
 */
@Repository
public class MensajesRepository {
    @Autowired
private MensajesCrudRepository repo;  
  
   public List<Mensajes> getAll() {
        return (List<Mensajes>) repo.findAll();    
}
   public Mensajes save(Mensajes mensajes){
        return repo.save(mensajes);
    }
   public Optional<Mensajes> getById(int id){
        return repo.findById(id);
    }
     public void delete(Mensajes message){
        repo.delete(message);
    }
}
