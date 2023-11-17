package com.sistema.hotel.controladores;

import com.sistema.hotel.entidades.TipoHabitacion;
import com.sistema.hotel.servicios.TipoHabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tipoHabitacion")
@CrossOrigin("*")
public class TipoHabitacionController {

    @Autowired
    private TipoHabitacionService tipoHabitacionService;

    @PostMapping("/")
    public ResponseEntity<TipoHabitacion> guardarTipoHabitacion(@RequestBody TipoHabitacion tipoHabitacion){
        TipoHabitacion tipoHabitacionGuardado = tipoHabitacionService.agregarTipoHabitacion(tipoHabitacion);
        return ResponseEntity.ok(tipoHabitacionGuardado);
    }

    @GetMapping("/{tipoHabitacionId}")
    public ResponseEntity<?> listarTipoHabitacionPorId(@PathVariable("tipoHabitacionId") Long tipoHabitacionId){
        return ResponseEntity.ok(tipoHabitacionService.obtenerTipoHabitacion(tipoHabitacionId));
    }

    @GetMapping("/")
    public ResponseEntity<?> listarTipoHabitaciones(){
        return ResponseEntity.ok(tipoHabitacionService.obtenerTipoHabitaciones());
    }

    @PutMapping("/")
    public TipoHabitacion actualizarTipoHabitacion(@RequestBody TipoHabitacion tipoHabitacion){
        return tipoHabitacionService.actualizarTipoHabitacion(tipoHabitacion);
    }

    @DeleteMapping("/{tipoHabitacionId}")
    public void eliminarTipoHabitacion(@PathVariable("tipoHabitacionId") Long tipoHabitacionId){
        tipoHabitacionService.eliminarTipoHabitacion(tipoHabitacionId);
    }
}
