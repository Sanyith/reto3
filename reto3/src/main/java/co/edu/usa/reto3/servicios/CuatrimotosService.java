/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Cuatrimotos;
import co.edu.usa.reto3.repositorios.CuatrimotoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanyi
 */
@Service
public class CuatrimotosService {

    @Autowired
    private CuatrimotoRepository cuatrimotoRepository;

    public List<Cuatrimotos> getAll() {
        return cuatrimotoRepository.getAll();
    }

    public Cuatrimotos save(Cuatrimotos cuatrimotos) {
        return cuatrimotoRepository.save(cuatrimotos);
    }

    public Cuatrimotos getById(int id) {
        Optional<Cuatrimotos> cuatrimoto = cuatrimotoRepository.getById(id);
        return cuatrimoto.orElse(new Cuatrimotos());
//        if (categoria.isPresent()){
//            return categoria.get();
//        }else{
//            return new Categoria();
    }

    public Cuatrimotos updateQuadbike(Cuatrimotos quadbike) {
        if (quadbike.getId() != null) {
            Optional<Cuatrimotos> quadbikeConsultada = cuatrimotoRepository.getById(quadbike.getId());
            if (quadbikeConsultada.isPresent()) {
                quadbikeConsultada.get().setBrand(quadbike.getBrand());
                quadbikeConsultada.get().setCategory(quadbike.getCategory());
                quadbikeConsultada.get().setDescription(quadbike.getDescription());
                quadbikeConsultada.get().setName(quadbike.getName());
                quadbikeConsultada.get().setYear(quadbike.getYear());
                return cuatrimotoRepository.save(quadbikeConsultada.get());
            }
        }
        return quadbike;
    }

    public boolean deleteQuadbike(int id) {
        boolean del = cuatrimotoRepository.getById(id).map(quadbike -> {
            cuatrimotoRepository.delete(quadbike);
            return true;
        }).orElse(false);
        return del;
    }
}
