/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Puntaje;
import co.edu.usa.reto3.repositorios.PuntajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanyi
 */
@Service
public class PuntajeService {
     @Autowired
    private PuntajeRepository puntajeRepository;
    
    public List<Puntaje> getAll(){
        return puntajeRepository.getAll();  
    }
     public Puntaje save(Puntaje puntaje){
        return puntajeRepository.save(puntaje);
    }
     public Puntaje getById(int id){
        Optional<Puntaje> puntaje= puntajeRepository.getById(id);
        return puntaje.orElse(new Puntaje());
}
     public Puntaje updatescore(Puntaje score) {        
        if (score.getId() != null){
            Optional<Puntaje> scoreConsultada = puntajeRepository.getById(score.getId());
            if (scoreConsultada.isPresent()){
                scoreConsultada.get().setScore(score.getScore());
                return puntajeRepository.save(scoreConsultada.get());
            }
            }
        return score;
    }
     
     public boolean deleteScore(int id) {
        boolean del = puntajeRepository.getById(id).map(score -> {
            puntajeRepository.delete(score);
            return true;
        }).orElse(false);
        return del;
    }
     }

