/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Categoria;
import co.edu.usa.reto3.repositorios.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanyi
 */
@Service
public class CategoriaService {
    
   @Autowired
    private CategoriaRepository categoriaRepository;
    
    public List<Categoria> getAll(){
        return categoriaRepository.getAll();  
    }
     public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
     public Categoria getById(int id){
        Optional<Categoria> categoria= categoriaRepository.getById(id);
        return categoria.orElse(new Categoria());
//        if (categoria.isPresent()){
//            return categoria.get();
//        }else{
//            return new Categoria();
     }
     
     public Categoria updateCategory(Categoria category) {        
        if (category.getId() != null){
            Optional<Categoria> categoryConsultada = categoriaRepository.getById(category.getId());
            if (categoryConsultada.isPresent()){
                categoryConsultada.get().setDescription(category.getDescription());
                categoryConsultada.get().setName(category.getName());
                return categoriaRepository.save(categoryConsultada.get());
            }
        }
        return category;
    }
     
     public boolean deleteCategory(int id) {
        boolean del = categoriaRepository.getById(id).map(category -> {
            categoriaRepository.delete(category);
            return true;
        }).orElse(false);
        return del;
    }
     
}
