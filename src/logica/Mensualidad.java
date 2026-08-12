/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que genera y almacena pagos mensuales automáticos
 *
 * @author Erry
 */
public class Mensualidad {

    private int consecutivo;
    private int numAlquiler;
    private LocalDate fechCreacion;
    private String nomInquilino;
    private int mesCobro;
    private int anioActual;
    private double descuento;
    private double montoMes;
    private String estado; // Pendiente / Cancelado

    public Mensualidad(int consecutivo, int numAlquiler, LocalDate fechCreacion, String nomInquilino,
            int mesCobro, int anioActual, double descuento, double montoMes, String estado) {
        this.consecutivo = consecutivo;
        this.numAlquiler = numAlquiler;
        this.fechCreacion = fechCreacion;
        this.nomInquilino = nomInquilino;
        this.mesCobro = mesCobro;
        this.anioActual = anioActual;
        this.descuento = descuento;
        this.montoMes = montoMes;
        this.estado = estado;
    }

    //GETT/SETT 
    public int getConsecutivo() {
        return consecutivo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public int getNumAlquiler() {
        return numAlquiler;
    }

    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    public LocalDate getFechCreacion() {
        return fechCreacion;
    }

    public void setFechCreacion(LocalDate fechCreacion) {
        this.fechCreacion = fechCreacion;
    }

    public String getNomInquilino() {
        return nomInquilino;
    }

    public void setNomInquilino(String nomInquilino) {
        this.nomInquilino = nomInquilino;
    }

    public int getMesCobro() {
        return mesCobro;
    }

    public void setMesCobro(int mesCobro) {
        this.mesCobro = mesCobro;
    }

    public int getAnioActual() {
        return anioActual;
    }

    public void setAnioActual(int anioActual) {
        this.anioActual = anioActual;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getMontoMes() {
        return montoMes;
    }

    public void setMontoMes(double montoMes) {
        this.montoMes = montoMes;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mensualidad that = (Mensualidad) o;
        return consecutivo == that.consecutivo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(consecutivo);
    }
}
