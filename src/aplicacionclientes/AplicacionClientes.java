/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionclientes;

import java.util.ArrayList;
import java.util.Iterator;

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
        
        //Cliente cliente1 = new Cliente("43218383A", "Tomeu", 680968942, "tomeu.95@gmail.com", "06-11-1995");
        
        /*System.out.println(cliente1.getNIF());
        System.out.println(cliente1.getNombre());
        System.out.println(cliente1.getTelefono());
        System.out.println(cliente1.getCorreo());
        System.out.println(cliente1.getFechaNacimiento());
        
        cliente1.setNombre(cliente1.pedirNombre());
        System.out.println(cliente1.getNombre());*/
        
        /*ArrayList arrayClientes = new ArrayList();

        for (int i=0; i < 5; i++) {
            Cliente cliente2 = new Cliente();
            arrayClientes.add( cliente2 );
        }
        Iterator it = arrayClientes.iterator();
        while ( it.hasNext() ) {
        Object objeto = it.next();
        Cliente producto = (Cliente)objeto;
        System.out.println(producto);
        }
        for (int i=0; i < arrayClientes.size(); i++) {
            System.out.println(i+" - "+arrayClientes.get(i));
        }
        System.out.println(arrayClientes.size());
        */
        System.out.println("Cliente 1");
        Cliente cliente1 = new Cliente();
        String nombre = cliente1.pedirNombre();
        String nif = cliente1.pedirDni();
        cliente1.setNombre(nombre);
        cliente1.setNIF(nif);
        
        String telefono = cliente1.pedirTelefono();
        cliente1.setTelefono(telefono);
        
        String correo = cliente1.pedirCorreo();
        cliente1.setCorreo(correo);
        
        
        System.out.println("Nombre: "+cliente1.getNombre());
        System.out.println("NIF: "+cliente1.getNIF());
        System.out.println("Teléfono: "+cliente1.getTelefono());
        System.out.println("Correo: "+cliente1.getCorreo());

        
        
        
        
        
        
        
        
        
        
        
        
        System.out.println("---------\nCliente 2");
        Cliente cliente2 = new Cliente();
        System.out.println(cliente2);
        
        Cliente cliente3 = new Cliente();
        System.out.println(cliente3);
        
        Cliente cliente4 = new Cliente();
        System.out.println(cliente4);
    }
    
}
