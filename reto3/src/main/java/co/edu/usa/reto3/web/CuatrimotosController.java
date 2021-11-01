/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.web;

import co.edu.usa.reto3.modelo.Cuatrimotos;
import co.edu.usa.reto3.servicios.CuatrimotosService;
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
@RequestMapping("/api/Quadbike")

public class CuatrimotosController {
    
      @Autowired
    private CuatrimotosService cuatrimotosService;

    @GetMapping("/all")
    public List<Cuatrimotos> getAll() {
        return cuatrimotosService.getAll();
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Cuatrimotos save(@RequestBody Cuatrimotos cuatrimotos) {
        return cuatrimotosService.save(cuatrimotos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return new ResponseEntity<>(cuatrimotosService.deleteQuadbike(id), HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Cuatrimotos> update(@RequestBody Cuatrimotos quadbike) {
        return new ResponseEntity<>(cuatrimotosService.updateQuadbike(quadbike), HttpStatus.CREATED);
    }
}
