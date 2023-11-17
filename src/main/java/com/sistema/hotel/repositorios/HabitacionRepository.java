package com.sistema.hotel.repositorios;

import com.sistema.hotel.entidades.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
}
