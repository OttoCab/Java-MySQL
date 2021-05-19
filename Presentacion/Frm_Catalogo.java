package Presentacion;

import Logica.SQLCatalogo;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Frm_Catalogo extends javax.swing.JFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private SQLCatalogo db = new SQLCatalogo();

    public Frm_Catalogo() {
        verificar();
        initComponents();
        setResizable(false);
        this.setLocationRelativeTo(null);
        txtid.setVisible(false);
        db.mysql_connection();
        mostrar();
        db.close_connection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        txtprecio = new javax.swing.JTextField();
        txtdetalle = new javax.swing.JTextField();
        btn_Modificar_Tabla = new javax.swing.JButton();
        txtcantidad = new javax.swing.JTextField();
        btn_limpiar = new javax.swing.JButton();
        btn_Cargar_Tabla = new javax.swing.JButton();
        txtid = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_regresar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        btn_Eliminar_Tabla1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbldatos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btn_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario de la Tienda");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Cantidad:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Precio:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Detalle:");

        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtprecio.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        txtdetalle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btn_Modificar_Tabla.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_Modificar_Tabla.setText("Modificar");
        btn_Modificar_Tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Modificar_TablaActionPerformed(evt);
            }
        });

        txtcantidad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btn_limpiar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        btn_Cargar_Tabla.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_Cargar_Tabla.setText("Guardar");
        btn_Cargar_Tabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Cargar_TablaActionPerformed(evt);
            }
        });

        txtid.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtid.setEnabled(false);

        btn_regresar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 97, Short.MAX_VALUE)
                .addComponent(btn_regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_regresar)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Codigo:");

        txtcodigo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        btn_Eliminar_Tabla1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_Eliminar_Tabla1.setText("Eliminar");
        btn_Eliminar_Tabla1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Eliminar_Tabla1ActionPerformed(evt);
            }
        });

        tbldatos.setFont(new java.awt.Font("Tahoma", 0, 21)); // NOI18N
        tbldatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombre", "Cantidad", "Precio", "Detalle"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbldatos.setRowHeight(24);
        tbldatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbldatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbldatos);

        jLabel6.setText("(Se puede realizar una busqueda por \"Codigo\")");

        btn_buscar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(232, 232, 232)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(133, 133, 133)
                .addComponent(btn_Cargar_Tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Modificar_Tabla)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Eliminar_Tabla1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(133, 133, 133))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtprecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtdetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_buscar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cargar_Tabla)
                    .addComponent(btn_Modificar_Tabla)
                    .addComponent(btn_limpiar)
                    .addComponent(btn_Eliminar_Tabla1))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_Modificar_TablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Modificar_TablaActionPerformed
        db.mysql_connection();
        db.modify_data(txtid.getText(), txtcodigo.getText(), txtnombre.getText(), txtcantidad.getText(), txtprecio.getText(), txtdetalle.getText());
        mostrar();
        db.close_connection();
        limpiar_cajas();
    }//GEN-LAST:event_btn_Modificar_TablaActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed

        db.mysql_connection();
        ResultSet rs = db.search_data(txtcodigo.getText());

        try {
            if (rs.next()) {
                txtid.setText(rs.getString("id"));
                txtcodigo.setText(rs.getString("codigo"));
                txtnombre.setText(rs.getString("nombre"));
                txtcantidad.setText(String.valueOf(rs.getInt("cantidad")));
                txtprecio.setText(String.valueOf(rs.getDouble("precio")));
                txtdetalle.setText(rs.getString("detalle"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe un producto relacionado con esa clave");
            }

        } catch (Exception e) {
            System.err.println(e);
        }
        db.close_connection();

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiar_cajas();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void btn_Cargar_TablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Cargar_TablaActionPerformed
        int cant1 = Integer.parseInt(txtcantidad.getText());
        Double precio1 = Double.parseDouble(txtprecio.getText());
        System.out.println(txtnombre.getText());
        db.mysql_connection();
        db.insert_data("productos", txtcodigo.getText(), txtnombre.getText(), cant1, precio1, txtdetalle.getText());
        mostrar();
        db.close_connection();
        limpiar_cajas();
    }//GEN-LAST:event_btn_Cargar_TablaActionPerformed

    private void btn_Eliminar_Tabla1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Eliminar_Tabla1ActionPerformed
        int fila = tbldatos.getSelectedRow();
        db.mysql_connection();
        db.delete_data(txtcodigo.getText());
        mostrar();
        db.close_connection();
    }//GEN-LAST:event_btn_Eliminar_Tabla1ActionPerformed

    private void tbldatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbldatosMouseClicked
        db.mysql_connection();
        int fila = tbldatos.getSelectedRow();
        String identificador = tbldatos.getValueAt(fila, 0).toString();
        ResultSet rs = db.clickear(identificador);
        try {
            while (rs.next()) {
                txtid.setText(rs.getString("id"));
                txtcodigo.setText(rs.getString("codigo"));
                txtnombre.setText(rs.getString("nombre"));
                txtcantidad.setText(String.valueOf(rs.getInt("cantidad")));
                txtprecio.setText(rs.getString("precio"));
                txtdetalle.setText(rs.getString("detalle"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(Frm_Catalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        db.close_connection();

    }//GEN-LAST:event_tbldatosMouseClicked

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        Frm_Login win1 = new Frm_Login();
        win1.setVisible(true);
        this.dispose();//cierra la ventana actual
    }//GEN-LAST:event_btn_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(Frm_Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frm_Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frm_Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frm_Catalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frm_Catalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cargar_Tabla;
    private javax.swing.JButton btn_Eliminar_Tabla1;
    private javax.swing.JButton btn_Modificar_Tabla;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_regresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbldatos;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigo;
    private javax.swing.JTextField txtdetalle;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txtprecio;
    // End of variables declaration//GEN-END:variables
 public void limpiar_cajas() {
        txtcodigo.setText(null);
        txtnombre.setText(null);
        txtcantidad.setText(null);
        txtprecio.setText(null);
        txtdetalle.setText(null);
    }

    private void mostrar() {

        try {

            ResultSet rs = db.charge_table();
            ResultSetMetaData rsMD = rs.getMetaData();
            //modifico las propiedades de la tabla
            int cantidadColumnas = rsMD.getColumnCount();
            DefaultTableModel dtm = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    if (column == 5) {
                        return true;
                    } else {
                        return false;
                    }
                }

            };

            dtm.addColumn("Codigo");
            dtm.addColumn("Nombre");
            dtm.addColumn("Cantidad");
            dtm.addColumn("Precio");
            dtm.addColumn("Detalle");

            // determino el ancho de las columnas
            int[] anchos = {3, 150, 25, 50, 250};
            tbldatos.setModel(dtm);
            for (int i = 0; i < cantidadColumnas; i++) {
                tbldatos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }

            while (rs.next()) {
                //añade resultados la modelo de la tabla
                dtm.addRow(new Object[]{rs.getString("codigo"), rs.getString("nombre"), rs.getInt("cantidad"), rs.getString("precio"), rs.getString("detalle")});
            }

        } catch (SQLException ex) {
            System.err.println(ex);
        }

    }

    private void verificar() {
        db.mysql_connection_base();
        System.out.println("hola");
        if (!db.verificar_bd()) {
            db.create_db("tiendaotto");
            db.mysql_connection();
            db.create_table_db("productos");
            db.close_connection();
        }
        db.close_connection();
    }
}
