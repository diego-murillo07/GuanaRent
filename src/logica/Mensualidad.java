/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa el pago mensual de un alquiler. Genera y almacena
 * automáticamente cada cuota mensual, incluyendo monto, descuento, período y
 * estado de pago.
 *
 * @author Erry
 *
 */
public class Mensualidad {

    /**
     * Número secuencial que identifica esta mensualidad
     */
    private int consecutivo;

    /**
     * Número del contrato de alquiler al que pertenece
     */
    private int numAlquiler;

    /**
     * Fecha en que se generó esta mensualidad
     */
    private LocalDate fechCreacion;

    /**
     * Nombre del inquilino responsable del pago
     */
    private String nomInquilino;

    /**
     * Mes que corresponde este pago (1-12)
     */
    private int mesCobro;

    /**
     * Año al que corresponde este pago
     */
    private int anioActual;

    /**
     * Porcentaje de descuento aplicado al monto
     */
    private double descuento;

    /**
     * Monto total a pagar después de aplicar el descuento
     */
    private double montoMes;

    /**
     * Estado del pago: Pendiente / Cancelado
     */
    private String estado;

    /**
     * Constructor que inicializa todos los datos de una mensualidad.
     *
     * @param consecutivo Número secuencial único de esta mensualidad
     * @param numAlquiler Número del contrato de alquiler asociado
     * @param fechCreacion Fecha de generación de la mensualidad
     * @param nomInquilino Nombre del inquilino que debe pagar
     * @param mesCobro Mes que corresponde este pago (1-12)
     * @param anioActual Año al que corresponde este pago
     * @param descuento Porcentaje de descuento a aplicar
     * @param montoMes Monto mensual antes de descuento
     * @param estado Estado actual: Pendiente o Cancelado
     */
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
    /**
     * Obtiene el número secuencial de esta mensualidad.
     *
     * @return Número consecutivo
     */
    public int getConsecutivo() {
        return consecutivo;
    }

    /**
     * Asigna el número secuencial de esta mensualidad.
     *
     * @param consecutivo Número a asignar
     */
    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    /**
     * Obtiene el número de contrato de alquiler asociado.
     *
     * @return Número de alquiler
     */
    public int getNumAlquiler() {
        return numAlquiler;
    }

    /**
     * Asigna el número de contrato de alquiler asociado.
     *
     * @param numAlquiler Número a asignar
     */
    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    /**
     * Obtiene la fecha en que se generó la mensualidad.
     *
     * @return Fecha de creación
     */
    public LocalDate getFechCreacion() {
        return fechCreacion;
    }

    /**
     * Asigna la fecha de generación de la mensualidad.
     *
     * @param fechCreacion Fecha a asignar
     */
    public void setFechCreacion(LocalDate fechCreacion) {
        this.fechCreacion = fechCreacion;
    }

    /**
     * Obtiene el nombre del inquilino responsable del pago.
     *
     * @return Nombre del inquilino
     */
    public String getNomInquilino() {
        return nomInquilino;
    }

    /**
     * Asigna el nombre del inquilino responsable del pago.
     *
     * @param nomInquilino Nombre a asignar
     */
    public void setNomInquilino(String nomInquilino) {
        this.nomInquilino = nomInquilino;
    }

    /**
     * Obtiene el mes que corresponde este pago.
     *
     * @return Número de mes (1-12)
     */
    public int getMesCobro() {
        return mesCobro;
    }

    /**
     * Asigna el mes que corresponde este pago.
     *
     * @param mesCobro Número de mes (1-12)
     */
    public void setMesCobro(int mesCobro) {
        this.mesCobro = mesCobro;
    }

    /**
     * Obtiene el año al que corresponde este pago.
     *
     * @return Año
     */
    public int getAnioActual() {
        return anioActual;
    }

    /**
     * Asigna el año al que corresponde este pago.
     *
     * @param anioActual Año a asignar
     */
    public void setAnioActual(int anioActual) {
        this.anioActual = anioActual;
    }

    /**
     * Obtiene el porcentaje de descuento aplicado.
     *
     * @return Porcentaje de descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * Asigna el porcentaje de descuento a aplicar.
     *
     * @param descuento Porcentaje de descuento
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * Obtiene el monto mensual a pagar.
     *
     * @return Monto mensual
     */
    public double getMontoMes() {
        return montoMes;
    }

    /**
     * Asigna el monto mensual a pagar.
     *
     * @param montoMes Monto mensual
     */
    public void setMontoMes(double montoMes) {
        this.montoMes = montoMes;
    }

    /**
     * Obtiene el estado actual de la mensualidad.
     *
     * @return Estado: Pendiente / Cancelado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Asigna el estado de la mensualidad.
     *
     * @param estado Estado: Pendiente / Cancelado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // MÉTODOS SOBREESCRITOS 
    /**
     * Compara dos mensualidades para verificar si son iguales. Se considera
     * igual si tienen el mismo número consecutivo.
     *
     * @param o Objeto con el que se compara
     * @return true si tienen el mismo consecutivo, false en caso contrario
     */
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

    /**
     * Genera un código hash basado en el número consecutivo.
     *
     * @return Código hash calculado
     */
    @Override
    public int hashCode() {
        return Objects.hash(consecutivo);
    }
}
