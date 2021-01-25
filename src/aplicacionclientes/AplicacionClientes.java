/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionclientes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

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

        //nombre
        Cliente cliente1 = new Cliente ();
        System.out.println("Cliente 1");
        
        String nombreCliente = pideNombre();
        try {
            cliente1.validaNombre(nombreCliente);
            cliente1.setNombre(nombreCliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        String dniCliente = pideDni();
        try {
            cliente1.validaDni(dniCliente);
            cliente1.setNIF(dniCliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        
        
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
 
        
        
        //leer objecto DEL FICHERO
        
        FileInputStream ficheroEntrada = null;
        Cliente c;
        
        try{
            ficheroEntrada = new FileInputStream("datos.txt");
            ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
            c = (Cliente)tuberiaEntrada.readObject();
            c.mostrarCliente();
        } catch(FileNotFoundException ex){
            ex.printStackTrace();
        } catch(IOException ex){
            ex.printStackTrace();
        } catch(ClassNotFoundException ex){
            ex.printStackTrace();
        } 
    }
    
    private static String pideNombre() {
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce tu nombre y apellidos.");
        String nombre = entradaScanner.nextLine();
        return nombre;
    }
    
    private static String pideDni() {
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce tu DNI.");
        String dni = entradaScanner.nextLine();
        return dni;
    }
    
}
