package com.sistema.hotel.controladores;

import com.sistema.hotel.entidades.EstadoHabitacion;
import com.sistema.hotel.entidades.Habitacion;
import com.sistema.hotel.servicios.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habitacion")
@CrossOrigin("*")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @PostMapping("/")
    public ResponseEntity<Habitacion> guardarHabitacion(@RequestBody Habitacion habitacion){
        return ResponseEntity.ok(habitacionService.agregarHabitacion(habitacion));
    }

    @PutMapping("/")
    public ResponseEntity<Habitacion> actualizarHabitacion(@RequestBody Habitacion habitacion){
        return ResponseEntity.ok(habitacionService.actualizarHabitacion(habitacion));
    }

    @GetMapping("/")
        public ResponseEntity<?> listarHabitaciones(){
            return ResponseEntity.ok(habitacionService.obtenerHabitaciones());
    }

    @GetMapping("/{habitacionId}")
    public Habitacion listarHabitacion(@PathVariable ("habitacionId")Long habitacionId) {
    return habitacionService.obtenerHabitacion(habitacionId);
    }

    @GetMapping("/estados")
    public EstadoHabitacion[] getEstadosHabitacion(){
        return EstadoHabitacion.values();
    }

    @DeleteMapping("/{habitacionId}")
    public void eliminarHabitacion(@PathVariable ("habitacionId")Long habitacionId){
        habitacionService.eliminarHabitacion(habitacionId);
    }
}
