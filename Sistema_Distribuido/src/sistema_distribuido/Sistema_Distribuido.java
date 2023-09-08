/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema_distribuido;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 *
 * @author JOSE DANIEL
 */
public class Sistema_Distribuido {
    
   public static void main(String[] args) {  try {
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("Inventario", new InventarioImpl());
            System.out.println("Servidor listo...");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
        }
    }

}

    
    

