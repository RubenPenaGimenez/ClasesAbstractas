package com.monlau.PRACTICA.clasesAbstractas;

import java.time.LocalDate;

public abstract class Servicio {

    private String trabajador;
    private LocalDate fechaInicio;
    private String cliente;

    public Servicio(String trabajador, LocalDate fechaInicio, String cliente) {
        this.trabajador = trabajador;
        this.fechaInicio = fechaInicio;
        this.cliente = cliente;
    }

    public String getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(String trabajador) {
        this.trabajador = trabajador;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public abstract double costeMaterial();

    public abstract double costeManoObra();

    public double costeTotal() {
        return costeMaterial() + costeManoObra();
    }

    public String detalleServicio() {
        return "Servicio realizado por: " + trabajador + "\n"
                + "Fecha de inicio: " + fechaInicio + "\n"
                + "Cliente: " + cliente + "\n"
                + "Coste de material: " + costeMaterial() + "\n"
                + "Coste de mano de obra: " + costeManoObra() + "\n"
                + "Coste total del servicio: " + costeTotal();
    }
}
