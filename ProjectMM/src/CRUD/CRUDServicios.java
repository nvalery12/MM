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
    
    //Agencias
    public void obtenerLinea(JComboBox cb) {
        try {
            String SQL = "SELECT * FROM agencias ORDER BY RazonS ASC";
            PreparedStatement consulta = this.conexion.prepareStatement(SQL);
            ResultSet resultado = consulta.executeQuery();
            cb.addItem("Seleccione una opcion");
            
            while (resultado.next()) {
                cb.addItem(resultado.getString("RazonS"));
            }
        } catch (Exception ex) {

        }
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
                datos[0] = resultado.getString("Descripcion");
                datos[1] = resultado.getString("CodLinea");                                                
                datos[2] = resultado.getString("Precio");
                datos[3] = resultado.getString("Existencia");
                datos[4] = resultado.getString("Minimo");
                datos[5] = resultado.getString("Maximo");
                datos[6] = resultado.getString("StatusA");
            }                            
            
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo del Registro" + e.getMessage());
        }
        
        return datos;
    }
    
}

































