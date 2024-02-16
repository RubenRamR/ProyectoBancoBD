/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import PersistenciaException.PersistenciaException;
import objetos.Cliente;

/**
 *
 * @author rramirez
 */
public interface IClientes {
    
    Cliente registrarCliente(Cliente c) throws PersistenciaException;

    boolean eliminarCliente(Cliente c) throws PersistenciaException;

    Cliente actualizarCliente(Cliente c) throws PersistenciaException;

    Cliente buscarClienteId(int id) throws PersistenciaException;
    
}
