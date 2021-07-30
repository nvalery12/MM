package CRUD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CRUDInicioSesion {
    private final Connection conexion;
    
    public CRUDInicioSesion(Connection conexion) {
        this.conexion = conexion;
    }
    
    public String rifEmpleado(int Cedula) {
        String rifAgencia = null;
        
        try {
            String SQL = "SELECT RIFAg FROM empleados WHERE CIEmp = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setInt(1, Cedula);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                rifAgencia = resultado.getString("RIFAg");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la consulta" + e.getMessage());
        }
        
        return rifAgencia;
    }
}
