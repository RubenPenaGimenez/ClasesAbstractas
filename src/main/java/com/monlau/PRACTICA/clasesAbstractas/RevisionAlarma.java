package com.monlau.PRACTICA.clasesAbstractas;

import java.time.LocalDate;

public class RevisionAlarma extends Servicio {

    private int numeroAlarmas;

    public RevisionAlarma(LocalDate fechaInicio, String cliente, int numeroAlarmas) {
        super("Revisor Especialista Contraincendios", fechaInicio, cliente);
        this.numeroAlarmas = numeroAlarmas;
    }

    public int getNumeroAlarmas() {
        return numeroAlarmas;
    }

    public void setNumeroAlarmas(int numeroAlarmas) {
        this.numeroAlarmas = numeroAlarmas;
    }

    @Override
    public double costeMaterial() {
        return 0;
    }

    @Override
    public double costeManoObra() {
        return (numeroAlarmas / 3.0) * 40.0;
    }

    @Override
    public double costeTotal() {
        return costeManoObra();
    }

    @Override
    public String detalleServicio() {
        return "REVISION PERIODICA ALARMAS CONTRAINCENDIOS\n"
                + "Cliente: " + getCliente() + "\n"
                + "Fecha revisión: " + getFechaInicio() + "\n"
                + "TOTAL: ....... " + costeTotal();
    }
}
