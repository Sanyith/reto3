/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.reto3.servicios;

import co.edu.usa.reto3.modelo.Reservas;
import co.edu.usa.reto3.repositorios.ReservasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sanyi
 */
@Service
public class ReservasService {

    @Autowired
    private ReservasRepository reservasRepository;

    public List<Reservas> getAll() {
        return reservasRepository.getAll();
    }

    public Reservas save(Reservas reservas) {
        if (reservas.getStatus() == null) {
            reservas.setStatus("created");
        }
        return reservasRepository.save(reservas);
    }

    public Reservas getById(int id) {
        Optional<Reservas> reservas = reservasRepository.getById(id);
        return reservas.orElse(new Reservas());

    }

    public Reservas updateReservation(Reservas reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reservas> reservationConsultada = reservasRepository.getById(reservation.getIdReservation());
            if (reservationConsultada.isPresent()) {
                reservationConsultada.get().setScore(reservation.getScore());
                reservationConsultada.get().setDevolutionDate(reservation.getDevolutionDate());
                reservationConsultada.get().setQuadbike(reservation.getQuadbike());
                reservationConsultada.get().setClient(reservation.getClient());
                reservationConsultada.get().setStartDate(reservation.getStartDate());
                reservationConsultada.get().setStatus(reservation.getStatus());
                return reservasRepository.save(reservationConsultada.get());
            }
        }
        return reservation;
    }

    public boolean deleteReserva(int id) {
        boolean del = reservasRepository.getById(id).map(reservation -> {
            reservasRepository.delete(reservation);
            return true;
        }).orElse(false);
        return del;
    }

}
