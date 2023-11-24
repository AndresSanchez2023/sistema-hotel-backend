package com.sistema.hotel.servicios.impl;

import com.sistema.hotel.entidades.Habitacion;
import com.sistema.hotel.entidades.Reserva;
import com.sistema.hotel.repositorios.HabitacionRepository;
import com.sistema.hotel.repositorios.ReservaRepository;
import com.sistema.hotel.servicios.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public Reserva agregarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Reserva actualizarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public Set<Reserva> obtenerReservas() {
        return (Set<Reserva>) reservaRepository.findAll();
    }

    @Override
    public Reserva obtenerReserva(Long reservaId) {
        return reservaRepository.findById(reservaId).get();
    }

    @Override
    public Set<Reserva> obtenerReservasDeHabitacion(Habitacion habitacion) {
        return reservaRepository.findByHabitacion(habitacion);
    }

    @Override
    public void eliminarReserva(Long reservaId) {
        Reserva reserva = obtenerReserva(reservaId);
        if (reserva != null){
            reservaRepository.delete(reserva);
        }
    }
}
