/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.web;

import co.edu.usa.reto3.modelo.Reservas;
import co.edu.usa.reto3.servicios.ReservasService;
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
@RequestMapping("/api/Reservation")
public class ReservasController {
     @Autowired
    private ReservasService reservasService;
     
    @GetMapping("/all")
    public List<Reservas> getAll() {
        return reservasService.getAll();
    }
     @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservas save(@RequestBody Reservas reservas) {
        return reservasService.save(reservas);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id){
        return new ResponseEntity<>(reservasService.deleteReserva(id), HttpStatus.NO_CONTENT);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Reservas> update(@RequestBody Reservas reservation) {
        return new ResponseEntity<>(reservasService.updateReservation(reservation), HttpStatus.CREATED);
    }
}
