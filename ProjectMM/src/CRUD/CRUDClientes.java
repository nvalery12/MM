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
import javax.swing.JOptionPane;

/**
 *
 * @author Ernesto Antonio
 */
public class CRUDClientes {
    private final Connection conexion;
    
    
    public CRUDClientes(Connection conexion) {
        this.conexion = conexion;
    }

        
   
    //-------------------------BUSCAR UN CLIENTE-------------------------------------//
    public String[] buscarClientes(String CiCliente) {
        
        String[] datos = new String[3];
        
        try {
            String SQL = "SELECT * FROM clientes WHERE CedulaCt = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CiCliente);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                datos[0] = resultado.getString("CedulaCt");
                datos[1] = resultado.getString("NombreCt");                                                
                datos[2] = resultado.getString("EmailCt"); 
                datos[3] = resultado.getString("Telef1");
                datos[4] = resultado.getString("Telef2");
                datos[5] = resultado.getString("RifAg");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
        
        return datos;
    }
    //-----------------BUSCO CLIENTE REGISTRADO EN AGENCIA--------------------//
    public String buscarAgencia(int RifAg) {
        
        String RazonS = null;
        
        try {
            String SQL = "SELECT RazonS FROM agencias WHERE RifAg = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setInt(1, RifAg);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                RazonS = resultado.getString("RazonS");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la consulta" + e.getMessage());
        }
        
        return RazonS;
    }
    
    
    // ------------------------NUEVO CLIENTE---------------------------------------//
    public void nuevoClientes(String CedulaCt, String RifAg, String NombreCt, String EmailCt, String Telef1, String Telef2) {
        try {
            String SQL = "INSERT INTO clientes (CedulaCt, RifAg, NombreCt, EmailCt, Telef1, Telef2) VALUES (?,?,?,?,?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, CedulaCt);
            consulta.setString(2, RifAg);
            consulta.setString(3, NombreCt);
            consulta.setString(4, EmailCt);
            consulta.setString(5,Telef1);
            consulta.setString(6, Telef2);
     
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Cliente registrado");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    //----------------------------------ACTUALIZAR REGISTRO DE CLIENTE---------------------------//
    public void actualizarClientes(String CedulaCt, String RifAg ,String NombreCt, String EmailCt, String Telef1, String Telef2) {
        
        try {
            String SQL = "UPDATE clientes SET RifAg=?,NombreCt=?, EmailCt=?,Telef1=?,Telef2=? WHERE CedulaCt=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            
            consulta.setString(1, RifAg);
            consulta.setString(2, NombreCt);
            consulta.setString(3, EmailCt);
            consulta.setString(4,Telef1);
            consulta.setString(5, Telef2);
            consulta.setString(6, CedulaCt);
    
            consulta.execute();
            
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo al editar el registro" + e.getMessage());
        }
    }
    
    //-------------------ELIMINAR CLIENTE----------------------------------//
    public void eliminarCliente(String CedulaCt) {
        
        try {
            String SQL = "DELETE FROM Clientes WHERE CedulaCt=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CedulaCt);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo al editar el registro" + e.getMessage());
        }
    }
    
    
    
}
