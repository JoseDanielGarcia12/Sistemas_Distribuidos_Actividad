/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_distribuido;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author JOSE DANIEL
 */
public class Cliente {
public static void main(String[] args) {
        try {
            // Obtener el registro RMI en el servidor
            Registry registro = LocateRegistry.getRegistry("localhost", 1099);

            // Buscar el objeto remoto por su nombre
            InventarioInterface inventario = (InventarioInterface) registro.lookup("Inventario");

            // Realizar solicitudes de productos
            String producto = "Helado de vainilla";
            int cantidad = 10;

            if (inventario.solicitarProducto(producto, cantidad)) {
                System.out.println("Solicitud atendida: " + cantidad + " " + producto + " entregados.");
            } else {
                System.out.println("Solicitud no atendida: " + producto + " no disponible en la cantidad solicitada.");
            }

            // Obtener el stock actual
            int stock = inventario.obtenerStock(producto);
            System.out.println("Stock actual de " + producto + ": " + stock);

        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.toString());
        }
    }
}    

