/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import interfaces.IConexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rramirez
 */
public class ConexionBD implements IConexion{

    private String cadenaConexion;
    private String usuario;
    private String contrasena;

    public ConexionBD(String cadenaConexion, String usuario, String contrasena) {
        this.cadenaConexion = cadenaConexion;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    @Override
    public Connection crearConexion() throws SQLException {
        Connection c = DriverManager.getConnection(cadenaConexion, usuario, contrasena);
        return c;

    }
}
