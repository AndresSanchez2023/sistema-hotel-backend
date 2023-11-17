package com.sistema.hotel.repositorios;

import com.sistema.hotel.entidades.Habitacion;
import com.sistema.hotel.entidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ReservaRepository extends JpaRepository <Reserva, Long> {

    Set<Reserva> findByHabitacion(Habitacion habitacion);
}
