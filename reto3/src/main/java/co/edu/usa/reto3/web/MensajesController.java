/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.web;

import co.edu.usa.reto3.modelo.Mensajes;
import co.edu.usa.reto3.servicios.MensajesService;
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
@RequestMapping("/api/Message")
public class MensajesController {
    @Autowired
    private MensajesService mensajesService;
    
    @GetMapping("/all")
    public List<Mensajes> getAll() {
        return mensajesService.getAll();
    }
     @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Mensajes save(@RequestBody Mensajes mensajes) {
        return mensajesService.save(mensajes);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return new ResponseEntity<>(mensajesService.deleteMessage(id), HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Mensajes> update(@RequestBody Mensajes message) {
        return new ResponseEntity<>(mensajesService.updateMessage(message), HttpStatus.CREATED);
    }
      }

