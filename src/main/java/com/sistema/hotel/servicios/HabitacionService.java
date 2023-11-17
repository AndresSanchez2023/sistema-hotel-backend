package com.sistema.hotel.servicios;

import com.sistema.hotel.entidades.Habitacion;

import java.util.Set;

public interface HabitacionService {

    Habitacion agregarHabitacion(Habitacion habitacion);

    Habitacion actualizarHabitacion(Habitacion habitacion);

    Set<Habitacion> obtenerHabitaciones();

    Habitacion obtenerHabitacion(Long habitacionId);

    void eliminarHabitacion(Long habitacionId);
}
