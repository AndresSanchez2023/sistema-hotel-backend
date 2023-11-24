package com.sistema.hotel.controladores;

import com.sistema.hotel.entidades.EstadoHabitacion;
import com.sistema.hotel.entidades.Habitacion;
import com.sistema.hotel.entidades.TipoHabitacion;
import com.sistema.hotel.servicios.HabitacionService;
import com.sistema.hotel.servicios.TipoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/habitacion")
@CrossOrigin("*")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;
    @Autowired
    private TipoHabitacionService tipoHabitacionService;

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

    @GetMapping("/disponibilidad")
    public ResponseEntity<?> verificarDisponibilidad(
            @RequestParam Long tipoHabitacionId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fechaFin) {
            System.out.println("Fecha de inicio: " + fechaInicio);
            System.out.println("Fecha de fin: " + fechaFin);

        Date fechaInicioDate = Date.from(fechaInicio.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaFinDate = Date.from(fechaFin.atStartOfDay(ZoneId.systemDefault()).toInstant());


        Calendar start = Calendar.getInstance();
        start.setTime(fechaInicioDate);
        Calendar end = Calendar.getInstance();
        end.setTime(fechaFinDate);

        System.out.println("Fecha de inicio: " + fechaInicio);
        System.out.println("Fecha de fin: " + fechaFin);

        int diasEstancia = 0;
        while (start.before(end)) {
            start.add(Calendar.DAY_OF_MONTH, 1);
            diasEstancia++;
        }
        if (diasEstancia <= 0) {
            return ResponseEntity.badRequest().body("La fecha de fin debe ser posterior a la fecha de inicio.");
        }

        TipoHabitacion tipoHabitacion = tipoHabitacionService.obtenerTipoHabitacion(tipoHabitacionId);
        if (tipoHabitacion == null) {
            return ResponseEntity.badRequest().body("El tipo de habitación no existe.");
        }

        List<Habitacion> habitacionesDisponibles = habitacionService.verificarDisponibilidad(fechaInicioDate, fechaFinDate, tipoHabitacionId);

        if (!habitacionesDisponibles.isEmpty()) {
            Long habitacionId = habitacionesDisponibles.get(0).getHabitacionId();
            double costoTotal = diasEstancia * tipoHabitacion.getPrecio();

            Map<String, Object> response = new HashMap<>();
            response.put("habitacionId", habitacionId);
            response.put("costoTotal", costoTotal);
            response.put("diasEstancia", diasEstancia);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay habitaciones disponibles para las fechas seleccionadas.");
        }
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
