/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.repositorios.crud;

import co.edu.usa.reto3.modelo.Cuatrimotos;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;



/**
 *
 * @author sanyi
 */
public interface CuatrimotoCrudRepository extends CrudRepository<Cuatrimotos, Integer> {
    
    @Query(value="select * from quadbike where mensaje_id = ? order by nombre ASC", nativeQuery = true)
    public List<Cuatrimotos> findByIdMensajeOrderByNombreAsc(int idMensaje);   
}

    