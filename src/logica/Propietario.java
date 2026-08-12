/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Objects;

/**
 * Clase que representa al propietario de una o más viviendas
 *
 * @author Erry
 */
public class Propietario {

    //Atributos únicos y obligatorios
    private String cedPropiet;
    private String nomPropiet;
    private String genero;
    private String direccion;
    private String telefono;
    private String email;

    /**
     * Constructor completo
     *
     * @param cedPropiet Cédula única del propietario
     * @param nomPropiet Nombre completo
     * @param genero Masculino/Femenino
     * @param direccion Dirección residencial
     * @param telefono Número telefónico
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

    //GET Y SET
    public String getCedPropiet() {
        return cedPropiet;
    }

    public void setCedPropiet(String cedPropiet) {
        this.cedPropiet = cedPropiet;
    }

    public String getNomPropiet() {
        return nomPropiet;
    }

    public void setNomPropiet(String nomPropiet) {
        this.nomPropiet = nomPropiet;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Compara propietarios por cédula (única)
     *
     * @param o Objeto a comparar
     * @return true si misma cédula
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

    @Override
    public int hashCode() {
        return Objects.hash(cedPropiet);
    }

    @Override
    public String toString() {
        return "Cédula: " + cedPropiet + " | Nombre: " + nomPropiet;
    }
}
