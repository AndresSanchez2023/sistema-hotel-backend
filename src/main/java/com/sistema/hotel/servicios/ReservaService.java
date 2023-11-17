package com.sistema.hotel.servicios;

import com.sistema.hotel.entidades.Habitacion;
import com.sistema.hotel.entidades.Reserva;

import java.util.Set;

public interface ReservaService {

    Reserva agregarReserva(Reserva reserva);

    Reserva actualizarReserva(Reserva reserva);

    Set<Reserva> obtenerReservas();

    Reserva obtenerReserva(Long reservaId);

    Set<Reserva> obtenerReservasDeHabitacion(Habitacion habitacion);

    void eliminarReserva(Long reservaId);

}
