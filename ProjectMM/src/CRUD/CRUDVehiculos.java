/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class CRUDVehiculos {  
    private final Connection conexion;

    public CRUDVehiculos(Connection conexion) {
        this.conexion = conexion;
    }
    
    //------------------------------BUSCO VEHICULO---------------------------------------------//
    public String[] buscarVehiculos(String CodVeh) {
        
        String[] datos = new String[4];
        
        try {
            String SQL = "SELECT * FROM vehiculos WHERE CodVeh = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CodVeh);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                datos[0] = resultado.getString("PlacaVeh");
                datos[1] = resultado.getString("AceiteUt");                                                
                datos[2] = resultado.getString("MarcaVeh");
                datos[3] = resultado.getString("ModeloVeh");
                datos[4] = resultado.getString("CICliente");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
        
        return datos;
    }
    //---------------------BUSCO CLIENTE DUEÑO DEL VEHICULO------------------------------//
     public String buscarCliente(int CICliente) {
        
        String NombreCt = null;
        
        try {
            String SQL = "SELECT NombreCt FROM clientes WHERE CedulaCt = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setInt(1, CICliente);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                NombreCt = resultado.getString("NombreCt");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la consulta" + e.getMessage());
        }
        
        return NombreCt;
    }
     //------------------FUNCION DATE--------------------------------------------------//
     public Date FechaAdq(String CICliente) {
        
        Date fecha = null;
        
        try {
            String SQL = "SELECT FechaAdq FROM vehiculos WHERE CodVeh = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CICliente);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                fecha = resultado.getDate("FechaAdq");
            }               
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la consulta" + e.getMessage());
        }
        
        return fecha;
    }
     
    
    //----------------------NUEVOS VEHICULOS--------------------------------//
    public void nuevoVehiculos (String CodVeh,String CICliente, String PlacaVeh, String AceiteUt, String FechaAdq, String MarcaVeh, String ModeloVeh) {
        try {
            String SQL = "INSERT INTO vehiculos (CodVeh, CedulCt, PlacaVeh, AceiteUt, FechaAdq, MarcaVeh, ModeloVeh) VALUES (?,?,?,?,?,?,?)"; //Revisar orden
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, CodVeh);
            consulta.setString(2, CICliente);
            consulta.setString(3, PlacaVeh);
            consulta.setString(4, AceiteUt);
            consulta.setString(5,FechaAdq); 
            consulta.setString(6, MarcaVeh);
            consulta.setString(7, ModeloVeh);

            consulta.execute();
            JOptionPane.showMessageDialog(null, "Vehiculo Registrado");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    //--------------------------ACTUALIZO VEHICULOS------------------------------------------//
    public void actualizarVehiculos(String CodVeh,String CICliente ,String PlacaVeh, String AceiteUt, String FechaAdq, String MarcaVeh, String ModeloVeh) {
        
        try {
            String SQL = "UPDATE vehiculos SET CedulCt=?, PlacaVeh=?, AceiteUt=?, FechaAdq=?,MarcaVeh=?,ModeloVeh=? WHERE CodVeh=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            
            consulta.setString(1, CICliente);
            consulta.setString(2, PlacaVeh);
            consulta.setString(3, AceiteUt);
            consulta.setString(4,FechaAdq); 
            consulta.setString(5, MarcaVeh);
            consulta.setString(6, ModeloVeh);
            consulta.setString(7, CodVeh);

            
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo al editar el registro" + e.getMessage());
        }
    }
    
    //-------------------ELIMINO VEHICULO-------------------------------------//
    public void eliminarVehiculo (String CodVeh) {
        
        try {
            String SQL = "DELETE FROM vehiculos WHERE CodVeh=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CodVeh);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo al editar el registro" + e.getMessage());
        }
    }
    

}