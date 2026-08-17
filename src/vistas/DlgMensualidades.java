/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package vistas;

import datos.GuanaRent;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import logica.Mensualidad;

/**
 *
 * @author Erry
 */
public class DlgMensualidades extends javax.swing.JDialog {

    /**
     * Creates new form DlgMensualidades
     * @param parent
     * @param modal
     */
     public DlgMensualidades(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        configurarModuloMensualidades();
    }

    /**
     * Configuración la lógica del módulo de mensualidades.
     */
    private void configurarModuloMensualidades() {

    LocalDate hoy = LocalDate.now();
    datePicker1.setDate(hoy);
    datePicker1.setEnabled(false);

    // Configurar DatePicker con la fecha actual
    datePicker1.setDate(hoy);
    datePicker1.setEnabled(false);

    // Colocar el año actual
    txtAnioGenerar.setText(String.valueOf(hoy.getYear()));
    txtAnioMostrar.setText(String.valueOf(hoy.getYear()));

    // Mostrar todas las mensualidades al abrir
    configurarFiltroTexto();
    mostrarTabla(GuanaRent.mostrarMensualidades());
}

    /**
     * Genera las mensualidades del mes y año seleccionados.
     */
    private void generarMensualidades() {
        int mes = cmbMesGenerar.getSelectedIndex() + 1;
        int anio;

        try {
            anio = Integer.parseInt(txtAnioGenerar.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un año válido de 4 dígitos.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (anio < 1000 || anio > 9999) {
            JOptionPane.showMessageDialog(this,
                    "El año debe tener 4 dígitos.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        GuanaRent.generarMensualidades(mes, anio);
        mostrarTabla(GuanaRent.buscarMensualidades(mes, anio));
    }

    /**
     * Muestra las mensualidades del mes y año seleccionados.
     */
    private void mostrarMensualidades() {
        int mes = cmbMesGenerar1.getSelectedIndex() + 1;
        int anio;

        try {
            anio = Integer.parseInt(txtAnioMostrar.getText().trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Ingrese un año válido de 4 dígitos.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (anio < 1000 || anio > 9999) {
            JOptionPane.showMessageDialog(this,
                    "El año debe tener 4 dígitos.",
                    "Validación",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        mostrarTabla(GuanaRent.buscarMensualidades(mes, anio));
    }

    /**
     * Aplica los filtros seleccionados mediante los JCheckBox.
     * Si no se selecciona ningún filtro, muestra todos los registros.
     */
      
    private void aplicarFiltro() {

    String texto = txtBuscar.getText().trim().toLowerCase();

    // Si no hay ningún filtro seleccionado
    if (!chkInquilino.isSelected()
            && !chkMes.isSelected()
            && !chkAnio.isSelected()) {

        mostrarTabla(GuanaRent.mostrarMensualidades());
        return;
    }

    ArrayList<Mensualidad> resultado = new ArrayList<>();

    String[] meses = {
        "enero",
        "febrero",
        "marzo",
        "abril",
        "mayo",
        "junio",
        "julio",
        "agosto",
        "septiembre",
        "octubre",
        "noviembre",
        "diciembre"
    };

    for (Mensualidad m : GuanaRent.mostrarMensualidades()) {

        boolean coincide = false;

        // FILTRO POR INQUILINO
        if (chkInquilino.isSelected()) {

            if (m.getNomInquilino() != null
                    && m.getNomInquilino()
                            .toLowerCase()
                            .contains(texto)) {

                coincide = true;
            }
        }

        // FILTRO POR MES
        if (chkMes.isSelected()) {

            int mes = m.getMesCobro();

            String numeroMes = String.valueOf(mes);
            String nombreMes = meses[mes - 1];

            if (numeroMes.equals(texto)
                    || nombreMes.contains(texto)) {

                coincide = true;
            }
        }

        // FILTRO POR AÑO
        if (chkAnio.isSelected()) {

            String anio = String.valueOf(
                    m.getAnioActual()
            );

            if (anio.equals(texto)) {
                coincide = true;
            }
        }

        if (coincide) {
            resultado.add(m);
        }
    }

    mostrarTabla(resultado);
}

    /**
     * Carga los registros en la tabla.
     */
    private void mostrarTabla(ArrayList<Mensualidad> lista) {
        String[] columnas = {
            "Consecutivo", "N° Alquiler", "Fecha creación",
            "Inquilino", "Mes", "Año", "Descuento",
            "Monto mensual", "Estado"
        };

        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre",
            "Diciembre"
        };

        DefaultTableModel modelo = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Mensualidad m : lista) {
            modelo.addRow(new Object[]{
                m.getConsecutivo(),
                m.getNumAlquiler(),
                m.getFechCreacion(),
                m.getNomInquilino(),
                meses[m.getMesCobro() - 1],
                m.getAnioActual(),
                String.format("%.0f%%", m.getDescuento()),
                String.format("₡%.2f", m.getMontoMes()),
                m.getEstado()
            });
        }

        jTable1.setModel(modelo);
    }
    
    private void configurarFiltroTexto() {

    txtBuscar.getDocument().addDocumentListener(
            new DocumentListener() {

        @Override
        public void insertUpdate(DocumentEvent e) {
            aplicarFiltro();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            aplicarFiltro();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            aplicarFiltro();
        }
    });
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblFechaActual = new javax.swing.JLabel();
        cmbMesGenerar = new javax.swing.JComboBox<>();
        lblFechaActual1 = new javax.swing.JLabel();
        lblFechaActual2 = new javax.swing.JLabel();
        txtAnioGenerar = new javax.swing.JTextField();
        btnGenerar = new javax.swing.JButton();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();
        jPanel4 = new javax.swing.JPanel();
        lblFechaActual3 = new javax.swing.JLabel();
        btnGenerar1 = new javax.swing.JButton();
        lblFechaActual5 = new javax.swing.JLabel();
        cmbMesGenerar1 = new javax.swing.JComboBox<>();
        txtAnioMostrar = new javax.swing.JTextField();
        lblFechaActual6 = new javax.swing.JLabel();
        chkInquilino = new javax.swing.JCheckBox();
        chkMes = new javax.swing.JCheckBox();
        chkAnio = new javax.swing.JCheckBox();
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), "Mensualidades", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 12))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Generar mensualidades", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 12))); // NOI18N

        lblFechaActual.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblFechaActual.setText("Fecha actual:");

        cmbMesGenerar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        lblFechaActual1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblFechaActual1.setText("Mes:");

        lblFechaActual2.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblFechaActual2.setText("Año:");

        btnGenerar.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        btnGenerar.setText("Generar");
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFechaActual)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFechaActual1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cmbMesGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblFechaActual2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtAnioGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(btnGenerar)))
                .addGap(0, 187, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaActual, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaActual1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMesGenerar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaActual2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnioGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Mostrar Mensualidades", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 3, 12))); // NOI18N

        lblFechaActual3.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblFechaActual3.setText("Año:");

        btnGenerar1.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        btnGenerar1.setText("Mostrar");
        btnGenerar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerar1ActionPerformed(evt);
            }
        });

        lblFechaActual5.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblFechaActual5.setText("Mes:");

        cmbMesGenerar1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un mes", "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaActual5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaActual3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbMesGenerar1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAnioMostrar))
                .addContainerGap(117, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerar1)
                .addGap(131, 131, 131))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMesGenerar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaActual5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaActual3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnioMostrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGenerar1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblFechaActual6.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        lblFechaActual6.setText("Filtrar por:");

        chkInquilino.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        chkInquilino.setText("Inquilino");
        chkInquilino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkInquilinoActionPerformed(evt);
            }
        });

        chkMes.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        chkMes.setText("Mes");
        chkMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMesActionPerformed(evt);
            }
        });

        chkAnio.setFont(new java.awt.Font("Arial", 3, 12)); // NOI18N
        chkAnio.setText("Año");
        chkAnio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkAnioActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblFechaActual6, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(chkInquilino)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(chkMes)
                        .addGap(18, 18, 18)
                        .addComponent(chkAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(83, 83, 83)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaActual6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkInquilino)
                    .addComponent(chkMes)
                    .addComponent(chkAnio)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
        int mes = cmbMesGenerar.getSelectedIndex();

    if (mes == 0) {
        JOptionPane.showMessageDialog(
                this,
                "Seleccione un mes.",
                "Validación",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    int anio;

    try {
        anio = Integer.parseInt(txtAnioGenerar.getText().trim());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
                this,
                "Ingrese un año válido.",
                "Validación",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    if (anio < 1000 || anio > 9999) {
        JOptionPane.showMessageDialog(
                this,
                "El año debe tener 4 dígitos.",
                "Validación",
                JOptionPane.WARNING_MESSAGE
        );
        return;
    }

    GuanaRent.generarMensualidades(mes, anio);

    mostrarTabla(
            GuanaRent.buscarMensualidades(mes, anio)
    );
    
    }//GEN-LAST:event_btnGenerarActionPerformed

    private void btnGenerar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGenerar1ActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        aplicarFiltro();
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void chkMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMesActionPerformed
        if (chkMes.isSelected()) {
        chkInquilino.setSelected(false);
        chkAnio.setSelected(false);
    }

    txtBuscar.setText("");
    aplicarFiltro();
    }//GEN-LAST:event_chkMesActionPerformed

    private void chkInquilinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkInquilinoActionPerformed
        if (chkInquilino.isSelected()) {
        chkMes.setSelected(false);
        chkAnio.setSelected(false);
    }

    txtBuscar.setText("");
    aplicarFiltro();// TODO add your handling code here:
    }//GEN-LAST:event_chkInquilinoActionPerformed

    private void chkAnioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkAnioActionPerformed
        if (chkAnio.isSelected()) {
        chkInquilino.setSelected(false);
        chkMes.setSelected(false);
    }

    txtBuscar.setText("");
    aplicarFiltro();
    }//GEN-LAST:event_chkAnioActionPerformed

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
            java.util.logging.Logger.getLogger(DlgMensualidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgMensualidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgMensualidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgMensualidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgMensualidades dialog = new DlgMensualidades(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGenerar;
    private javax.swing.JButton btnGenerar1;
    private javax.swing.JCheckBox chkAnio;
    private javax.swing.JCheckBox chkInquilino;
    private javax.swing.JCheckBox chkMes;
    private javax.swing.JComboBox<String> cmbMesGenerar;
    private javax.swing.JComboBox<String> cmbMesGenerar1;
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFechaActual;
    private javax.swing.JLabel lblFechaActual1;
    private javax.swing.JLabel lblFechaActual2;
    private javax.swing.JLabel lblFechaActual3;
    private javax.swing.JLabel lblFechaActual5;
    private javax.swing.JLabel lblFechaActual6;
    private javax.swing.JTextField txtAnioGenerar;
    private javax.swing.JTextField txtAnioMostrar;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
