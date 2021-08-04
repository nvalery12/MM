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
public class CRUDPersonal {
        private final Connection conexion;
    
        public CRUDPersonal(Connection conexion) {
            this.conexion = conexion;
        }
        
        
        //-------------------------BUSCAR UN PERSONAL-------------------------------------//
    public String[] buscarPersonal(String CIEmp) {
        
        String[] datos = new String[3];
        
        try {
            String SQL = "SELECT * FROM Personales WHERE CIEmp = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CIEmp);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                datos[0] = resultado.getString("CIEmp");
                datos[1] = resultado.getString("NombreEmp");                                                
                datos[2] = resultado.getString("DirecEmp"); 
                datos[3] = resultado.getString("SueldoEmp");
                datos[4] = resultado.getString("TelefEmp");
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
    
    // ------------------------SE CREA UN NUEVO MIEMBRO DE PERSONAL---------------------------------------//
    public void nuevoPersonal(String CIEmp,String RifAg, String NombEmp, String DirecEmp, float SueldoEmp, String TelefEmp) {
        try {
            String SQL = "INSERT INTO personales (CIEmp, RifAg, NombEmp, DirecEmp, SueldoEmp, TelefEmp) VALUES (?,?,?,?,?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, CIEmp);
            consulta.setString(2, RifAg);
            consulta.setString(3, NombEmp);
            consulta.setString(4, DirecEmp);
            consulta.setFloat(5,SueldoEmp);
            consulta.setString(6, TelefEmp);
           
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Personal registrado");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    //------------------------ACTUALIZAR EL REGISTRO DE UN PERSONAL---------------------------//
    public void actualizarPersonal(String CIEmp,String RifAg ,String NombEmp, String DirecEmp, float SueldoEmp, String TelefEmp) {
        
        try {
            String SQL = "UPDATE personales SET RifAg=?, NombEmp=?, DirecEmp=?,SueldoEmp=?,TelefEmp=? WHERE CIEmp=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            
            consulta.setString(1, RifAg);
            consulta.setString(2, NombEmp);
            consulta.setString(3, DirecEmp);
            consulta.setFloat(4,SueldoEmp);
            consulta.setString(5, TelefEmp);
            consulta.setString(6, CIEmp);
            
            consulta.execute();
            
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo al editar el registro" + e.getMessage());
        }
    }
    
    //-------------------ELIMINAR PERSONAL----------------------------------//
    public void eliminarPersonal(String CIEmp) {
        
        try {
            String SQL = "DELETE FROM personales WHERE CIEmp=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CIEmp);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo al editar el registro" + e.getMessage());
        }
    }
    
    
}
