package com.monlau.PRACTICA.clasesAbstractas;

import java.time.LocalDate;

public class TrabajoPintura extends Servicio {

    private double superficie;
    private double precioPintura;

    public TrabajoPintura(String trabajador, LocalDate fechaInicio, String cliente,
            double superficie, double precioPintura) {
        super(trabajador, fechaInicio, cliente);
        this.superficie = superficie;
        this.precioPintura = precioPintura;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie) {
        this.superficie = superficie;
    }

    public double getPrecioPintura() {
        return precioPintura;
    }

    public void setPrecioPintura(double precioPintura) {
        this.precioPintura = precioPintura;
    }

    @Override
    public double costeMaterial() {
        double costeMaterial = (superficie / 7.8) * precioPintura;
        if (superficie < 50) {
            costeMaterial += costeMaterial * 0.15;
        }
        return costeMaterial;
    }

    @Override
    public double costeManoObra() {
        double costeManoObra = (superficie / 10) * 9.5;
        if (superficie < 50) {
            costeManoObra += costeManoObra * 0.15;
        }
        return costeManoObra;
    }

    @Override
    public double costeTotal() {
        double costeMaterial = costeMaterial();
        double costeManoObra = costeManoObra();
        return costeMaterial + costeManoObra;
    }

    @Override
    public String detalleServicio() {
        double costeMaterial = costeMaterial();
        double costeManoObra = costeManoObra();
        double costeAdicional = 0;
        if (superficie < 50) {
            costeAdicional = (costeMaterial + costeManoObra) * 0.15;
        }
        double total = costeMaterial + costeManoObra + costeAdicional;

        StringBuilder sb = new StringBuilder();
        sb.append("TRABAJO DE PINTURA\n");
        sb.append("Cliente: ").append(getCliente()).append("\n");
        sb.append("Fecha de inicio: ").append(getFechaInicio()).append("\n");
        sb.append("Pintor: ").append(getTrabajador()).append("\n");
        sb.append("Coste Material..... ").append(costeMaterial).append("\n");
        sb.append("Coste Mano Obra.... ").append(costeManoObra).append("\n");
        if (costeAdicional > 0) {
            sb.append("Coste Adicional.... ").append(costeAdicional).append("\n");
        }
        sb.append("TOTAL: ............ ").append(total).append("\n");
        return sb.toString();
    }
}
