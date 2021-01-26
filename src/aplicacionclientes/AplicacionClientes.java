/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionclientes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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

        final String PATH = "clientes.txt";
        
        Cliente cliente1 = new Cliente ();
        
        // instanciamos la clase de solicitudes por teclado
        FuncionamientoApp solicitud = new FuncionamientoApp();
        
        byte opcio;
        do { 
            opcio = solicitud.menuOpcions(); //mostra les opcions de menú i retorna l'opció escollida
            switch (opcio) {
                case 1: 

                    System.out.println("Cliente 1");
                    boolean sal = false;
                    
                    // comprobamos que existe el fichero para cargar los datos si es que existe
                    File fich = new File(PATH);
                    if (fich.exists()){
                        System.err.println("Ya existe el fichero");
                        throw new Exception("Ya existe el fichero");
                    }
                    //FIN COMPROBAR
                    
                    //NOMBRE CLIENTE
                    do {   
                    String nombreCliente = solicitud.pideNombre();
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
                    String dniCliente = solicitud.pideDni();
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
                        String tlfCliente = solicitud.pideTelefono();
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
                        String correoCliente = solicitud.pideCorreo();
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
                        String fechaNacCliente = solicitud.pideFechaNacimiento();
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
                        fichero = new FileOutputStream(PATH);
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



                    
                    
                    
                    
                    
                    break;


                case 2: 
                    System.out.println("2");
                    
                    //leer objecto DEL FICHERO
        
                    FileInputStream ficheroEntrada = null;
                    Cliente c;

                    try{
                        ficheroEntrada = new FileInputStream(PATH);
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
                    break;
                case 3: 
                    System.out.println("3");
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 6:
                    System.out.println("6");
                    break;
                default: 
                    System.out.println("Final de programa");
            } 
        } while (opcio==1 || opcio == 2 || opcio==3 || opcio == 4);

    
        
        

    }

    
}
