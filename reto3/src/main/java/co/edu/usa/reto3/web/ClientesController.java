/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.web;

import co.edu.usa.reto3.modelo.Clientes;
import co.edu.usa.reto3.servicios.ClientesService;
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
@RequestMapping("/api/Client")
public class ClientesController {
    @Autowired
    private ClientesService clientesService;
     
    @GetMapping("/all")
    public List<Clientes> getAll() {
        return clientesService.getAll();
    }
     @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Clientes save(@RequestBody Clientes clientes) {
        return clientesService.save(clientes);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return new ResponseEntity<>(clientesService.deleteClient(id), HttpStatus.NO_CONTENT);
    }
 
    @PutMapping("/update")
    public ResponseEntity<Clientes> update(@RequestBody Clientes client) {
        return new ResponseEntity<>(clientesService.updateCliente(client), HttpStatus.CREATED);
    }
    
}
