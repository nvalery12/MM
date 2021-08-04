package CRUD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CRUDActividades {
    private final Connection conexion;
    
    public CRUDActividades(Connection conexion) {
        this.conexion = conexion;
    }
    
    public int obtenerUltActividad () {
        String SQL = "SELECT N_Conse FROM actividades ORDER BY N_Conse DESC LIMIT 1";
        int numeros = 0;
        try {
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            resultado.next();
            numeros = resultado.getInt("nrorequisicion");
            return numeros;
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la consulta" + e.getMessage());
        }
        return numeros;
    }
    
    public String[] buscarActividad(String CodServ, int NAct) {
        
        String[] datos = new String[4];
        
        try {
            String SQL = "SELECT * FROM actividades WHERE CodServ = ? AND N_Conse = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CodServ);
            consulta.setInt(1, NAct);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                datos[0] = resultado.getString("NombAc");
                datos[1] = resultado.getString("CapacidadAc");                                                
                datos[2] = resultado.getString("DescripAc");
                datos[3] = resultado.getString("MontoAc");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la consulta" + e.getMessage());
        }
        
        return datos;
    }
    
    
    public void nuevaActividad (String CodServ, int NAct, String NombAc, String DescAc, int CapAc, float Monto) {
        try {
            String SQL = "INSERT INTO actividades (CodServ, N_Conse, NombAc, CapacidadAc, DescripAc, MontoAc) VALUES (?,?,?,?,?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, CodServ);
            consulta.setInt(2, NAct);
            consulta.setString(3, NombAc);
            consulta.setInt(4, CapAc);
            consulta.setString(5, DescAc);
            consulta.setFloat(6, Monto);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Actividad Registrada");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    public void actualizarActividad (String CodServ, int NAct, String NombAc, String DescAc, int CapAc, float Monto) {
        try {
            String SQL = "UPDATE actividades SET NombAc=? CapacidadAc=? DescripAc=? MontoAc=? WHERE CodServ=? AND NAct=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, NombAc);
            consulta.setInt(2, CapAc);
            consulta.setString(3, DescAc);
            consulta.setFloat(4, Monto);
            consulta.setString(5, CodServ);
            consulta.setInt(6, NAct);
            consulta.execute();
            
            JOptionPane.showMessageDialog(null, "Actividad Actualizada");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    public void eliminarEncargado (String CodServ, int NAct) {
        try {
            String SQL = "DELETE FROM actividades WHERE CodServ=? AND NAct=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CodServ);
            consulta.setInt(2, NAct);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo al editar el registro" + e.getMessage());
        }
    }
}









































