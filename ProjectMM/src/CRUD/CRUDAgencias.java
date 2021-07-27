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

}
