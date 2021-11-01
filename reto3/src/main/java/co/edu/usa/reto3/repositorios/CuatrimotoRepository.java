/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios;

import co.edu.usa.reto3.repositorios.crud.CuatrimotoCrudRepository;
import co.edu.usa.reto3.modelo.Cuatrimotos;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sanyi
 */
@Repository
public class CuatrimotoRepository {
   @Autowired 
    private CuatrimotoCrudRepository repo;
  
    public List<Cuatrimotos> getAll() {
        return (List<Cuatrimotos>) repo.findAll();
    }
  public List<Cuatrimotos> getByIdMensaje(int idMensaje) {
        return (List<Cuatrimotos>) repo.findByIdMensajeOrderByNombreAsc(idMensaje);
        
  }
public Optional<Cuatrimotos> getById(int id) {
        return repo.findById(id);
    }
    
    public Cuatrimotos save(Cuatrimotos cuatrimotos){
        return repo.save(cuatrimotos);
    }
       public void delete(Cuatrimotos quadbike){
        repo.delete(quadbike);
    }
    
}


 
       

  
    



    

   
    
    
  

   
    
    

