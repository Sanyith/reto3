/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios;

import co.edu.usa.reto3.modelo.Reservas;
import co.edu.usa.reto3.repositorios.crud.ReservasCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sanyi
 */
@Repository
public class ReservasRepository {
     @Autowired
private ReservasCrudRepository repo;  
  
   public List<Reservas> getAll() {
        return (List<Reservas>) repo.findAll();    
}
   public Reservas save(Reservas reservas){
        return repo.save(reservas);
    }
   public Optional<Reservas> getById(int id){
        return repo.findById(id);
    }
    public void delete(Reservas reservation){
        repo.delete(reservation);
    }
}
    

 