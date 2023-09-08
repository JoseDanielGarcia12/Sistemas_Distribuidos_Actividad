/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_distribuido;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author JOSE DANIEL
 */
     public class InventarioImpl extends UnicastRemoteObject implements InventarioInterface {
    private Map<String, Integer> inventario;
   

    public InventarioImpl() throws RemoteException {
        // Inicializar el inventario con productos y cantidades
        inventario = new HashMap<>();
        inventario.put("Helado de vainilla", 50);
        inventario.put("Helado de chocolate", 30);
        inventario.put("Helado de fresa", 40);
        inventario.put("Helado de cookies", 20);
        inventario.put("Helado de mango", 15);
    }

    public synchronized boolean solicitarProducto(String producto, int cantidad) throws RemoteException {
        // Procesar la solicitud y manejar la disponibilidad del producto
        if (inventario.containsKey(producto) && inventario.get(producto) >= cantidad) {
            inventario.put(producto, inventario.get(producto) - cantidad);
            return true; // Solicitud atendida
             } else {
            return false; // Solicitud no atendida (producto no disponible en la cantidad solicitada)
        }
    }

    public synchronized int obtenerStock(String producto) throws RemoteException {
        // Obtener la cantidad actual de un producto en el inventario
        return inventario.getOrDefault(producto, 0);
    }
    
}
