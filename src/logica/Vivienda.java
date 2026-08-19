/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Objects;

/**
 * Clase que modela cada vivienda disponible, alquilada o inactiva. Almacena los
 * datos de identificación, ubicación, características físicas, costos,
 * propietario y estado de la propiedad.
 *
 * @author Erry
 * @version 1.0
 */
public class Vivienda {

    /**
     * Código único que identifica a cada vivienda
     */
    private String idVivienda;

    /**
     * Descripción general de la vivienda
     */
    private String descripcion;

    /**
     * Dirección completa de ubicación de la vivienda
     */
    private String direccion;

    /**
     * Metros cuadrados de construcción de la vivienda
     */
    private double mtsConstruct;

    /**
     * Metros cuadrados del terreno o lote
     */
    private double mtsLote;

    /**
     * Tipo de material o estilo de construcción
     */
    private String tipoConstruccion;

    /**
     * Indica si la vivienda cuenta con espacio para vehículos
     */
    private boolean cochera;

    /**
     * Cantidad de habitaciones que tiene la vivienda
     */
    private int cantHabitac;

    /**
     * Cantidad de baños completos y medios baños
     */
    private double cantBanios;

    /**
     * Tipo de vía de acceso principal a la propiedad
     */
    private String carretera;

    /**
     * Precio base mensual de alquiler sin incluir recargos
     */
    private double precioBase;

    /**
     * Monto que se paga como garantía al iniciar el contrato
     */
    private double depositoGarantia;

    /**
     * Dueño legal de la vivienda (relación con clase Propietario)
     */
    private Propietario propietario;

    /**
     * Estado actual: Disponible / Alquilada / Inactiva
     */
    private String estado;

    /**
     * Constructor que inicializa todos los datos de una vivienda.
     *
     * @param idVivienda Código único de identificación
     * @param descripcion Descripción general de la propiedad
     * @param direccion Dirección completa de ubicación
     * @param mtsConstruct Metros cuadrados de construcción
     * @param mtsLote Metros cuadrados del terreno
     * @param tipoConstruccion Tipo de material o construcción
     * @param cochera Indica si cuenta con cochera
     * @param cantHabitac Cantidad de habitaciones
     * @param cantBanios Cantidad de baños
     * @param carretera Tipo de vía de acceso
     * @param precioBase Precio base mensual de alquiler
     * @param depositoGarantia Monto del depósito de garantía
     * @param propietario Dueño de la vivienda
     * @param estado Estado actual: Disponible / Alquilada / Inactiva
     */
    public Vivienda(String idVivienda, String descripcion, String direccion, double mtsConstruct,
            double mtsLote, String tipoConstruccion, boolean cochera, int cantHabitac,
            double cantBanios, String carretera, double precioBase, double depositoGarantia,
            Propietario propietario, String estado) {
        this.idVivienda = idVivienda;
        this.descripcion = descripcion;
        this.direccion = direccion;
        this.mtsConstruct = mtsConstruct;
        this.mtsLote = mtsLote;
        this.tipoConstruccion = tipoConstruccion;
        this.cochera = cochera;
        this.cantHabitac = cantHabitac;
        this.cantBanios = cantBanios;
        this.carretera = carretera;
        this.precioBase = precioBase;
        this.depositoGarantia = depositoGarantia;
        this.propietario = propietario;
        this.estado = estado;
    }

    // ====== GET / SET ======
    /**
     * Obtiene el identificador único de la vivienda.
     *
     * @return Código de identificación
     */
    public String getIdVivienda() {
        return idVivienda;
    }

    /**
     * Asigna el identificador único de la vivienda.
     *
     * @param idVivienda Código de identificación
     */
    public void setIdVivienda(String idVivienda) {
        this.idVivienda = idVivienda;
    }

    /**
     * Obtiene la descripción de la vivienda.
     *
     * @return Descripción de la propiedad
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Asigna la descripción de la vivienda.
     *
     * @param descripcion Descripción de la propiedad
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la dirección de la vivienda.
     *
     * @return Dirección completa
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Asigna la dirección de la vivienda.
     *
     * @param direccion Dirección completa
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene los metros cuadrados de construcción.
     *
     * @return Área construida en m²
     */
    public double getMtsConstruct() {
        return mtsConstruct;
    }

    /**
     * Asigna los metros cuadrados de construcción.
     *
     * @param mtsConstruct Área construida en m²
     */
    public void setMtsConstruct(double mtsConstruct) {
        this.mtsConstruct = mtsConstruct;
    }

    /**
     * Obtiene los metros cuadrados del terreno.
     *
     * @return Área del lote en m²
     */
    public double getMtsLote() {
        return mtsLote;
    }

    /**
     * Asigna los metros cuadrados del terreno.
     *
     * @param mtsLote Área del lote en m²
     */
    public void setMtsLote(double mtsLote) {
        this.mtsLote = mtsLote;
    }

    /**
     * Obtiene el tipo de construcción de la vivienda.
     *
     * @return Tipo de material o estilo
     */
    public String getTipoConstruccion() {
        return tipoConstruccion;
    }

    /**
     * Asigna el tipo de construcción de la vivienda.
     *
     * @param tipoConstruccion Tipo de material o estilo
     */
    public void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    /**
     * Verifica si la vivienda cuenta con cochera.
     *
     * @return true si tiene cochera, false en caso contrario
     */
    public boolean isCochera() {
        return cochera;
    }

    /**
     * Asigna si la vivienda cuenta con cochera.
     *
     * @param cochera true si tiene cochera
     */
    public void setCochera(boolean cochera) {
        this.cochera = cochera;
    }

    /**
     * Obtiene la cantidad de habitaciones.
     *
     * @return Número de habitaciones
     */
    public int getCantHabitac() {
        return cantHabitac;
    }

    /**
     * Asigna la cantidad de habitaciones.
     *
     * @param cantHabitac Número de habitaciones
     */
    public void setCantHabitac(int cantHabitac) {
        this.cantHabitac = cantHabitac;
    }

    /**
     * Obtiene la cantidad de baños.
     *
     * @return Número de baños
     */
    public double getCantBanios() {
        return cantBanios;
    }

    /**
     * Asigna la cantidad de baños.
     *
     * @param cantBanios Número de baños
     */
    public void setCantBanios(double cantBanios) {
        this.cantBanios = cantBanios;
    }

    /**
     * Obtiene el tipo de vía de acceso.
     *
     * @return Nombre o tipo de carretera
     */
    public String getCarretera() {
        return carretera;
    }

    /**
     * Asigna el tipo de vía de acceso.
     *
     * @param carretera Nombre o tipo de carretera
     */
    public void setCarretera(String carretera) {
        this.carretera = carretera;
    }

    /**
     * Obtiene el precio base mensual de alquiler.
     *
     * @return Precio mensual base
     */
    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Asigna el precio base mensual de alquiler.
     *
     * @param precioBase Precio mensual base
     */
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    /**
     * Obtiene el monto del depósito de garantía.
     *
     * @return Valor del depósito
     */
    public double getDepositoGarantia() {
        return depositoGarantia;
    }

    /**
     * Asigna el monto del depósito de garantía.
     *
     * @param depositoGarantia Valor del depósito
     */
    public void setDepositoGarantia(double depositoGarantia) {
        this.depositoGarantia = depositoGarantia;
    }

    /**
     * Obtiene el dueño de la vivienda.
     *
     * @return Objeto Propietario asociado
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * Asigna el dueño de la vivienda.
     *
     * @param propietario Objeto Propietario a asociar
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    /**
     * Obtiene el estado actual de la vivienda.
     *
     * @return Estado: Disponible / Alquilada / Inactiva
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Asigna el estado actual de la vivienda.
     *
     * @param estado Estado: Disponible / Alquilada / Inactiva
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    // ====== MÉTODOS SOBREESCRITOS ======
    /**
     * Compara dos viviendas para verificar si son iguales. Se considera igual
     * si tienen el mismo identificador único.
     *
     * @param o Objeto con el que se compara
     * @return true si tienen el mismo ID, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vivienda vivienda = (Vivienda) o;
        return Objects.equals(idVivienda, vivienda.idVivienda);
    }

    /**
     * Genera un código hash basado en el identificador de la vivienda.
     *
     * @return Código hash calculado a partir del ID
     */
    @Override
    public int hashCode() {
        return Objects.hash(idVivienda);
    }
}
