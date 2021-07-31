package CRUD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CRUDAgServ {
    private final Connection conexion;
    
    public CRUDAgServ(Connection conexion) {
        this.conexion = conexion;
    }
    
    public String buscarCapacidad(String Serv, String Ag) {
        
        String capacidad = null;
        
        try {
            String SQL = "SELECT CapacServ FROM cuentan WHERE RIFAg = ? AND CodServ = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, Ag);
            consulta.setString(2, Serv);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                capacidad = resultado.getString("CapacServ");
            }                               
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo en la consulta" + e.getMessage());
        }
        return capacidad;
    }
    
    public void nuevoServAg (String Serv, String Ag, int Capac) {

        try {
            String SQL = "INSERT INTO cuentan (RIFAg, CodServ, CapacServ) VALUES (?,?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, Ag);
            consulta.setString(2, Serv);
            consulta.setInt(3, Capac);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registrado Exitoso");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    public void actualizarServAg (String Serv, String Ag, int Capac) {
        try {
            String SQL = "UPDATE cuentan SET CapacServ=? WHERE RIFAg=? AND CodServ=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setInt(1, Capac);
            consulta.setString(2, Ag);
            consulta.setString(3, Serv);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Actualización Exitosa");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    public void eliminarServAg (String Serv, String Ag) {
        try {
            String SQL = "DELETE FROM cuentan where RIFAg=? AND CodServ=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, Ag);
            consulta.setString(2, Serv);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Eliminación Exitosa");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
}
