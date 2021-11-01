/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Clientes;
import co.edu.usa.reto3.repositorios.ClientesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanyi
 */
@Service
public class ClientesService {
    @Autowired
    private ClientesRepository clientesRepository;
    
    public List<Clientes> getAll(){
        return clientesRepository.getAll();  
    }
     public Clientes save(Clientes client){
        return clientesRepository.save(client);
    }
     public Clientes getById(int id){
        Optional<Clientes> client= clientesRepository.getById(id);
        return client.orElse(new Clientes());
    
    }
    public Clientes updateCliente(Clientes client) {        
        if (client.getIdClient() != null){
            Optional<Clientes> clientConsultada = clientesRepository.getById(client.getIdClient());
            if (clientConsultada.isPresent()){
                clientConsultada.get().setAge(client.getAge());
                clientConsultada.get().setEmail(client.getEmail());
                clientConsultada.get().setPassword(client.getPassword());
                clientConsultada.get().setName(client.getName());
                return clientesRepository.save(clientConsultada.get());
            }
        }
        return client;
    }
     
     public boolean deleteClient(int id) {
        boolean del = clientesRepository.getById(id).map(client -> {
            clientesRepository.delete(client);
            return true;
        }).orElse(false);
        return del;
    }
}
