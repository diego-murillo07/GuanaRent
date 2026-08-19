/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que registra contratos de alquiler
 *
 * @author Erry
 */
public class Alquiler {

    /**
     * Número identificador único del contrato de alquiler
     */
    private int numAlquiler;

    /**
     * Fecha en la que se firma o inicia el contrato
     */
    private LocalDate fechContrato;

    /**
     * Duración del contrato expresada en meses
     */
    private int cantMeses;

    /**
     * Cantidad de adultos que habitarán la vivienda
     */
    private int numAdultos;

    /**
     * Cantidad de niños que habitarán la vivienda
     */
    private int numNinos;

    /**
     * Monto entregado como garantía al firmar el contrato
     */
    private double depositoGarantia;

    /**
     * Valor mensual pactado por el alquiler de la vivienda
     */
    private double precioAlquiler;

    /**
     * Porcentaje de incremento anual del alquiler (rango: 1% a 30%)
     */
    private double porcIncremAnual;

    /**
     * Inquilino que firma el contrato y habitará la vivienda
     */
    private Inquilino inquilino;

    /**
     * Vivienda que se está alquilando en este contrato
     */
    private Vivienda vivienda;

    /**
     * Estado del contrato: Vigente / Vencido / Cancelado
     */
    private String estado;

    /**
     * Constructor completo para crear una instancia de Alquiler.
     *
     * @param numAlquiler Número identificador único del alquiler.
     * @param fechContrato Fecha en la que se firma el contrato.
     * @param cantMeses Duración del contrato en meses.
     * @param numAdultos Cantidad de adultos que habitarán la vivienda.
     * @param numNinos Cantidad de niños que habitarán la vivienda.
     * @param depositoGarantia Monto asignado como depósito de garantía.
     * @param precioAlquiler Monto mensual del alquiler.
     * @param porcIncremAnual Porcentaje de incremento anual (1-30%).
     * @param inquilino Objeto Inquilino asociado al contrato.
     * @param vivienda Objeto Vivienda alquilada.
     * @param estado Estado actual del contrato (Vigente / Vencido / Cancelado).
     */
    public Alquiler(int numAlquiler, LocalDate fechContrato, int cantMeses, int numAdultos, int numNinos,
            double depositoGarantia, double precioAlquiler, double porcIncremAnual,
            Inquilino inquilino, Vivienda vivienda, String estado) {
        this.numAlquiler = numAlquiler;
        this.fechContrato = fechContrato;
        this.cantMeses = cantMeses;
        this.numAdultos = numAdultos;
        this.numNinos = numNinos;
        this.depositoGarantia = depositoGarantia;
        this.precioAlquiler = precioAlquiler;
        this.porcIncremAnual = porcIncremAnual;
        this.inquilino = inquilino;
        this.vivienda = vivienda;
        this.estado = estado;
    }

    // GET/SET 
    /**
     * Obtiene el número identificador del alquiler.
     *
     * @return Número de alquiler.
     */
    public int getNumAlquiler() {
        return numAlquiler;
    }

    /**
     * Establece el número identificador del alquiler.
     *
     * @param numAlquiler Número de alquiler a asignar.
     */
    public void setNumAlquiler(int numAlquiler) {
        this.numAlquiler = numAlquiler;
    }

    /**
     * Obtiene la fecha de firma del contrato.
     *
     * @return Fecha del contrato.
     */
    public LocalDate getFechContrato() {
        return fechContrato;
    }

    /**
     * Establece la fecha de firma del contrato.
     *
     * @param fechContrato Fecha del contrato a asignar.
     */
    public void setFechContrato(LocalDate fechContrato) {
        this.fechContrato = fechContrato;
    }

    /**
     * Obtiene la duración en meses del contrato.
     *
     * @return Cantidad de meses.
     */
    public int getCantMeses() {
        return cantMeses;
    }

    /**
     * Establece la duración en meses del contrato.
     *
     * @param cantMeses Cantidad de meses a asignar.
     */
    public void setCantMeses(int cantMeses) {
        this.cantMeses = cantMeses;
    }

    /**
     * Obtiene el número de adultos registrados en el contrato.
     *
     * @return Cantidad de adultos.
     */
    public int getNumAdultos() {
        return numAdultos;
    }

    /**
     * Establece el número de adultos registrados en el contrato.
     *
     * @param numAdultos Cantidad de adultos a asignar.
     */
    public void setNumAdultos(int numAdultos) {
        this.numAdultos = numAdultos;
    }

    /**
     * Obtiene el número de niños registrados en el contrato.
     *
     * @return Cantidad de niños.
     */
    public int getNumNinos() {
        return numNinos;
    }

    /**
     * Establece el número de niños registrados en el contrato.
     *
     * @param numNinos Cantidad de niños a asignar.
     */
    public void setNumNinos(int numNinos) {
        this.numNinos = numNinos;
    }

    /**
     * Obtiene el monto del depósito de garantía.
     *
     * @return Monto del depósito de garantía.
     */
    public double getDepositoGarantia() {
        return depositoGarantia;
    }

    /**
     * Establece el monto del depósito de garantía.
     *
     * @param depositoGarantia Monto del depósito a asignar.
     */
    public void setDepositoGarantia(double depositoGarantia) {
        this.depositoGarantia = depositoGarantia;
    }

    /**
     * Obtiene el precio mensual del alquiler.
     *
     * @return Precio del alquiler.
     */
    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    /**
     * Establece el precio mensual del alquiler.
     *
     * @param precioAlquiler Precio del alquiler a asignar.
     */
    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    /**
     * Obtiene el porcentaje de incremento anual aplicable.
     *
     * @return Porcentaje de incremento anual.
     */
    public double getPorcIncremAnual() {
        return porcIncremAnual;
    }

    /**
     * Establece el porcentaje de incremento anual aplicable (1-30%).
     *
     * @param porcIncremAnual Porcentaje de incremento a asignar.
     */
    public void setPorcIncremAnual(double porcIncremAnual) {
        this.porcIncremAnual = porcIncremAnual;
    }

    /**
     * Obtiene el inquilino asociado al contrato.
     *
     * @return Objeto Inquilino.
     */
    public Inquilino getInquilino() {
        return inquilino;
    }

    /**
     * Establece el inquilino asociado al contrato.
     *
     * @param inquilino Objeto Inquilino a asignar.
     */
    public void setInquilino(Inquilino inquilino) {
        this.inquilino = inquilino;
    }

    /**
     * Obtiene la vivienda asociada al contrato.
     *
     * @return Objeto Vivienda.
     */
    public Vivienda getVivienda() {
        return vivienda;
    }

    /**
     * Establece la vivienda asociada al contrato.
     *
     * @param vivienda Objeto Vivienda a asignar.
     */
    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    /**
     * Obtiene el estado actual del contrato.
     *
     * @return Estado del alquiler (Vigente / Vencido / Cancelado).
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Establece el estado del contrato.
     *
     * @param estado Estado a asignar (Vigente / Vencido / Cancelado).
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Compara si este contrato es igual a otro objeto basándose en el número de
     * alquiler.
     *
     * @param o Objeto a comparar.
     * @return {@code true} si los números de alquiler coinciden; {@code false}
     * en caso contrario.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Alquiler alquiler = (Alquiler) o;
        return numAlquiler == alquiler.numAlquiler;
    }

    /**
     * Genera un valor hash para el objeto basándose en el número de alquiler.
     *
     * @return Código hash generado.
     */
    @Override
    public int hashCode() {
        return Objects.hash(numAlquiler);
    }
}
