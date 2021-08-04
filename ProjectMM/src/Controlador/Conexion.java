package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection conectado = null;
    private final String jdbc = "jdbc:postgresql://bomwkcx4qq4x36fdptvh-postgresql.services.clever-cloud.com/";
    public Connection conectar() {
        try {
            Class.forName("org.postgresql.Driver");
            conectado = DriverManager.getConnection(jdbc+"bomwkcx4qq4x36fdptvh", "uivxvwoutflbwrvyc5jm", "t1PlcfIVbGp5U0AHxwkE");
            System.out.println("conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,"error de conexion "+e.getMessage());
        }
        return conectado;
    }
}