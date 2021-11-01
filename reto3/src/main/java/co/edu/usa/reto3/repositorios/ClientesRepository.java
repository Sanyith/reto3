/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios;

import co.edu.usa.reto3.modelo.Clientes;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.usa.reto3.repositorios.crud.ClientesCrudRepository;

/**
 *
 * @author sanyi
 */
@Repository
public class ClientesRepository {
     @Autowired
private ClientesCrudRepository repo;  
  
   public List<Clientes> getAll() {
        return (List<Clientes>) repo.findAll();    
}
   public Clientes save(Clientes clientes){
        return repo.save(clientes);
    }
   public Optional<Clientes> getById(int id){
        return repo.findById(id);
    }
       public void delete(Clientes client){
        repo.delete(client);
    }
}

    