/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
/**
 *
 * @author Noel Roberto
 */
public class Productos {
    private final Connection conexion;
    
    public Productos(Connection conexion){
        this.conexion = conexion;
    }
    
    public void obtenerLinea(JComboBox cb) {
        try {
            String SQL = "SELECT * FROM lineasuministros ORDER BY NombLS ASC";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            while (resultado.next()) {
                cb.addItem(resultado.getString("NombLS"));
            }
        } catch (Exception ex) {

        }
    }

    //BUSCAR CON EL NOMBRE DE LINEA DE SUMINISTRO, EL CODIGO 
    public String busquedaLinea(String descripcionl) {

        String codigolinea = "";
        try {
            String SQL = "SELECT CodLS FROM lineasuministros WHERE NombLS = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, descripcionl);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {                                       
                codigolinea = resultado.getString("CodLS");
            }
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo en consulta" + e.getMessage());
        }
        return codigolinea;
    }
    
    public String[] obtenerProducto(String codPr){
        String[] info = new String[9];
        
        try {
            String sQL = "SELECT * "
                    + "FROM productos "
                    + "WHERE CodPr = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sQL);
            consulta.setString(1, codPr);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                info[0]=resultado.getString("NombPr");
                info[1]=resultado.getString("CodLS");
                info[2]=resultado.getString("MaxPr");
                info[3]=resultado.getString("MinPr");
                info[4]=resultado.getString("PrecioPr");
                info[5]=resultado.getString("EcoPr");
                info[6]=resultado.getString("DescPr");
                info[7]=resultado.getString("FabriPr");
                info[8]=resultado.getString("CantActual");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro: "+e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
        
        return info;
    }
    
    public void agregarProductor(String codPr,String nombPr,String codLS,int maxPr,int minPr,float precioPr,String ecoPr,String descPr,String fabriPr,int cantActual){
        try {
            String sQL = "INSERT INTO productos(CodPr,NombPr,CodLS,MaxPr,MinPr,PrecioPr,EcoPr,DescPr,FabriPr,CantActual) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(sQL);
            consulta.setString(1, codPr);
            consulta.setString(2, nombPr);
            consulta.setString(3, codLS);
            consulta.setInt(4, maxPr);
            consulta.setInt(5, minPr);
            consulta.setFloat(6, precioPr);
            consulta.setString(7, ecoPr);
            consulta.setString(8, descPr);
            consulta.setString(9, fabriPr);
            consulta.setInt(10, cantActual);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Producto Registrado con Exito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro: "+e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateProducto(String codPr,String nombPr,String codLS,int maxPr,int minPr,float precioPr,String ecoPr,String descPr,String fabriPr,int cantActual){
        try {
            String sQL = "UPDATE productos "
                    + "SET NombPr = ?, CodLS = ?, MaxPr = ?, MinPr = ?,PrecioPr = ?,EcoPr = ?,DescPr = ?,FabriPr = ?,CantActual = ? "
                    + "WHERE CodPr = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sQL);
            consulta.setString(1, nombPr);
            consulta.setString(2, codLS);
            consulta.setInt(3, maxPr);
            consulta.setInt(4, minPr);
            consulta.setFloat(5, precioPr);
            consulta.setString(6, ecoPr);
            consulta.setString(7, descPr);
            consulta.setString(8, fabriPr);
            consulta.setInt(9, cantActual);
            consulta.setString(10, codPr);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Producto Registrado con Exito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro: "+e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void deletePr(String codPr){
        try {
            String sQL = "DELETE FROM productos "
                    + "WHERE CodPr = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sQL);
            consulta.setString(1, codPr);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Producto Registrado con Exito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro: "+e.getMessage(), "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }
}
