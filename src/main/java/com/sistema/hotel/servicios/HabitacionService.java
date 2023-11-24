package com.sistema.hotel.servicios;

import com.sistema.hotel.entidades.Habitacion;
import com.sistema.hotel.entidades.TipoHabitacion;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface HabitacionService {

    Habitacion agregarHabitacion(Habitacion habitacion);

    Habitacion actualizarHabitacion(Habitacion habitacion);

    Set<Habitacion> obtenerHabitaciones();

    Habitacion obtenerHabitacion(Long habitacionId);

    void eliminarHabitacion(Long habitacionId);

    List<Habitacion> verificarDisponibilidad (Date fechaInicio, Date fechaFin, Long tipoHabitacionId);
}
