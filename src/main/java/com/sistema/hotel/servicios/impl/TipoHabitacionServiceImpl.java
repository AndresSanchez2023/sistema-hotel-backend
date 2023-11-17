package com.sistema.hotel.servicios.impl;

import com.sistema.hotel.entidades.TipoHabitacion;
import com.sistema.hotel.repositorios.TipoHabitacionRepository;
import com.sistema.hotel.servicios.TipoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class TipoHabitacionServiceImpl implements TipoHabitacionService {

    @Autowired
    private TipoHabitacionRepository tipoHabitacionRepository;

    @Override
    public TipoHabitacion agregarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionRepository.save(tipoHabitacion);
    }

    @Override
    public TipoHabitacion actualizarTipoHabitacion(TipoHabitacion tipoHabitacion) {
        return tipoHabitacionRepository.save(tipoHabitacion);
    }

    @Override
    public Set<TipoHabitacion> obtenerTipoHabitaciones() {
        return new LinkedHashSet<>(tipoHabitacionRepository.findAll());
    }

    @Override
    public TipoHabitacion obtenerTipoHabitacion(Long tipoHabitacionId) {
        return tipoHabitacionRepository.findById(tipoHabitacionId).get();
    }

    @Override
    public void eliminarTipoHabitacion(Long tipoHabitacionId) {
        TipoHabitacion tipoHabitacion = obtenerTipoHabitacion(tipoHabitacionId);
        if (tipoHabitacion != null){
            tipoHabitacionRepository.delete(tipoHabitacion);
        }
    }
}
