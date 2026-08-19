/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Objects;

/**
 * Clase que representa al propietario de una o más viviendas. Almacena los
 * datos personales, de contacto e identificación de la persona dueña de las
 * propiedades que se ponen en alquiler.
 *
 * @author Erry
 *
 */
public class Propietario {

    /**
     * Número de identificación (cédula) del propietario
     */
    private String cedPropiet;

    /**
     * Nombre completo del propietario
     */
    private String nomPropiet;

    /**
     * Género del propietario
     */
    private String genero;

    /**
     * Dirección de residencia del propietario
     */
    private String direccion;

    /**
     * Número de teléfono del propietario
     */
    private String telefono;

    /**
     * Correo electrónico del propietario
     */
    private String email;


    /**
     * Constructor que inicializa todos los datos de un propietario.
     *
     * @param cedPropiet Número de identificación (cédula)
     * @param nomPropiet Nombre completo del propietario
     * @param genero Género del propietario
     * @param direccion Dirección de residencia
     * @param telefono Número de teléfono
     * @param email Correo electrónico
     */
    public Propietario(String cedPropiet, String nomPropiet, String genero,
            String direccion, String telefono, String email) {
        this.cedPropiet = cedPropiet;
        this.nomPropiet = nomPropiet;
        this.genero = genero;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    // ====== GET / SET ======
    /**
     * Obtiene el número de identificación del propietario.
     *
     * @return Cédula del propietario
     */
    public String getCedPropiet() {
        return cedPropiet;
    }

    /**
     * Asigna el número de identificación del propietario.
     *
     * @param cedPropiet Cédula a asignar
     */
    public void setCedPropiet(String cedPropiet) {
        this.cedPropiet = cedPropiet;
    }

    /**
     * Obtiene el nombre completo del propietario.
     *
     * @return Nombre del propietario
     */
    public String getNomPropiet() {
        return nomPropiet;
    }

    /**
     * Asigna el nombre completo del propietario.
     *
     * @param nomPropiet Nombre a asignar
     */
    public void setNomPropiet(String nomPropiet) {
        this.nomPropiet = nomPropiet;
    }

    /**
     * Obtiene el género del propietario.
     *
     * @return Género del propietario
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Asigna el género del propietario.
     *
     * @param genero Género a asignar
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Obtiene la dirección de residencia del propietario.
     *
     * @return Dirección del propietario
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Asigna la dirección de residencia del propietario.
     *
     * @param direccion Dirección a asignar
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el número de teléfono del propietario.
     *
     * @return Teléfono del propietario
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Asigna el número de teléfono del propietario.
     *
     * @param telefono Teléfono a asignar
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene el correo electrónico del propietario.
     *
     * @return Correo electrónico
     */
    public String getEmail() {
        return email;
    }

    /**
     * Asigna el correo electrónico del propietario.
     *
     * @param email Correo a asignar
     */
    public void setEmail(String email) {
        this.email = email;
    }

    // MÉTODOS SOBREESCRITOS
    /**
     * Compara dos objetos Propietario para verificar si son iguales. Se
     * considera igual si tienen la misma cédula (identificador único).
     *
     * @param o Objeto con el que se compara
     * @return true si tienen la misma cédula, false en caso contrario
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Propietario that = (Propietario) o;
        return Objects.equals(cedPropiet, that.cedPropiet);
    }

    /**
     * Genera un código hash basado en la cédula del propietario.
     *
     * @return Código hash calculado a partir de la cédula
     */
    @Override
    public int hashCode() {
        return Objects.hash(cedPropiet);
    }

    /**
     * Devuelve una representación en texto del propietario. Muestra la cédula y
     * el nombre completo para identificarlo fácilmente.
     *
     * @return Cadena con cédula y nombre del propietario
     */
    @Override
    public String toString() {
        return "Cédula: " + cedPropiet + " | Nombre: " + nomPropiet;
    }
}
