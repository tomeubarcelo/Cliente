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

        
        Cliente cliente1 = new Cliente ();
        System.out.println("Cliente 1");
        boolean sal = false;
        
        //NOMBRE CLIENTE
        do {   
        String nombreCliente = pideNombre();
            try {
                cliente1.validaNombre(nombreCliente);    
                boolean formatoCorrecto = cliente1.validaNombre(nombreCliente);
                if (formatoCorrecto) {
                    cliente1.setNombre(nombreCliente);
                    sal = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!sal);
        
        //DNI CLIENTE
        do {  
        sal = false;
        String dniCliente = pideDni();
            try {
                cliente1.validaDni(dniCliente);
                //System.out.println(cliente1.validaDni(dniCliente));
                boolean formatoCorrecto = cliente1.validaDni(dniCliente);
                if (formatoCorrecto) {
                    cliente1.setNIF(dniCliente);
                    sal = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!sal);
        
        
        
        //TELEFONO CLIENTE
        do {  
            sal = false;
            String tlfCliente = pideTelefono();
            try {
                cliente1.validaTelefono(tlfCliente);

                //System.out.println(cliente1.validaDni(dniCliente));
                boolean formatoCorrecto = cliente1.validaTelefono(tlfCliente);
                if (formatoCorrecto) {
                    cliente1.setTelefono(tlfCliente);
                    sal = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!sal);
                  
        //CORREO CLIENTE
        do {  
            sal = false;
            String correoCliente = pideCorreo();
            try {
                cliente1.validaCorreo(correoCliente);
                //System.out.println(cliente1.validaDni(dniCliente));
                boolean formatoCorrecto = cliente1.validaCorreo(correoCliente);
                if (formatoCorrecto) {
                    cliente1.setCorreo(correoCliente);
                    sal = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!sal);
        

        
        //FECHA NACIMIENTO CLIENTE
        do {  
            sal = false;
            String fechaNacCliente = pideFechaNacimiento();
            try {
                cliente1.validaFechaNacimiento(fechaNacCliente);
                //System.out.println(cliente1.validaDni(dniCliente));
                boolean formatoCorrecto = cliente1.validaFechaNacimiento(fechaNacCliente);
                if (formatoCorrecto) {
                    cliente1.setFechaNacimiento(fechaNacCliente);
                    sal = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (!sal);
        
        
        
        
        
        
        //FICHEROS
        
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
    
    private static String pideTelefono(){
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce tu teléfono.");
        String tlf = entradaScanner.nextLine();
        return tlf;
    }
    
    private static String pideCorreo(){
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce tu correo electronico.");
        String correo = entradaScanner.nextLine();
        return correo;
    }
    
    private static String pideFechaNacimiento(){
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce tu fecha de nacimiento.");
        String fechaNac = entradaScanner.nextLine();
        return fechaNac;
    }
    
}
