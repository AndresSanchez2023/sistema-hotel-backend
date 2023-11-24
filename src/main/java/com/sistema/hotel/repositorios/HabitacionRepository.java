package com.sistema.hotel.repositorios;

import com.sistema.hotel.entidades.Habitacion;
import com.sistema.hotel.entidades.TipoHabitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {

    @Query("SELECT h FROM Habitacion h WHERE h.tipoHabitacion.tipoHabitacionId = :tipoHabitacionId AND " +
            "(h.estadoHabitacion = 'DISPONIBLE' OR " +
            "(h.estadoHabitacion = 'RESERVADA' AND NOT EXISTS " +
            "(SELECT r FROM Reserva r WHERE r.habitacion.habitacionId = h.habitacionId AND " +
            "r.fechaInicio < :fechaFin AND r.fechaFin > :fechaInicio AND r.fechaInicio >= CURRENT_DATE)))")
    List<Habitacion> findDisponiblesByTipoYFechas(Long tipoHabitacionId, Date fechaInicio, Date fechaFin);
}
