package com.sistema.hotel.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "tipo_habitacion")
public class TipoHabitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tipoHabitacionId;

    private String nombre;

    private String descripcion;

    private Byte capacidad;

    private Long precio;

    @OneToMany(mappedBy = "tipoHabitacion", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Habitacion> habitaciones = new LinkedHashSet<>();

    public Long getTipoHabitacionId() {
        return tipoHabitacionId;
    }

    public void setTipoHabitacionId(Long tipoHabitacionId) {
        this.tipoHabitacionId = tipoHabitacionId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Byte getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Byte capacidad) {
        this.capacidad = capacidad;
    }

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Set<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(Set<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }

    public TipoHabitacion() {
    }
}
