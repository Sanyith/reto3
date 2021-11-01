/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios;

import co.edu.usa.reto3.modelo.Admin;
import co.edu.usa.reto3.repositorios.crud.AdminCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sanyi
 */
@Repository
public class AdminRepository {
    @Autowired
private AdminCrudRepository repo;  
  
   public List<Admin> getAll() {
        return (List<Admin>) repo.findAll();    
}
   public Admin save(Admin admin){
        return repo.save(admin);
    }
   public Optional<Admin> getById(int id){
        return repo.findById(id);
    }
    
    public void delete(Admin admin){
        repo.delete(admin);
    }
}
