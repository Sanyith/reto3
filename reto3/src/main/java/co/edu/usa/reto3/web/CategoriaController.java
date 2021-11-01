/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.web;

import co.edu.usa.reto3.modelo.Categoria;
import co.edu.usa.reto3.servicios.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sanyi
 */
@RestController
@RequestMapping("/api/Category")
public class CategoriaController {
     @Autowired
    private CategoriaService categoriasService;
     
    @GetMapping("/all")
    public List<Categoria> getAll() {
        return categoriasService.getAll();
    }
     @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria save(@RequestBody Categoria categoria) {
        return categoriasService.save(categoria);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return new ResponseEntity<>(categoriasService.deleteCategory(id), HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Categoria> update(@RequestBody Categoria category) {
        return new ResponseEntity<>(categoriasService.updateCategory(category), HttpStatus.CREATED);
    }
}



