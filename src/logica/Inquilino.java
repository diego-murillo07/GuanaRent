/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Clase que representa al inquilino que alquila viviendas
 *
 * @author Erry
 */
public class Inquilino {

    private String cedInqui;
    private String nomInqui;
    private String genero;
    private LocalDate fechNac;
    private String direccion;
    private String telefono;
    private String email;
    private String ocupacion;

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
    public String getCedInqui() {
        return cedInqui;
    }

    public void setCedInqui(String cedInqui) {
        this.cedInqui = cedInqui;
    }

    public String getNomInqui() {
        return nomInqui;
    }

    public void setNomInqui(String nomInqui) {
        this.nomInqui = nomInqui;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getFechNac() {
        return fechNac;
    }

    public void setFechNac(LocalDate fechNac) {
        this.fechNac = fechNac;
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

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

    @Override
    public int hashCode() {
        return Objects.hash(cedInqui);
    }

    @Override
    public String toString() {
        return "Cédula: " + cedInqui + " | Nombre: " + nomInqui;
    }
}
