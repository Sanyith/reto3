/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Mensajes;
import co.edu.usa.reto3.repositorios.MensajesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanyi
 */
@Service
public class MensajesService {

    @Autowired
    private MensajesRepository mensajesRepository;

    public List<Mensajes> getAll() {
        return mensajesRepository.getAll();
    }

    public Mensajes save(Mensajes mensajes) {
        return mensajesRepository.save(mensajes);
    }

    public Mensajes getById(int id) {
        Optional<Mensajes> mensajes = mensajesRepository.getById(id);
        return mensajes.orElse(new Mensajes());
    }

    public Mensajes updateMessage(Mensajes message) {
        if (message.getIdMessage() != null) {
            Optional<Mensajes> messageConsultada = mensajesRepository.getById(message.getIdMessage());
            if (messageConsultada.isPresent()) {
                messageConsultada.get().setMessageText(message.getMessageText());
                messageConsultada.get().setClient(message.getClient());
                messageConsultada.get().setQuadbike(message.getQuadbike());
                return mensajesRepository.save(messageConsultada.get());
            }
        }
        return message;
    }

    public boolean deleteMessage(int id) {
        boolean del = mensajesRepository.getById(id).map(message -> {
            mensajesRepository.delete(message);
            return true;
        }).orElse(false);
        return del;
    }
}
