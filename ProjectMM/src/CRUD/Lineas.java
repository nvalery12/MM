/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Controlador.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Noel Roberto
 */
public class Lineas {
    private final Connection conexion;
    
    public Lineas(Connection conexion){
        this.conexion = conexion;
    }
    
    public String buscarLinea(String codigo){
        String info = new String();
        try {
            String sQL = "SELECT * FROM lineasuministros WHERE CodLS = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sQL);
            consulta.setString(1, codigo);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                info = resultado.getString("NombLS");                                              
            }     
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
        
        return info;
    }
    
    public void agregarLinea(String codLS,String nombLS){
        try {
            String sQL = "INSERT INTO lineasuministros(CodLS,NombLS)"
                    + "VALUES(?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(sQL);
            consulta.setString(1, codLS);
            consulta.setString(2, nombLS);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Linea añadida con exito.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo del registro: " + e.getMessage());
        }
    }
    
    public void updateLinea(String codLS,String nombLS){
        try {
            String sQL = "UPDATE lineasuministros "
                    + "SET NombLS = ?"
                    + "WHERE CodLS = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sQL);
            consulta.setString(1, nombLS);
            consulta.setString(2, codLS);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado correctamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el resgisto: "+e.getMessage());
        }
    }
    
    public void deleteLinea(String codLS){
        try {
            String sQL = "DELETE FROM lineasuministros "
                    + "WHERE CodLS = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(sQL);
            consulta.setString(1, codLS);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el registro: "+e.getMessage());
        }
    }
    
}
