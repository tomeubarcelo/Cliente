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
import java.util.Scanner;

/**
 *
 * @author tomeu
 */
public class AplicacionClientes implements Serializable {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        Cliente clienteTomeu = new Cliente("43218383A", "Tomeu", "680968942", "tomeu.95@gmail.com", "06-11-1995");
        
        
        
        Scanner input = new Scanner(System.in);



  
        String vector[] = new String[5];

        for (int i = 0; i < vector.length; i++) {
            /*System.out.print("Id " + i + "\nDigite el nombre: ");
            nombre = input.next();
            edad = input.nextInt();
            vector[i] = nombre+" "+edad;*/
            System.out.println("Cliente "+i);
            Cliente cliente1 = new Cliente();

            String nombre = cliente1.pedirNombre();
            cliente1.setNombre(nombre);

            String nif = cliente1.pedirDni();
            cliente1.setNIF(nif);

            String telefono = cliente1.pedirTelefono();
            cliente1.setTelefono(telefono);

            String correo = cliente1.pedirCorreo();
            cliente1.setCorreo(correo);

            String fechaNac = cliente1.pedirFechaNacimiento();
            cliente1.setFechaNacimiento(fechaNac);

            String nombreCliente = ("Nombre: "+cliente1.getNombre());
            String nifCliente = ("NIF: "+cliente1.getNIF());
            String tlfCliente = ("Teléfono: "+cliente1.getTelefono());
            String correoCliente = ("Correo: "+cliente1.getCorreo());
            String fechaCliente = ("Fecha nacimiento: "+cliente1.getFechaNacimiento());
            
            vector[i] = nombreCliente+" | "+nifCliente+" | "+tlfCliente+" | "+correoCliente+" | "+fechaCliente;
            
            }
            for (String datos : vector) {
                System.out.println(datos);
                
                FileOutputStream fichero = null;

                try{
                    fichero = new FileOutputStream("datos.txt");
                    ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
                    tuberia.writeObject(datos);     
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
                
                
                
                
            }
        
 
        
            /*FileOutputStream fichero = null;

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
            */




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
