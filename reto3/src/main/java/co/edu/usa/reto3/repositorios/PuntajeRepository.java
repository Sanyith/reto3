/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios;

import co.edu.usa.reto3.modelo.Puntaje;
import co.edu.usa.reto3.repositorios.crud.PuntajeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sanyi
 */
@Repository
public class PuntajeRepository {
    
     @Autowired
private PuntajeCrudRepository repo;  
  
   public List<Puntaje> getAll() {
        return (List<Puntaje>) repo.findAll();    
}
   public Puntaje save(Puntaje puntaje){
        return repo.save(puntaje);
    }
   public Optional<Puntaje> getById(int id){
        return repo.findById(id);
    }
    
    public void delete(Puntaje score){
        repo.delete(score);
    }
}
