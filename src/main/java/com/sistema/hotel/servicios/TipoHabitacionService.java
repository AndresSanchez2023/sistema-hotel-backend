package com.sistema.hotel.servicios;

import com.sistema.hotel.entidades.TipoHabitacion;

import java.util.Set;

public interface TipoHabitacionService {

    TipoHabitacion agregarTipoHabitacion(TipoHabitacion tipoHabitacion);

    TipoHabitacion actualizarTipoHabitacion(TipoHabitacion tipoHabitacion);

    Set<TipoHabitacion> obtenerTipoHabitaciones();

    TipoHabitacion obtenerTipoHabitacion(Long tipoHabitacionId);

    void eliminarTipoHabitacion(Long categoriaId);


}
