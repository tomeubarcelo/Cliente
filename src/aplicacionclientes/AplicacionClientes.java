/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionclientes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
        
        Cliente clienteTomeu = new Cliente("43218383A", "Tomeu", "680968942", "tomeu.95@gmail.com", "06-11-1995");
        
        /*System.out.println(cliente1.getNIF());
        System.out.println(cliente1.getNombre());
        System.out.println(cliente1.getTelefono());
        System.out.println(cliente1.getCorreo());
        System.out.println(cliente1.getFechaNacimiento());

        cliente1.setNombre(cliente1.pedirNombre());
        System.out.println(cliente1.getNombre());*/

        System.out.println("Cliente 1");
        Cliente cliente1 = new Cliente();
        
        //nombre
        String nombre =  cliente1.getNombre();
        cliente1.validaNombre(nombre);
        cliente1.setNombre(nombre);
        
        String nif = cliente1.pedirDni();
        cliente1.setNIF(nif);
        
        String telefono = cliente1.pedirTelefono();
        cliente1.setTelefono(telefono);
        
        String correo = cliente1.pedirCorreo();
        cliente1.setCorreo(correo);
        
        String fechaNac = cliente1.pedirFechaNacimiento();
        cliente1.setFechaNacimiento(fechaNac);
        
        System.out.println("Nombre: "+cliente1.getNombre());
        System.out.println("NIF: "+cliente1.getNIF());
        System.out.println("Teléfono: "+cliente1.getTelefono());
        System.out.println("Correo: "+cliente1.getCorreo());
        System.out.println("Fecha nacimiento: "+cliente1.getFechaNacimiento());
        
        
        FileOutputStream fichero = null;
        
        try{
            fichero = new FileOutputStream("datos.txt");
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            tuberia.writeObject(cliente1);     
        } catch(FileNotFoundException ex){
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        } finally{
            try{
               fichero.close();   
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
        
      
        
        
        
        /*
        System.out.println("---------\nCliente 2");
        Cliente cliente2 = new Cliente();
        System.out.println(cliente2);
        
        Cliente cliente3 = new Cliente();
        System.out.println(cliente3);
        
        Cliente cliente4 = new Cliente();
        System.out.println(cliente4);
        */
    }
    
}
