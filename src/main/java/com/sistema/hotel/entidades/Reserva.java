package com.sistema.hotel.entidades;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservaId;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaFin;

    private float costoTotal;

    private EstadoReserva estadoReserva;

    @ManyToOne(fetch = FetchType.EAGER)
    private Habitacion habitacion;

    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public EstadoReserva getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(EstadoReserva estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public Reserva() {
    }
}
