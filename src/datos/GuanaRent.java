/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logica.Alquiler;
import logica.Inquilino;
import logica.Mensualidad;
import logica.Propietario;
import logica.Vivienda;

/**
 * Clase principal encargada de administrar los datos del sistema GuanaRent.
 *
 * Contiene los ArrayList utilizados para almacenar los objetos de las
 * diferentes clases del sistema y los métodos necesarios para realizar
 * operaciones de búsqueda, inserción, modificación y eliminación.
 *
 * @author Erry
 * @version 1.0
 */
public class GuanaRent {

    /**
     * Lista de propietarios registrados.
     */
    public static ArrayList<Propietario> listaPropietarios = new ArrayList<>();

    /**
     * Lista de inquilinos registrados.
     */
    public static ArrayList<Inquilino> listaInquilinos = new ArrayList<>();

    /**
     * Lista de viviendas registradas.
     */
    public static ArrayList<Vivienda> listaViviendas = new ArrayList<>();

    /**
     * Lista de alquileres registrados.
     */
    public static ArrayList<Alquiler> listaAlquileres = new ArrayList<>();

    /**
     * Lista de mensualidades generadas automáticamente.
     */
    public static ArrayList<Mensualidad> listaMensualidades = new ArrayList<>();

    /**
     * Consecutivo utilizado para generar los números de alquiler.
     */
    public static int contAlquiler = 1;

    /**
     * Consecutivo utilizado para generar las mensualidades.
     */
    public static int contMensualidad = 1;

    // ==========================================================
    // PROPIETARIOS
    // ==========================================================
    /**
     * Agrega un propietario al ArrayList.
     *
     * @param p propietario que se desea agregar.
     * @return true si se agregó correctamente.
     */
    public static boolean agregarPropietario(Propietario p) {

        if (p == null) {
            return false;
        }

        if (p.getCedPropiet() == null
                || p.getCedPropiet().trim().isEmpty()) {
            return false;
        }

        if (buscarPropietarioCed(p.getCedPropiet()) != null) {

            JOptionPane.showMessageDialog(
                    null,
                    "La cédula del propietario ya está registrada.",
                    "Validación",
                    JOptionPane.ERROR_MESSAGE
            );

            return false;
        }

        listaPropietarios.add(p);
        return true;
    }

    /**
     * Busca un propietario por su cédula.
     *
     * @param ced cédula del propietario.
     * @return propietario encontrado o null si no existe.
     */
    public static Propietario buscarPropietarioCed(String ced) {

        if (ced == null || ced.trim().isEmpty()) {
            return null;
        }

        for (Propietario p : listaPropietarios) {

            if (p.getCedPropiet().equals(ced)) {
                return p;
            }
        }

        return null;
    }

    /**
     * Modifica un propietario existente.
     *
     * @param ced cédula del propietario que se desea modificar.
     * @param nuevo nuevos datos del propietario.
     * @return true si se modificó correctamente.
     */
    public static boolean modificarPropietario(
            String ced,
            Propietario nuevo) {

        Propietario actual
                = buscarPropietarioCed(ced);

        if (actual == null || nuevo == null) {
            return false;
        }

        actual.setNomPropiet(nuevo.getNomPropiet());
        actual.setGenero(nuevo.getGenero());
        actual.setDireccion(nuevo.getDireccion());
        actual.setTelefono(nuevo.getTelefono());
        actual.setEmail(nuevo.getEmail());

        return true;
    }

    /**
     * Elimina un propietario.
     *
     * No se permite eliminarlo si tiene viviendas registradas.
     *
     * @param ced cédula del propietario.
     * @return true si se eliminó correctamente.
     */
    public static boolean eliminarPropietario(String ced) {

        Propietario propietario
                = buscarPropietarioCed(ced);

        if (propietario == null) {
            return false;
        }

        for (Vivienda v : listaViviendas) {

            if (v.getPropietario() == propietario) {

                JOptionPane.showMessageDialog(
                        null,
                        "No se puede eliminar el propietario "
                        + "porque tiene viviendas registradas.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );

                return false;
            }
        }

        return listaPropietarios.remove(propietario);
    }

    /**
     * Obtiene todos los propietarios registrados.
     *
     * @return ArrayList de propietarios.
     */
    public static ArrayList<Propietario> mostrarPropietarios() {
        return new ArrayList<>(listaPropietarios);
    }

    // ==========================================================
    // INQUILINOS
    // ==========================================================
    /**
     * Agrega un inquilino al ArrayList.
     *
     * @param i inquilino que se desea agregar.
     * @return true si se agregó correctamente.
     */
    public static boolean agregarInquilino(Inquilino i) {

        if (i == null) {
            return false;
        }

        if (i.getCedInqui() == null
                || i.getCedInqui().trim().isEmpty()) {
            return false;
        }

        if (buscarInquilinoCed(i.getCedInqui()) != null) {

            JOptionPane.showMessageDialog(
                    null,
                    "La cédula del inquilino ya está registrada.",
                    "Validación",
                    JOptionPane.ERROR_MESSAGE
            );

            return false;
        }

        listaInquilinos.add(i);
        return true;
    }

    /**
     * Busca un inquilino por cédula.
     *
     * @param ced cédula del inquilino.
     * @return inquilino encontrado o null.
     */
    public static Inquilino buscarInquilinoCed(String ced) {

        if (ced == null || ced.trim().isEmpty()) {
            return null;
        }

        for (Inquilino i : listaInquilinos) {

            if (i.getCedInqui().equals(ced)) {
                return i;
            }
        }

        return null;
    }

    /**
     * Modifica un inquilino existente.
     *
     * @param ced cédula del inquilino.
     * @param nuevo nuevos datos del inquilino.
     * @return true si se modificó correctamente.
     */
    public static boolean modificarInquilino(
            String ced,
            Inquilino nuevo) {

        Inquilino actual
                = buscarInquilinoCed(ced);

        if (actual == null || nuevo == null) {
            return false;
        }

        actual.setNomInqui(nuevo.getNomInqui());
        actual.setGenero(nuevo.getGenero());
        actual.setFechNac(nuevo.getFechNac());
        actual.setDireccion(nuevo.getDireccion());
        actual.setTelefono(nuevo.getTelefono());
        actual.setEmail(nuevo.getEmail());
        actual.setOcupacion(nuevo.getOcupacion());

        return true;
    }

    /**
     * Elimina un inquilino.
     *
     * No se permite eliminarlo si tiene un alquiler vigente.
     *
     * @param ced cédula del inquilino.
     * @return true si se eliminó correctamente.
     */
    public static boolean eliminarInquilino(String ced) {

        Inquilino inquilino
                = buscarInquilinoCed(ced);

        if (inquilino == null) {
            return false;
        }

        for (Alquiler a : listaAlquileres) {

            if (a.getInquilino() == inquilino
                    && "Vigente".equalsIgnoreCase(
                            a.getEstado())) {

                JOptionPane.showMessageDialog(
                        null,
                        "No se puede eliminar el inquilino "
                        + "porque tiene un alquiler vigente.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );

                return false;
            }
        }

        return listaInquilinos.remove(inquilino);
    }

    /**
     * Obtiene todos los inquilinos.
     *
     * @return ArrayList de inquilinos.
     */
    public static ArrayList<Inquilino> mostrarInquilinos() {
        return new ArrayList<>(listaInquilinos);
    }

    // ==========================================================
    // VIVIENDAS
    // ==========================================================
    /**
     * Agrega una vivienda.
     *
     * Valida que el ID no esté repetido y que el propietario exista.
     *
     * @param v vivienda que se desea agregar.
     * @return true si se agregó correctamente.
     */
    public static boolean agregarVivienda(Vivienda v) {

        if (v == null) {
            return false;
        }

        if (v.getIdVivienda() == null
                || v.getIdVivienda().trim().isEmpty()) {
            return false;
        }

        if (buscarViviendaID(v.getIdVivienda()) != null) {

            JOptionPane.showMessageDialog(
                    null,
                    "El ID de la vivienda ya está registrado.",
                    "Validación",
                    JOptionPane.ERROR_MESSAGE
            );

            return false;
        }

        if (v.getPropietario() == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "Debe seleccionar un propietario.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        if (buscarPropietarioCed(
                v.getPropietario().getCedPropiet()) == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "El propietario no existe en el sistema.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        listaViviendas.add(v);
        return true;
    }

    /**
     * Busca una vivienda por su identificador.
     *
     * @param id identificador de la vivienda.
     * @return vivienda encontrada o null.
     */
    public static Vivienda buscarViviendaID(String id) {

        if (id == null || id.trim().isEmpty()) {
            return null;
        }

        for (Vivienda v : listaViviendas) {

            if (v.getIdVivienda().equals(id)) {
                return v;
            }
        }

        return null;
    }

    /**
     * Modifica una vivienda.
     *
     * @param id identificador de la vivienda.
     * @param nueva nuevos datos.
     * @return true si se modificó correctamente.
     */
    public static boolean modificarVivienda(
            String id,
            Vivienda nueva) {

        Vivienda actual
                = buscarViviendaID(id);

        if (actual == null || nueva == null) {
            return false;
        }

        actual.setDescripcion(nueva.getDescripcion());
        actual.setDireccion(nueva.getDireccion());
        actual.setMtsConstruct(nueva.getMtsConstruct());
        actual.setMtsLote(nueva.getMtsLote());
        actual.setTipoConstruccion(nueva.getTipoConstruccion());
        actual.setCochera(nueva.isCochera());
        actual.setCantHabitac(nueva.getCantHabitac());
        actual.setCantBanios(nueva.getCantBanios());
        actual.setCarretera(nueva.getCarretera());
        actual.setPrecioBase(nueva.getPrecioBase());
        actual.setDepositoGarantia(nueva.getDepositoGarantia());
        actual.setPropietario(nueva.getPropietario());
        actual.setEstado(nueva.getEstado());

        return true;
    }

    /**
     * Elimina una vivienda.
     *
     * No se permite eliminarla si posee un alquiler vigente.
     *
     * @param id identificador de la vivienda.
     * @return true si se eliminó correctamente.
     */
    public static boolean eliminarVivienda(String id) {

        Vivienda vivienda
                = buscarViviendaID(id);

        if (vivienda == null) {
            return false;
        }

        for (Alquiler a : listaAlquileres) {

            if (a.getVivienda() == vivienda
                    && "Vigente".equalsIgnoreCase(
                            a.getEstado())) {

                JOptionPane.showMessageDialog(
                        null,
                        "No se puede eliminar la vivienda "
                        + "porque posee un alquiler vigente.",
                        "Validación",
                        JOptionPane.WARNING_MESSAGE
                );

                return false;
            }
        }

        return listaViviendas.remove(vivienda);
    }

    /**
     * Obtiene todas las viviendas.
     *
     * @return ArrayList de viviendas.
     */
    public static ArrayList<Vivienda> mostrarViviendas() {
        return new ArrayList<>(listaViviendas);
    }

    // ==========================================================
    // ALQUILERES
    // ==========================================================
    /**
     * Agrega un nuevo alquiler.
     *
     * Valida la existencia del inquilino y la vivienda, además de validar que
     * la vivienda esté disponible.
     *
     * @param a alquiler que se desea agregar.
     * @return true si se agregó correctamente.
     */
    public static boolean agregarAlquiler(Alquiler a) {

        if (a == null) {
            return false;
        }

        if (a.getFechContrato() == null
                || a.getCantMeses() <= 0
                || a.getNumAdultos() <= 0
                || a.getNumNinos() < 0
                || a.getDepositoGarantia() < 0
                || a.getPrecioAlquiler() <= 0) {

            JOptionPane.showMessageDialog(
                    null,
                    "Revise los datos del alquiler.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        if (a.getPorcIncremAnual() < 1
                || a.getPorcIncremAnual() > 30) {

            JOptionPane.showMessageDialog(
                    null,
                    "El incremento anual debe estar entre 1% y 30%.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        if (a.getInquilino() == null
                || buscarInquilinoCed(
                        a.getInquilino().getCedInqui()) == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "El inquilino debe existir previamente.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        if (a.getVivienda() == null
                || buscarViviendaID(
                        a.getVivienda().getIdVivienda()) == null) {

            JOptionPane.showMessageDialog(
                    null,
                    "La vivienda debe existir previamente.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        Vivienda vivienda
                = buscarViviendaID(
                        a.getVivienda().getIdVivienda());

        if (!"disponible".equalsIgnoreCase(
                vivienda.getEstado())) {

            JOptionPane.showMessageDialog(
                    null,
                    "La vivienda no está disponible.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        a.setNumAlquiler(contAlquiler);
        a.setEstado("Vigente");

        listaAlquileres.add(a);

        vivienda.setEstado("alquilada");

        contAlquiler++;

        return true;
    }

    /**
     * Busca un alquiler por su número.
     *
     * @param numero número del alquiler.
     * @return alquiler encontrado o null.
     */
    public static Alquiler buscarAlquiler(int numero) {

        for (Alquiler a : listaAlquileres) {

            if (a.getNumAlquiler() == numero) {
                return a;
            }
        }

        return null;
    }

    /**
     * Modifica un alquiler existente.
     *
     * @param numero número del alquiler.
     * @param nuevo nuevos datos.
     * @return true si se modificó correctamente.
     */
    public static boolean modificarAlquiler(
            int numero,
            Alquiler nuevo) {

        Alquiler actual
                = buscarAlquiler(numero);

        if (actual == null || nuevo == null) {
            return false;
        }

        if (nuevo.getFechContrato() == null
                || nuevo.getCantMeses() <= 0
                || nuevo.getNumAdultos() <= 0
                || nuevo.getNumNinos() < 0
                || nuevo.getDepositoGarantia() < 0
                || nuevo.getPrecioAlquiler() <= 0) {

            return false;
        }

        if (nuevo.getPorcIncremAnual() < 1
                || nuevo.getPorcIncremAnual() > 30) {

            return false;
        }

        actual.setFechContrato(nuevo.getFechContrato());
        actual.setCantMeses(nuevo.getCantMeses());
        actual.setNumAdultos(nuevo.getNumAdultos());
        actual.setNumNinos(nuevo.getNumNinos());
        actual.setDepositoGarantia(nuevo.getDepositoGarantia());
        actual.setPrecioAlquiler(nuevo.getPrecioAlquiler());
        actual.setPorcIncremAnual(nuevo.getPorcIncremAnual());
        actual.setInquilino(nuevo.getInquilino());
        actual.setVivienda(nuevo.getVivienda());
        actual.setEstado(nuevo.getEstado());

        return true;
    }

    /**
     * Elimina un alquiler.
     *
     * @param numero número del alquiler.
     * @return true si se eliminó correctamente.
     */
    public static boolean eliminarAlquiler(int numero) {

        Alquiler alquiler
                = buscarAlquiler(numero);

        if (alquiler == null) {
            return false;
        }

        if (alquiler.getVivienda() != null
                && "Vigente".equalsIgnoreCase(
                        alquiler.getEstado())) {

            alquiler.getVivienda()
                    .setEstado("disponible");
        }

        return listaAlquileres.remove(alquiler);
    }

    /**
     * Obtiene todos los alquileres.
     *
     * @return ArrayList de alquileres.
     */
    public static ArrayList<Alquiler> mostrarAlquileres() {
        return new ArrayList<>(listaAlquileres);
    }

    // ==========================================================
    // MENSUALIDADES
    // ==========================================================
    /**
     * Determina el descuento según la temporada.
     *
     * Temporada baja: agosto, septiembre y octubre = 10%. Temporada media:
     * marzo a julio = 5%. Temporada alta: noviembre a febrero = 0%.
     *
     * @param mes número del mes.
     * @return porcentaje de descuento en formato decimal.
     */
    public static double obtenerDescuento(int mes) {

        if (mes >= 8 && mes <= 10) {
            return 0.10;
        }

        if (mes >= 3 && mes <= 7) {
            return 0.05;
        }

        return 0.0;
    }

    /**
     * Comprueba si ya existe una mensualidad para un alquiler en un determinado
     * mes y año.
     *
     * @param mes mes de cobro.
     * @param anio año de cobro.
     * @param numAlq número del alquiler.
     * @return true si ya existe.
     */
    public static boolean mensualidadYaGenerada(
            int mes,
            int anio,
            int numAlq) {

        for (Mensualidad m : listaMensualidades) {

            if (m.getMesCobro() == mes
                    && m.getAnioActual() == anio
                    && m.getNumAlquiler() == numAlq) {

                return true;
            }
        }

        return false;
    }

    /**
     * Genera las mensualidades de un mes y año.
     *
     * Solo se genera una mensualidad por cada alquiler vigente.
     *
     * @param mes mes de cobro.
     * @param anio año de cobro.
     */
    public static void generarMensualidades(
            int mes,
            int anio) {

        LocalDate hoy = LocalDate.now();

        if (mes < 1 || mes > 12) {

            JOptionPane.showMessageDialog(
                    null,
                    "El mes debe estar entre 1 y 12.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if (anio < hoy.getYear()
                || (anio == hoy.getYear()
                && mes < hoy.getMonthValue())) {

            JOptionPane.showMessageDialog(
                    null,
                    "No se pueden generar mensualidades "
                    + "para fechas anteriores a la actual.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int generadas = 0;

        for (Alquiler alq : listaAlquileres) {

            if (!"Vigente".equalsIgnoreCase(
                    alq.getEstado())) {
                continue;
            }

            if (mensualidadYaGenerada(
                    mes,
                    anio,
                    alq.getNumAlquiler())) {
                continue;
            }

            double descuento
                    = obtenerDescuento(mes);

            double monto
                    = alq.getPrecioAlquiler()
                    - (alq.getPrecioAlquiler()
                    * descuento);

            Mensualidad mensualidad
                    = new Mensualidad(
                            contMensualidad,
                            alq.getNumAlquiler(),
                            LocalDate.now(),
                            alq.getInquilino().getNomInqui(),
                            mes,
                            anio,
                            descuento * 100,
                            monto,
                            "Pendiente"
                    );

            listaMensualidades.add(mensualidad);

            contMensualidad++;
            generadas++;
        }

        JOptionPane.showMessageDialog(
                null,
                "Se generaron "
                + generadas
                + " mensualidades."
        );
    }

    /**
     * Busca mensualidades por mes y año.
     *
     * @param mes mes de cobro.
     * @param anio año de cobro.
     * @return lista de mensualidades encontradas.
     */
    public static ArrayList<Mensualidad>
            buscarMensualidades(int mes, int anio) {

        ArrayList<Mensualidad> resultado
                = new ArrayList<>();

        for (Mensualidad m : listaMensualidades) {

            if (m.getMesCobro() == mes
                    && m.getAnioActual() == anio) {

                resultado.add(m);
            }
        }

        return resultado;
    }

    /**
     * Busca mensualidades por nombre del inquilino.
     *
     * @param nombre nombre o parte del nombre.
     * @return lista de mensualidades encontradas.
     */
    public static ArrayList<Mensualidad>
            buscarMensualidadesInquilino(
                    String nombre) {

        ArrayList<Mensualidad> resultado
                = new ArrayList<>();

        if (nombre == null) {
            return resultado;
        }

        for (Mensualidad m : listaMensualidades) {

            if (m.getNomInquilino()
                    .toLowerCase()
                    .contains(nombre.toLowerCase())) {

                resultado.add(m);
            }
        }

        return resultado;
    }

    /**
     * Filtra las mensualidades utilizando nombre, mes y año.
     *
     * @param nombre nombre del inquilino.
     * @param mes mes de cobro.
     * @param anio año de cobro.
     * @return lista filtrada.
     */
    public static ArrayList<Mensualidad>
            filtrarMensualidades(
                    String nombre,
                    int mes,
                    int anio) {

        ArrayList<Mensualidad> resultado
                = new ArrayList<>();

        for (Mensualidad m : listaMensualidades) {

            boolean coincideNombre
                    = nombre == null
                    || nombre.trim().isEmpty()
                    || m.getNomInquilino()
                            .toLowerCase()
                            .contains(nombre.toLowerCase());

            boolean coincideMes
                    = mes <= 0
                    || m.getMesCobro() == mes;

            boolean coincideAnio
                    = anio <= 0
                    || m.getAnioActual() == anio;

            if (coincideNombre
                    && coincideMes
                    && coincideAnio) {

                resultado.add(m);
            }
        }

        return resultado;
    }

    /**
     * Obtiene todas las mensualidades.
     *
     * @return ArrayList de mensualidades.
     */
    public static ArrayList<Mensualidad>
            mostrarMensualidades() {

        return new ArrayList<>(
                listaMensualidades
        );
    }

    // ==========================================================
    // GANANCIAS
    // ==========================================================
    /**
     * Calcula las ganancias obtenidas en un mes.
     *
     * GuanaRent obtiene el 5% de cada mensualidad y el 50% del depósito de
     * garantía de los alquileres realizados durante el período.
     *
     * @param mes mes que se desea consultar.
     * @param anio año que se desea consultar.
     * @return ganancias obtenidas.
     */
    public static double calcularGananciasMes(
            int mes,
            int anio) {

        double ganancia = 0;

        for (Mensualidad m : listaMensualidades) {

            if (m.getMesCobro() == mes
                    && m.getAnioActual() == anio) {

                ganancia
                        += m.getMontoMes() * 0.05;
            }
        }

        for (Alquiler a : listaAlquileres) {

            if (a.getFechContrato() != null
                    && a.getFechContrato()
                            .getMonthValue() == mes
                    && a.getFechContrato()
                            .getYear() == anio) {

                ganancia
                        += a.getDepositoGarantia() * 0.50;
            }
        }

        return ganancia;
    }

    /**
     * Calcula las ganancias obtenidas durante todo un año.
     *
     * @param anio año que se desea consultar.
     * @return ganancias totales del año.
     */
    public static double calcularGananciasAnio(
            int anio) {

        double total = 0;

        for (int mes = 1; mes <= 12; mes++) {

            total += calcularGananciasMes(
                    mes,
                    anio
            );
        }

        return total;
    }
    
       
}
