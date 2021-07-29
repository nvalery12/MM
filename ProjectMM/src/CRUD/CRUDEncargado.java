package CRUD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;

public class CRUDEncargado {
    private final Connection conexion;
    
    public CRUDEncargado(Connection conexion) {
        this.conexion = conexion;
    }
    
    public String buscarEmpleado(int CIEncargado) {
        
        String nombreEmp = null;
        
        try {
            String SQL = "SELECT NombreEmp FROM empleados WHERE CIEmp = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setInt(1, CIEncargado);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                nombreEmp = resultado.getString("NombreEmp");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la consulta" + e.getMessage());
        }
        
        return nombreEmp;
    }
    
    public String buscarEmpleadoRegistrado(String RifAgencia) {
        
        String CIEmp = null;
        
        try {
            String SQL = "SELECT CIEncargado FROM encargado WHERE RIFAg = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, RifAgencia);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                CIEmp = resultado.getString("CIEncargado");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la consulta" + e.getMessage());
        }
        
        return CIEmp;
    }
    
        
    public Date FechaEncargado(String RifAgencia) {
        
        Date fecha = null;
        
        try {
            String SQL = "SELECT FechaEnc FROM encargado WHERE RIFAg = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, RifAgencia);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                fecha = resultado.getDate("FechaEnc");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la consulta" + e.getMessage());
        }
        
        return fecha;
    }
    
    public void nuevoEncargado (String RIFAg, int CIEnc, String FechaEnc) {
        long fechaLong1 = java.util.Date.parse(FechaEnc);
            java.sql.Date fechaDate1 = new java.sql.Date(fechaLong1);
        
        try {
            String SQL = "INSERT INTO encargado (RIFAg, CIEncargado, FechaEnc) VALUES (?,?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, RIFAg);
            consulta.setInt(2, CIEnc);
            consulta.setDate(3, fechaDate1);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Encargado Registrado");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    public void actualizarEncargado (String RIFAg, int CIEnc, String FechaEnc) {
        long fechaLong1 = java.util.Date.parse(FechaEnc);
        java.sql.Date fechaDate1 = new java.sql.Date(fechaLong1);
        try {
            String SQL = "UPDATE encargado SET CIEncargado=? FechaEnc=? WHERE RIFAg=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, RIFAg);
            consulta.setDate(2, fechaDate1);
            consulta.setInt(3, CIEnc);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Encargado Actualizado");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    public void eliminarEncargado (String RIFAg) {
        try {
            String SQL = "DELETE FROM encargado where RIFAg=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, RIFAg);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registro eliminado exitosamente");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Fallo al editar el registro" + e.getMessage());
        }
    }
}
