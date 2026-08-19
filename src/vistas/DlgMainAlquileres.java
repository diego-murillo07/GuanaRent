/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Alquiler;

/**
 * Ventana principal de administración de contratos de alquiler. Muestra todos
 * los alquileres registrados en una tabla, permite buscar, insertar nuevos
 * contratos, editar existentes y eliminar.
 *
 * @author Deilyn Medrano
 * @author Erry
 * @version 1.0
 */
public class DlgMainAlquileres extends javax.swing.JDialog {

    /**
     * Crea la ventana principal de alquileres. Inicializa los componentes
     * gráficos y carga automáticamente la tabla con todos los contratos
     * registrados.
     *
     * @param parent Ventana padre que invoca este diálogo
     * @param modal Si es modal, bloquea la ventana padre hasta cerrar
     */
    public DlgMainAlquileres(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        cargarTabla();
    }

    /**
     * Carga y muestra todos los contratos de alquiler en la tabla. Define las
     * columnas con los datos del contrato, recorre la lista completa de
     * alquileres y llena cada fila. Muestra también la cantidad total de
     * contratos registrados.
     */
    private void cargarTabla() {
        datos.GuanaRent.actualizarEstadosAlquileres();
        String[] columnas = {
            "N° Alquiler",
            "Fecha Contrato",
            "Meses",
            "Adultos",
            "Niños",
            "Depósito",
            "Precio",
            "Incremento %",
            "Inquilino",
            "Vivienda",
            "Estado"
        };

        DefaultTableModel modelo
                = new DefaultTableModel(null, columnas);

        for (Alquiler a : datos.GuanaRent.listaAlquileres) {

            String cedula = "";

            if (a.getInquilino() != null) {
                cedula = a.getInquilino().getCedInqui();
            }

            String vivienda = "";

            if (a.getVivienda() != null) {
                vivienda = a.getVivienda().getIdVivienda();
            }

            Object[] fila = {
                a.getNumAlquiler(),
                a.getFechContrato(),
                a.getCantMeses(),
                a.getNumAdultos(),
                a.getNumNinos(),
                a.getDepositoGarantia(),
                a.getPrecioAlquiler(),
                a.getPorcIncremAnual(),
                cedula,
                vivienda,
                a.getEstado()
            };

            modelo.addRow(fila);
        }

        tblAlquileres.setModel(modelo);

        txtCantAlquileres.setText(
                String.valueOf(
                        datos.GuanaRent.listaAlquileres.size()));
    }

    /**
     * Busca y muestra en la tabla solo los alquileres que coincidan con el
     * texto ingresado. Busca por número, cédula, vivienda o estado. No
     * distingue entre mayúsculas y minúsculas.
     */
    private void buscarAlquileres() {

        String buscar
                = txtBuscar.getText()
                        .trim()
                        .toLowerCase();

        String[] columnas = {
            "N° Alquiler",
            "Fecha Contrato",
            "Meses",
            "Adultos",
            "Niños",
            "Depósito",
            "Precio",
            "Incremento %",
            "Inquilino",
            "Vivienda",
            "Estado"
        };

        DefaultTableModel modelo
                = new DefaultTableModel(null, columnas);

        for (Alquiler a : datos.GuanaRent.listaAlquileres) {

            String cedula = "";
            String vivienda = "";

            if (a.getInquilino() != null) {
                cedula = a.getInquilino().getCedInqui();
            }

            if (a.getVivienda() != null) {
                vivienda = a.getVivienda().getIdVivienda();
            }

            String texto
                    = String.valueOf(a.getNumAlquiler())
                    + " "
                    + cedula
                    + " "
                    + vivienda
                    + " "
                    + a.getEstado();

            if (texto.toLowerCase().contains(buscar)) {

                modelo.addRow(new Object[]{
                    a.getNumAlquiler(),
                    a.getFechContrato(),
                    a.getCantMeses(),
                    a.getNumAdultos(),
                    a.getNumNinos(),
                    a.getDepositoGarantia(),
                    a.getPrecioAlquiler(),
                    a.getPorcIncremAnual(),
                    cedula,
                    vivienda,
                    a.getEstado()
                });
            }
        }

        tblAlquileres.setModel(modelo);

        txtCantAlquileres.setText(
                String.valueOf(modelo.getRowCount()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblBuscar = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        btnInsertar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlquileres = new javax.swing.JTable();
        lblCantAlquileres = new javax.swing.JLabel();
        txtCantAlquileres = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Alquileres");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblBuscar.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblBuscar.setText("Buscar:");

        txtBuscar.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        btnInsertar.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnInsertar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/agregar.png"))); // NOI18N
        btnInsertar.setText("Insertar");
        btnInsertar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInsertar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnInsertar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInsertar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEditar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEditar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEliminar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(btnInsertar)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnEliminar)
                .addGap(131, 131, 131))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnInsertar)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBuscar))))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        tblAlquileres.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblAlquileres);

        lblCantAlquileres.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblCantAlquileres.setText("Cant.Alquileres:");

        txtCantAlquileres.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        txtCantAlquileres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantAlquileresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCantAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCantAlquileres, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantAlquileres))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 /**
     * Abre la ventana para editar el alquiler seleccionado en la tabla.
     * Verifica que se haya seleccionado una fila, obtiene el número del
     * contrato, lo busca en la lista y abre la ventana de modificación. Al
     * cerrar, actualiza la tabla con los cambios.
     *
     * @param evt Evento de acción al presionar el botón Editar
     */

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

        int fila = tblAlquileres.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un alquiler de la tabla.");

            return;
        }

        int numero = Integer.parseInt(
                tblAlquileres
                        .getValueAt(fila, 0)
                        .toString());

        Alquiler seleccionado
                = datos.GuanaRent.buscarAlquiler(numero);

        if (seleccionado != null) {

            DlgNewAlquileres dlg
                    = new DlgNewAlquileres(
                            (java.awt.Frame) this.getParent(),
                            true,
                            seleccionado);

            dlg.setVisible(true);

            cargarTabla();
        }
    }//GEN-LAST:event_btnEditarActionPerformed
    /**
     * Elimina el alquiler seleccionado tras confirmación del usuario. Verifica
     * selección, pide confirmación, elimina y recarga la tabla. Muestra mensaje
     * de éxito o error según resultado.
     *
     * @param evt Evento de acción al presionar el botón Eliminar
     */
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        int fila = tblAlquileres.getSelectedRow();

        if (fila == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Seleccione un alquiler de la tabla.");

            return;
        }

        int numero = Integer.parseInt(
                tblAlquileres
                        .getValueAt(fila, 0)
                        .toString());

        int confirmar = JOptionPane.showConfirmDialog(
                this,
                "¿Desea eliminar el alquiler N° "
                + numero + "?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION);

        if (confirmar == JOptionPane.YES_OPTION) {

            if (datos.GuanaRent.eliminarAlquiler(numero)) {

                JOptionPane.showMessageDialog(
                        this,
                        "Alquiler eliminado correctamente.");

                cargarTabla();

            } else {

                JOptionPane.showMessageDialog(
                        this,
                        "No se pudo eliminar el alquiler.");
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    /**
     * Abre la ventana para registrar un nuevo contrato de alquiler. Al cerrar
     * la ventana, recarga la tabla para mostrar el nuevo registro.
     *
     * @param evt Evento de acción al presionar el botón Insertar
     */
    private void btnInsertarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertarActionPerformed

        DlgNewAlquileres dlg
                = new DlgNewAlquileres(
                        (java.awt.Frame) this.getParent(),
                        true);

        dlg.setVisible(true);

        cargarTabla();
    }//GEN-LAST:event_btnInsertarActionPerformed
    /**
     * Ejecuta la búsqueda automáticamente al escribir en el campo.
     *
     * @param evt Evento de acción al cambiar el texto de búsqueda
     */
    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed

        buscarAlquileres();
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void txtCantAlquileresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantAlquileresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantAlquileresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DlgMainAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgMainAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgMainAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgMainAlquileres.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgMainAlquileres dialog = new DlgMainAlquileres(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInsertar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBuscar;
    private javax.swing.JLabel lblCantAlquileres;
    private javax.swing.JTable tblAlquileres;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCantAlquileres;
    // End of variables declaration//GEN-END:variables
}
