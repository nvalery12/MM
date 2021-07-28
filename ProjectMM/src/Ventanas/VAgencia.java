/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import CRUD.CRUDAgencias;
import Controlador.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author angel
 */
public class VAgencia extends javax.swing.JFrame {

    Conexion conexion = new Conexion();
    CRUDAgencias ag = new CRUDAgencias(conexion.conectar());
    
    /**
     * Creates new form VAgencia
     */
    public VAgencia() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Btn_Agencias = new javax.swing.JButton();
        Btn_Empleados = new javax.swing.JButton();
        Btn_Clientes = new javax.swing.JButton();
        Btn_Vehiculos = new javax.swing.JButton();
        Btn_Productos = new javax.swing.JButton();
        Btn_OrdenServicios = new javax.swing.JButton();
        Btn_Facturas = new javax.swing.JButton();
        Btn_Servicios = new javax.swing.JButton();
        Btn_Actividades = new javax.swing.JButton();
        Perfiles = new javax.swing.JButton();
        TF_Direccion = new javax.swing.JTextField();
        TF_RifAg = new javax.swing.JTextField();
        TF_RazonSocial = new javax.swing.JTextField();
        TF_Ciudad = new javax.swing.JTextField();
        Btn_Encargado = new javax.swing.JButton();
        Btn_Buscar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        Btn_Habilitar = new javax.swing.JButton();
        Btn_Nuevo = new javax.swing.JButton();
        Btn_Actuaizar = new javax.swing.JButton();
        Btn_Eliminar = new javax.swing.JButton();
        Btn_Limpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(36, 204, 167));
        jLabel2.setFont(new java.awt.Font("Helvetica", 1, 48)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Datos de la agencia");
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 900, 100));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/Sin título-2.png"))); // NOI18N
        jLabel3.setOpaque(true);

        Btn_Agencias.setBackground(new java.awt.Color(36, 204, 167));
        Btn_Agencias.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Agencias.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Agencias.setText("Agencia");
        Btn_Agencias.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        Btn_Agencias.setBorderPainted(false);
        Btn_Agencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_AgenciasActionPerformed(evt);
            }
        });

        Btn_Empleados.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Empleados.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Empleados.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Empleados.setText("Empleados");
        Btn_Empleados.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 2));

        Btn_Clientes.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Clientes.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Clientes.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Clientes.setText("Clientes");
        Btn_Clientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 2));

        Btn_Vehiculos.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Vehiculos.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Vehiculos.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Vehiculos.setText("Vehiculos");
        Btn_Vehiculos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 2));

        Btn_Productos.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Productos.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Productos.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Productos.setText("Productos");
        Btn_Productos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 2));

        Btn_OrdenServicios.setBackground(new java.awt.Color(255, 255, 255));
        Btn_OrdenServicios.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_OrdenServicios.setForeground(new java.awt.Color(36, 204, 167));
        Btn_OrdenServicios.setText("Orden de Servicio");
        Btn_OrdenServicios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 2));
        Btn_OrdenServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_OrdenServiciosActionPerformed(evt);
            }
        });

        Btn_Facturas.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Facturas.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Facturas.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Facturas.setText("Facturas");
        Btn_Facturas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 2));

        Btn_Servicios.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Servicios.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Servicios.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Servicios.setText("Servicios");
        Btn_Servicios.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 2));
        Btn_Servicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ServiciosActionPerformed(evt);
            }
        });

        Btn_Actividades.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Actividades.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Actividades.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Actividades.setText("Actividades");
        Btn_Actividades.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 2));

        Perfiles.setBackground(new java.awt.Color(255, 0, 51));
        Perfiles.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Perfiles.setForeground(new java.awt.Color(255, 255, 255));
        Perfiles.setText("Salir");
        Perfiles.setBorderPainted(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btn_Agencias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btn_Empleados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btn_Clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btn_Vehiculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btn_Productos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btn_OrdenServicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btn_Facturas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btn_Servicios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Btn_Actividades, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Perfiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Agencias, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Servicios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Actividades, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Empleados, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Vehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Productos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_OrdenServicios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Btn_Facturas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Perfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 720));

        TF_Direccion.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        TF_Direccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 3));
        TF_Direccion.setEnabled(false);
        TF_Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_DireccionActionPerformed(evt);
            }
        });
        getContentPane().add(TF_Direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 410, 400, 35));

        TF_RifAg.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        TF_RifAg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 3));
        TF_RifAg.setEnabled(false);
        TF_RifAg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_RifAgActionPerformed(evt);
            }
        });
        getContentPane().add(TF_RifAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 360, 35));

        TF_RazonSocial.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        TF_RazonSocial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 3));
        TF_RazonSocial.setEnabled(false);
        TF_RazonSocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_RazonSocialActionPerformed(evt);
            }
        });
        getContentPane().add(TF_RazonSocial, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 400, 35));

        TF_Ciudad.setFont(new java.awt.Font("Helvetica", 1, 14)); // NOI18N
        TF_Ciudad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 3));
        TF_Ciudad.setEnabled(false);
        TF_Ciudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_CiudadActionPerformed(evt);
            }
        });
        getContentPane().add(TF_Ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, 400, 35));

        Btn_Encargado.setBackground(new java.awt.Color(36, 204, 167));
        Btn_Encargado.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Encargado.setForeground(new java.awt.Color(255, 255, 255));
        Btn_Encargado.setText("Encargado");
        Btn_Encargado.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        Btn_Encargado.setBorderPainted(false);
        Btn_Encargado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EncargadoActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Encargado, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 490, 140, 40));

        Btn_Buscar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/lupa(1).png"))); // NOI18N
        Btn_Buscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Btn_Buscar.setBorderPainted(false);
        Btn_Buscar.setContentAreaFilled(false);
        Btn_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_BuscarActionPerformed(evt);
            }
        });
        getContentPane().add(Btn_Buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 160, 30, 30));

        jLabel4.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 204, 167));
        jLabel4.setText("Dirección");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, 300, 35));

        jLabel5.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(36, 204, 167));
        jLabel5.setText("RIF");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 300, 35));

        jLabel6.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(36, 204, 167));
        jLabel6.setText("Razón Social");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 300, 35));

        jLabel7.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(36, 204, 167));
        jLabel7.setText("Ciudad");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 300, 35));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(36, 204, 167), 2), "Opciones", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Helvetica", 1, 14), new java.awt.Color(36, 204, 167))); // NOI18N
        jPanel3.setOpaque(false);

        Btn_Habilitar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Habilitar.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Habilitar.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Habilitar.setText("Habilitar");
        Btn_Habilitar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 204, 167), 2, true));
        Btn_Habilitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_HabilitarActionPerformed(evt);
            }
        });

        Btn_Nuevo.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Nuevo.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Nuevo.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Nuevo.setText("Nuevo");
        Btn_Nuevo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 204, 167), 2, true));
        Btn_Nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_NuevoActionPerformed(evt);
            }
        });

        Btn_Actuaizar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Actuaizar.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Actuaizar.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Actuaizar.setText("Actualizar");
        Btn_Actuaizar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 204, 167), 2, true));
        Btn_Actuaizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_ActuaizarActionPerformed(evt);
            }
        });

        Btn_Eliminar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Eliminar.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Eliminar.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Eliminar.setText("Eliminar");
        Btn_Eliminar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 204, 167), 2, true));
        Btn_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_EliminarActionPerformed(evt);
            }
        });

        Btn_Limpiar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_Limpiar.setFont(new java.awt.Font("Helvetica", 1, 17)); // NOI18N
        Btn_Limpiar.setForeground(new java.awt.Color(36, 204, 167));
        Btn_Limpiar.setText("Limpiar");
        Btn_Limpiar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(36, 204, 167), 2, true));
        Btn_Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_LimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(Btn_Habilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Actuaizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btn_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Btn_Habilitar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Actuaizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btn_Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 580, 750, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_AgenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_AgenciasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_AgenciasActionPerformed

    private void Btn_ServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ServiciosActionPerformed
        new VServicios().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Btn_ServiciosActionPerformed

    private void Btn_OrdenServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_OrdenServiciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Btn_OrdenServiciosActionPerformed

    private void TF_DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_DireccionActionPerformed

    private void TF_RifAgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_RifAgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_RifAgActionPerformed

    private void TF_RazonSocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_RazonSocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_RazonSocialActionPerformed

    private void TF_CiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_CiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_CiudadActionPerformed

    private void Btn_ActuaizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_ActuaizarActionPerformed
        if (!(this.TF_RifAg.getText().equals("")) && !(this.TF_RazonSocial.getText().equals("")) && !(this.TF_Ciudad.getText().equals("")) && !(this.TF_Direccion.getText().equals(""))) {
            
            String RIF = this.TF_RifAg.getText();
            String RazonS = this.TF_RazonSocial.getText(); 
            String Ciudad = this.TF_Ciudad.getText();
            String Direccion = this.TF_Direccion.getText();
            
            ag.actualizarAgencia(RIF, RazonS, Ciudad, Direccion);

        }else {
            JOptionPane.showMessageDialog(null, "Por favor rellene los campos faltantes", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Btn_ActuaizarActionPerformed

    private void Btn_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_BuscarActionPerformed
        if (!(this.TF_RifAg.getText().equals(""))) {
            
            String[] datosAr = ag.buscarAgencia(TF_RifAg.getText());
            
            this.TF_RazonSocial.setText(datosAr[0]);
            this.TF_Ciudad.setText(datosAr[1]);
            this.TF_Direccion.setText(datosAr[2]);
   
        }else {
            JOptionPane.showMessageDialog(null, "Por favor rellene los campos faltantes", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        if (!(this.TF_RazonSocial.getText().equals("")) && !(this.TF_Ciudad.getText().equals("")) && !(this.TF_Direccion.getText().equals(""))) {
            this.TF_RifAg.setEnabled(false);
        }
        else {
            JOptionPane.showMessageDialog(null, "Registro no encontrado","Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Btn_BuscarActionPerformed

    private void Btn_HabilitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_HabilitarActionPerformed
        this.TF_RifAg.setEnabled(true);
        this.TF_RazonSocial.setEnabled(true);
        this.TF_Ciudad.setEnabled(true);
        this.TF_Direccion.setEnabled(true);
    }//GEN-LAST:event_Btn_HabilitarActionPerformed

    private void Btn_LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_LimpiarActionPerformed
        this.TF_RifAg.setText("");
        this.TF_RazonSocial.setText("");
        this.TF_Ciudad.setText("");
        this.TF_Direccion.setText("");
        this.TF_RifAg.setEnabled(false);
        this.TF_RazonSocial.setEnabled(false);
        this.TF_Ciudad.setEnabled(false);
        this.TF_Direccion.setEnabled(false);
    }//GEN-LAST:event_Btn_LimpiarActionPerformed

    private void Btn_NuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_NuevoActionPerformed
        if (!(this.TF_RifAg.getText().equals("")) && !(this.TF_RazonSocial.getText().equals("")) && !(this.TF_Ciudad.getText().equals("")) && !(this.TF_Direccion.getText().equals(""))) {
            
            String RIF = this.TF_RifAg.getText();
            String RazonS = this.TF_RazonSocial.getText(); 
            String Ciudad = this.TF_Ciudad.getText();
            String Direccion = this.TF_Direccion.getText();
            
           ag.nuevoAgencia(RIF, RazonS, Ciudad, Direccion);
            
        }else {
            JOptionPane.showMessageDialog(null, "Por favor rellene los campos faltantes", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Btn_NuevoActionPerformed

    private void Btn_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EliminarActionPerformed
        if (!(this.TF_RifAg.getText().equals(""))) {
            String RIF = this.TF_RifAg.getText();

            ag.eliminarAgencia(RIF);
        }
    }//GEN-LAST:event_Btn_EliminarActionPerformed

    private void Btn_EncargadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_EncargadoActionPerformed
        if (!(this.TF_RifAg.getText().equals(""))) {
            
            String[] datosAr = ag.buscarAgencia(TF_RifAg.getText());
            
            this.TF_RazonSocial.setText(datosAr[0]);
            this.TF_Ciudad.setText(datosAr[1]);
            this.TF_Direccion.setText(datosAr[2]);
            
            if (!(this.TF_RazonSocial.getText().equals("")) && !(this.TF_Ciudad.getText().equals("")) && !(this.TF_Direccion.getText().equals(""))) {
                new VEncargado(TF_RifAg.getText()).setVisible(true);
                this.dispose();
            }
            else {
                JOptionPane.showMessageDialog(null, "Agencia no encontrada. Por favor, introduzca una agencia registrada o registre una nueva", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }  
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, introduzca el RIF","Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_Btn_EncargadoActionPerformed

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
            java.util.logging.Logger.getLogger(VAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VAgencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VAgencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_Actividades;
    private javax.swing.JButton Btn_Actuaizar;
    private javax.swing.JButton Btn_Agencias;
    private javax.swing.JButton Btn_Buscar;
    private javax.swing.JButton Btn_Clientes;
    private javax.swing.JButton Btn_Eliminar;
    private javax.swing.JButton Btn_Empleados;
    private javax.swing.JButton Btn_Encargado;
    private javax.swing.JButton Btn_Facturas;
    private javax.swing.JButton Btn_Habilitar;
    private javax.swing.JButton Btn_Limpiar;
    private javax.swing.JButton Btn_Nuevo;
    private javax.swing.JButton Btn_OrdenServicios;
    private javax.swing.JButton Btn_Productos;
    private javax.swing.JButton Btn_Servicios;
    private javax.swing.JButton Btn_Vehiculos;
    private javax.swing.JButton Perfiles;
    private javax.swing.JTextField TF_Ciudad;
    private javax.swing.JTextField TF_Direccion;
    private javax.swing.JTextField TF_RazonSocial;
    private javax.swing.JTextField TF_RifAg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
