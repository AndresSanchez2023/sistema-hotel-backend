package com.sistema.hotel.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long habitacionId;

    private int numHabitacion;

    @Enumerated(EnumType.STRING)
    private EstadoHabitacion estadoHabitacion;

    @ManyToOne(fetch = FetchType.EAGER)
    private TipoHabitacion tipoHabitacion;

    @OneToMany(mappedBy = "habitacion", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Reserva> reservasHabitacion = new HashSet<>();

    public Long getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(Long habitacionId) {
        this.habitacionId = habitacionId;
    }

    public int getNumHabitacion() {
        return numHabitacion;
    }

    public void setNumHabitacion(int numHabitacion) {
        this.numHabitacion = numHabitacion;
    }

    public EstadoHabitacion getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(EstadoHabitacion estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Set<Reserva> getReservasHabitacion() {
        return reservasHabitacion;
    }

    public void setReservasHabitacion(Set<Reserva> reservasHabitacion) {
        this.reservasHabitacion = reservasHabitacion;
    }

    public Habitacion() {
    }
}
