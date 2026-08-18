/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa al inquilino que alquila viviendas. Almacena los datos
 * personales, de contacto y situación laboral de la persona que solicita o
 * tiene un contrato de alquiler.
 *
 * @author Erry
 *
 */
public class Inquilino {

    /**
     * Número de identificación (cédula) del inquilino
     */
    private String cedInqui;

    /**
     * Nombre completo del inquilino
     */
    private String nomInqui;

    /**
     * Género del inquilino
     */
    private String genero;

    /**
     * Fecha de nacimiento del inquilino
     */
    private LocalDate fechNac;

    /**
     * Dirección de residencia del inquilino
     */
    private String direccion;

    /**
     * Número de teléfono del inquilino
     */
    private String telefono;

    /**
     * Correo electrónico del inquilino
     */
    private String email;

    /**
     * Ocupación o trabajo del inquilino
     */
    private String ocupacion;

    
    /**
     * Constructor que inicializa todos los datos de un inquilino.
     * 
     * @param cedInqui   Número de identificación (cédula)
     * @param nomInqui   Nombre completo
     * @param genero     Género
     * @param fechNac    Fecha de nacimiento
     * @param direccion  Dirección de residencia
     * @param telefono   Número de teléfono
     * @param email      Correo electrónico
     * @param ocupacion  Ocupación o trabajo
     */
    public Inquilino(String cedInqui, String nomInqui, String genero, LocalDate fechNac,
            String direccion, String telefono, String email, String ocupacion) {
        this.cedInqui = cedInqui;
        this.nomInqui = nomInqui;
        this.genero = genero;
        this.fechNac = fechNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.ocupacion = ocupacion;
    }

    // ===== GET/SET =====
    
     /**
     * Obtiene el número de identificación del inquilino.
     * @return Cédula del inquilino
     */
    public String getCedInqui() {
        return cedInqui;
    }

     /**
     * Asigna el número de identificación del inquilino.
     * @param cedInqui Cédula a asignar
     */
    public void setCedInqui(String cedInqui) {
        this.cedInqui = cedInqui;
    }

     /**
     * Obtiene el nombre completo del inquilino.
     * @return Nombre del inquilino
     */
    public String getNomInqui() {
        return nomInqui;
    }

     /**
     * Asigna el nombre completo del inquilino.
     * @param nomInqui Nombre a asignar
     */
    public void setNomInqui(String nomInqui) {
        this.nomInqui = nomInqui;
    }

    /**
     * Obtiene el género del inquilino.
     * @return Género del inquilino
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Asigna el género del inquilino.
     * @param genero Género a asignar
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

      /**
     * Obtiene la fecha de nacimiento del inquilino.
     * @return Fecha de nacimiento
     */
    public LocalDate getFechNac() {
        return fechNac;
    }

     /**
     * Asigna la fecha de nacimiento del inquilino.
     * @param fechNac Fecha de nacimiento a asignar
     */
    public void setFechNac(LocalDate fechNac) {
        this.fechNac = fechNac;
    }

     /**
     * Obtiene la dirección de residencia del inquilino.
     * @return Dirección del inquilino
     */
    public String getDireccion() {
        return direccion;
    }

     /**
     * Asigna la dirección de residencia del inquilino.
     * @param direccion Dirección a asignar
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el número de teléfono del inquilino.
     * @return Teléfono del inquilino
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Asigna el número de teléfono del inquilino.
     * @param telefono Teléfono a asignar
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del inquilino.
     * @return Correo electrónico
     */
    public String getEmail() {
        return email;
    }

    /**
     * Asigna el correo electrónico del inquilino.
     * @param email Correo a asignar
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la ocupación o trabajo del inquilino.
     * @return Ocupación del inquilino
     */
    public String getOcupacion() {
        return ocupacion;
    }

     /**
     * Asigna la ocupación o trabajo del inquilino.
     * @param ocupacion Ocupación a asignar
     */
    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    //  MÉTODOS SOBREESCRITOS 

    /**
     * Compara dos objetos Inquilino para verificar si son iguales.
     * Se considera igual si tienen la misma cédula.
     * 
     * @param o Objeto con el que se compara
     * @return  true si tienen la misma cédula, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Inquilino inquilino = (Inquilino) o;
        return Objects.equals(cedInqui, inquilino.cedInqui);
    }

    /**
     * Genera  un código hash basado en la cédula inquilino
     * @return código hash calculado
     */
    @Override
    public int hashCode() {
        return Objects.hash(cedInqui);
    }

    /**
     * Devuelve una representación en texto del inquilino.
     * Muestra la cédula y el nombre completo
     * @return Cadena con los datos identificativos del inquilino
     */
    @Override
    public String toString() {
        return "Cédula: " + cedInqui + " | Nombre: " + nomInqui;
    }
}
