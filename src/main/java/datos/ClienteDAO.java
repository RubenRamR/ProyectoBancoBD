/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import PersistenciaException.PersistenciaException;
import interfaces.IClientes;
import interfaces.IConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetos.Cliente;

/**
 *
 * @author rramirez
 */
public class ClienteDAO implements IClientes {

    private final IConexion conexion;
    private static final Logger LOG = Logger.getLogger(ClienteDAO.class.getName());

    public ClienteDAO(IConexion conexion) {
        this.conexion = conexion;
    }

    @Override
    public Cliente registrarCliente(Cliente c) throws PersistenciaException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Obtener la conexión
            conn = conexion.crearConexion();

            // Consulta SQL para insertar un nuevo cliente en la tabla CLIENTES
            String sql = "INSERT INTO CLIENTES (id_cliente, nombre, fecha_nacimiento, direccion, edad) VALUES (?, ?, ?, ?, ?)";

            // Preparar la sentencia SQL con los valores del cliente
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, c.getId_cliente());
            stmt.setString(2, c.getNombre().toString());
            stmt.setDate(3, c.getFechaNacimiento());
            stmt.setString(4, c.getDireccion().toString()); // Aquí se utiliza el método toString de Direccion
            stmt.setInt(5, c.getEdad());

            // Ejecutar la sentencia de inserción
            stmt.executeUpdate();

            // Devolver el cliente registrado
            return c;
        } catch (SQLException e) {
            // Manejo de excepciones SQLException
            LOG.log(Level.SEVERE, "Error al registrar cliente en la base de datos", e);
            throw new PersistenciaException("Error al registrar cliente en la base de datos");
        } finally {
            // Cerrar recursos (ResultSet, PreparedStatement, Connection)
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Manejo de excepciones SQLException al cerrar recursos
                LOG.log(Level.SEVERE, "Error al cerrar recursos de base de datos", e);
                throw new PersistenciaException("Error al cerrar recursos de base de datos");
            }
        }
    }
    /*String createCliente = "INSERT INTO CLIENTES (nombre, fecha_nacimiento, direccion, edad) VALUES (?, ?, ?, ?)";
        Cliente resultado = null;
        
        try {
            Connection co = conexion.crearConexion();
            PreparedStatement insert = co.prepareStatement(createCliente, Statement.RETURN_GENERATED_KEYS);

            insert.setString(1, c.getNombre());
            insert.setDate(2, c.getFechaNacimiento());
            insert.setString(3, c.getDireccion().toString());
            insert.setLong(4, c.getEdad());

            System.out.println("Cliente agregado");
            insert.executeUpdate();

            ResultSet res = insert.getGeneratedKeys();

            if (res.next()) {
                int id = res.getInt(1);
                resultado = buscarClienteId(id);
                return resultado;
            }
        } catch (SQLException e) {
            LOG.log(Level.SEVERE, e.getMessage());
            throw new PersistenciaException("No fue posible agregar el cliente" + e.getMessage());
        }

        return resultado;*/


@Override
public boolean eliminarCliente(Cliente c) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
public Cliente actualizarCliente(Cliente c) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
public Cliente buscarClienteId(int id) throws PersistenciaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
