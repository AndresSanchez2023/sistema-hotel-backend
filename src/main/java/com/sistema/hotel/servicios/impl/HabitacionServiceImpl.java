package com.sistema.hotel.servicios.impl;

import com.sistema.hotel.entidades.Habitacion;
import com.sistema.hotel.repositorios.HabitacionRepository;
import com.sistema.hotel.servicios.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class HabitacionServiceImpl implements HabitacionService {

    @Autowired
    private HabitacionRepository habitacionRepository;

    @Override
    public Habitacion agregarHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    @Override
    public Habitacion actualizarHabitacion(Habitacion habitacion) {
        return habitacionRepository.save(habitacion);
    }

    @Override
    public Set<Habitacion> obtenerHabitaciones() {
        return new LinkedHashSet<>(habitacionRepository.findAll());
    }

    @Override
    public Habitacion obtenerHabitacion(Long habitacionId) {
        return habitacionRepository.findById(habitacionId).get();
    }

    @Override
    public void eliminarHabitacion(Long habitacionId) {
        Habitacion habitacion = obtenerHabitacion(habitacionId);
        if (habitacion != null) {
            habitacionRepository.delete(habitacion);
        }
    }
}
