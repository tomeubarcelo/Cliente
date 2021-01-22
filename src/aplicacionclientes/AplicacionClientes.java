/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionclientes;

/**
 *
 * @author tomeu
 */
public class AplicacionClientes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        Cliente cliente1 = new Cliente("43218383A", "Tomeu", 680968942, "tomeu.95@gmail.com", "06-11-1995");
        
        System.out.println(cliente1.getNIF());
        System.out.println(cliente1.getNombre());
        System.out.println(cliente1.getTelefono());
        System.out.println(cliente1.getCorreo());
        System.out.println(cliente1.getFechaNacimiento());
        
        cliente1.setNombre(cliente1.pedirNombre());
        System.out.println(cliente1.getNombre());
    }
    
}
