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
    
    public String buscarEmpleado(String CIEncargado) {
        
        String nombreEmp = null;
        
        try {
            String SQL = "SELECT NombreEmp FROM empleados WHERE CIEmp = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CIEncargado);
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
    
    public void nuevoEncargado (String RIFAg, String CIEnc, Date FechaEnc) {
        try {
            String SQL = "INSERT INTO encargado (RIFAg, CIEncargado, FechaEnc) VALUES (?,?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, RIFAg);
            consulta.setString(2, CIEnc);
            consulta.setDate(3, (java.sql.Date) FechaEnc);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Encargado Registrado");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
}
