package com.sistema.hotel.controladores;

import com.sistema.hotel.entidades.Habitacion;
import com.sistema.hotel.entidades.Reserva;
import com.sistema.hotel.servicios.HabitacionService;
import com.sistema.hotel.servicios.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/reserva")
@CrossOrigin("*")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private HabitacionService habitacionService;

    @PostMapping("/")
    public ResponseEntity<Reserva> guardarReserva(@RequestBody Reserva reserva){
        return ResponseEntity.ok(reservaService.agregarReserva(reserva));
    }

    @PutMapping("/")
    public ResponseEntity<Reserva> actualizarReserva(@RequestBody Reserva reserva){
        return ResponseEntity.ok(reservaService.actualizarReserva(reserva));
    }

    @GetMapping("/habitacion/{habitacionId}")
    public ResponseEntity<Set<Reserva>> listarReservasDeHabitacion(@PathVariable ("habitacionId") Long habitacionId){
        Habitacion habitacion = habitacionService.obtenerHabitacion(habitacionId);
        if (habitacion == null){
            return ResponseEntity.notFound().build();
        }
        Set<Reserva> reservas = habitacion.getReservasHabitacion();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("/{reservaId}")
    public Reserva listarReservaPorId(@PathVariable("reservaId")Long reservaId){
        return reservaService.obtenerReserva(reservaId);
    }

    @DeleteMapping("/{reservaId}")
    public void eliminarReserva(@PathVariable ("reservaId")Long reservaId){
        reservaService.eliminarReserva(reservaId);
    }
}
