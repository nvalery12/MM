package CRUD;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CRUDServicios {
    private final Connection conexion;

    public CRUDServicios(Connection conexion) {
        this.conexion = conexion;
    }
    
    //Buscar Servicio
    public String[] buscarServicio(String CodigoServ) {     
        String[] datos = new String[8];
        try {
            String SQL = "SELECT * FROM servicios WHERE CodServ = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CodigoServ);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                datos[0] = resultado.getString("RIFAg");
                datos[1] = resultado.getString("CIEmp");                                                
                datos[2] = resultado.getString("NombServ");
                datos[3] = resultado.getString("DescServ");
                datos[4] = resultado.getString("TiempoResv");
                datos[5] = resultado.getString("MontoServ");
                datos[6] = resultado.getString("CapacServ");
            }                            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Consulta fallida " + e.getMessage());
        }
        return datos;
    }
    
    public String[] buscarServicioEnc(String CodigoServ, String Agencia) {     
        String[] datos = new String[8];
        try {
            String SQL = "SELECT * FROM servicios WHERE CodServ = ? AND RIFAg = ?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CodigoServ);
            ResultSet resultado = consulta.executeQuery();
            
            while (resultado.next()) {
                datos[0] = resultado.getString("CIEmp");                                                
                datos[1] = resultado.getString("NombServ");
                datos[2] = resultado.getString("DescServ");
                datos[3] = resultado.getString("TiempoResv");
                datos[4] = resultado.getString("MontoServ");
                datos[5] = resultado.getString("CapacServ");
            }                            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Consulta fallida " + e.getMessage());
        }
        return datos;
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
    
    public void nuevoServicio (String CodServ, String RIFAg, int CIEmp, String NombServ, String DescServ, String TiempoResv, float MontoServ, int CapacServ) {
        try {
            String SQL = "INSERT INTO servicios (CodServ, RIFAg, CIEmp, NombServ, DescServ, TiempoResv, MontoServ, CapacServ) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setString(1, CodServ);
            consulta.setString(2, RIFAg);
            consulta.setInt(3, CIEmp);
            consulta.setString(4, NombServ);
            consulta.setString(5, DescServ);
            consulta.setString(6, TiempoResv);
            consulta.setFloat(7, MontoServ);
            consulta.setInt(8, CapacServ);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Registrado Exitoso");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    public void actualizarServicio (String CodServ, String RIFAg, int CIEmp, String NombServ, String DescServ, String TiempoResv, float MontoServ, int CapacServ) {
        try {
            String SQL = "UPDATE servicios SET CodServ=? RIFAg=? CIEmp=? NombServ=? DescServ=? TiempoResv=? MontoServ=? CapacServ=? WHERE CodServ=? AND RIFAg=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);

            consulta.setInt(1, CIEmp);
            consulta.setString(2, NombServ);
            consulta.setString(3, DescServ);
            consulta.setString(4, TiempoResv);
            consulta.setFloat(5, MontoServ);
            consulta.setInt(6, CapacServ);
            consulta.setString(7, CodServ);
            consulta.setString(8, RIFAg);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Actualización Exitosa");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
    public void eliminarServicio (String CodServ) {
        try {
            String SQL = "DROP FROM servicios WHERE CodServ=?";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            consulta.setString(1, CodServ);
            consulta.execute();
            JOptionPane.showMessageDialog(null, "Eliminación Exitosa");

        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
    }
    
}

































