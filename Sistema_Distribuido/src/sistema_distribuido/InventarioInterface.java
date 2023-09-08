/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistema_distribuido;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author JOSE DANIEL
 */
public interface InventarioInterface extends Remote {
 // Definición de los métodos remotos
    boolean solicitarProducto(String producto, int cantidad) throws RemoteException;
    int obtenerStock(String producto) throws RemoteException;   
}
