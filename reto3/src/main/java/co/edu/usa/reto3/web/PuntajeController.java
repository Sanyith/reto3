/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.web;

import co.edu.usa.reto3.modelo.Puntaje;
import co.edu.usa.reto3.servicios.PuntajeService;
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
@RequestMapping("/api/score")
public class PuntajeController {
     @Autowired
    private PuntajeService puntajeService;
     
    @GetMapping("/all")
    public List<Puntaje> getAll() {
        return puntajeService.getAll();
    }
     @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Puntaje save(@RequestBody Puntaje puntaje) {
        return puntajeService.save(puntaje);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return new ResponseEntity<>(puntajeService.deleteScore(id), HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Puntaje> update(@RequestBody Puntaje score) {
        return new ResponseEntity<>(puntajeService.updatescore(score), HttpStatus.CREATED);
    }
    
}

   