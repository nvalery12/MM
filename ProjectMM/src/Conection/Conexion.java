package Conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection conectado = null;
    private String jdbc = "jdbc:postgresql://ec2-52-45-183-77.compute-1.amazonaws.com:5432/";
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conectado = DriverManager.getConnection(jdbc+"daksvjpbapbe2p", "cnyqltrjluraol", "5da2f0b395221c56dcc757270dbd431507fd55ec76cc2d4d99a8e13b577d9512");
            System.out.println("conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"error de conexion"+e.getMessage());
        }
        return conectado;
    }
}
