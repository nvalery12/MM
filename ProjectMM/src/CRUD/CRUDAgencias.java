package CRUD;

import Controlador.Conexion;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CRUDAgencias {  
    private final Connection conexion;

    public CRUDAgencias(Connection conexion) {
        this.conexion = conexion;
    }

    public String[] buscarAgencia(String RIFAg) {
        
        String[] datos = new String[3];
        
        try {
            String SQL = "SELECT * FROM agencias WHERE RIFAg = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, RIFAg);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                datos[0] = resultado.getString("RazonS");
                datos[1] = resultado.getString("CiudadL");                                                
                datos[2] = resultado.getString("DireccionAg");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
        
        return datos;
    }
    
    public void nuevoAgencia (String RIFAg, String RazonS, String CiudadL, String DireccionAg) {
        try {
            String SQL = "INSERT INTO agencias (RIFAg, RazonS, CiudadL, DireccionAg) VALUES (?,?,?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, RIFAg);
            consulta.setString(2, RazonS);
            consulta.setString(3, CiudadL);
            consulta.setString(4, DireccionAg);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Agencia Registrada");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    public void actualizarAgencia (String RIFAg, String RazonS, String CiudadL, String DireccionAg) {
        
        try {
            String SQL = "UPDATE agencias SET RazonS=?, CiudadL=?, DireccionAg=? WHERE RIFAg=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            
            consulta.setString(1, RazonS);
            consulta.setString(2, CiudadL);
            consulta.setString(3, DireccionAg);
            consulta.setString(4, RIFAg);
            
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro actualizado exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo al editar el registro" + e.getMessage());
        }
    }
    
    public void eliminarAgencia (String RIFAg) {
        
        try {
            String SQL = "DELETE FROM agencias where RIFAg=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, RIFAg);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo al editar el registro" + e.getMessage());
        }
    }

}
