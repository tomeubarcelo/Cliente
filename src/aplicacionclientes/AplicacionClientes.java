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
        File fich = new File(PATH);
        
        Cliente array[] = new Cliente[3];
        
        // instanciamos la clase de solicitudes por teclado
        FuncionamientoApp solicitud = new FuncionamientoApp();
        
        byte opcio;
        do { 
            opcio = solicitud.menuOpcions(); //mostra les opcions de menú i retorna l'opció escollida
            switch (opcio) {
                case 1: 

                    
                    //comprobamos que existe el fichero para cargar los datos si es que existe
                    if (fich.exists()){
                        System.err.println("Ya existe el fichero");
                        throw new Exception("Ya existe el fichero");
                    }
                    //FIN COMPROBAR
                    
                    
                    
                    
                    for (int i = 0; i < array.length; i++) {
                        // Tenemos un array de 5 elementos.

                        
                        array[i] = new Cliente();
                        System.out.println("-------Cliente "+(i+1)+"-------");
                        boolean sal = false;


                        //NOMBRE CLIENTE
                        nombre(solicitud, array[i], sal);

                        //DNI CLIENTE
                        dni(solicitud, array[i], sal);

                        //TELEFONO CLIENTE
                        telefono(solicitud, array[i], sal);

                        //CORREO CLIENTE
                        correo(solicitud, array[i], sal);

                        //FECHA NACIMIENTO CLIENTE
                        fechaNacimiento(solicitud, array[i], sal);
}
                        //FICHEROS
                        FileOutputStream fichero = null;
                            
                        try{
                            fichero = new FileOutputStream(PATH);
                            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
                            for (int i = 0; i < array.length; i++) {
                            tuberia.writeObject(array[i]);
                            }
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
                            for (int i = 0; i < array.length; i++) {
                                System.out.println("-------Cliente "+(i+1)+"-------");
                                array[i] = (Cliente)tuberiaEntrada.readObject();
                                array[i].mostrarCliente();
                                System.out.println("");
                            }
                        } catch(FileNotFoundException ex){
                            ex.printStackTrace();
                        } catch(IOException ex){
                            ex.printStackTrace();
                        } catch(ClassNotFoundException ex){
                            ex.printStackTrace();
                        } finally{
                            try{
                               ficheroEntrada.close();   
                            } catch(IOException ex){
                                ex.printStackTrace();
                            }
                        } 
                    
                    break;
                case 3: 
                    System.out.println("3");
                    //buscar un cliente
                    buscaDni(array);
       
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    if (!(fich.exists())){
                        System.err.println("No existe el fichero");
                        //throw new Exception("No existe el fichero");
                    } else {
                        File ficheroParaBorrar = new File(PATH);
                        ficheroParaBorrar.delete();
                    }
                    break;
                case 6:
                    System.out.println("6");
                    break;
                default: 
                    System.out.println("Final de programa");
            } 
        } while (opcio==1 || opcio == 2 || opcio==3 || opcio == 4);

    
        
        

    }

    public static void nombre(FuncionamientoApp solicitud, Cliente cliente, boolean sal){
        do {   
            String nombreCliente = solicitud.pideNombre();
                try {
                    cliente.validaNombre(nombreCliente);    
                    boolean formatoCorrecto = cliente.validaNombre(nombreCliente);
                    if (formatoCorrecto) {
                        cliente.setNombre(nombreCliente);
                        sal = true;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (!sal);
    }
    
    public static void dni(FuncionamientoApp solicitud, Cliente cliente, boolean sal){
            do {  
                sal = false;
                String dniCliente = solicitud.pideDni();
                    try {
                        cliente.validaDni(dniCliente);
                        //System.out.println(cliente1.validaDni(dniCliente));
                        boolean formatoCorrecto = cliente.validaDni(dniCliente);
                        if (formatoCorrecto) {
                            cliente.setNIF(dniCliente);
                            sal = true;
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } while (!sal);
    }
    
    public static void telefono (FuncionamientoApp solicitud, Cliente cliente, boolean sal){
            do {  
                sal = false;
                String tlfCliente = solicitud.pideTelefono();
                try {
                    cliente.validaTelefono(tlfCliente);

                    //System.out.println(cliente1.validaDni(dniCliente));
                    boolean formatoCorrecto = cliente.validaTelefono(tlfCliente);
                    if (formatoCorrecto) {
                        cliente.setTelefono(tlfCliente);
                        sal = true;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (!sal);
    }
    
    
    public static void correo(FuncionamientoApp solicitud, Cliente cliente, boolean sal){
            do {  
                sal = false;
                String correoCliente = solicitud.pideCorreo();
                try {
                    cliente.validaCorreo(correoCliente);
                    //System.out.println(cliente1.validaDni(dniCliente));
                    boolean formatoCorrecto = cliente.validaCorreo(correoCliente);
                    if (formatoCorrecto) {
                        cliente.setCorreo(correoCliente);
                        sal = true;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (!sal);
    }
    
    
    public static void fechaNacimiento(FuncionamientoApp solicitud, Cliente cliente, boolean sal){
            do {  
                sal = false;
                String fechaNacCliente = solicitud.pideFechaNacimiento();
                try {
                    cliente.validaFechaNacimiento(fechaNacCliente);
                    //System.out.println(cliente1.validaDni(dniCliente));
                    boolean formatoCorrecto = cliente.validaFechaNacimiento(fechaNacCliente);
                    if (formatoCorrecto) {
                        cliente.setFechaNacimiento(fechaNacCliente);
                        sal = true;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } while (!sal);
    }
    
    public static void buscaDni(Cliente array[]){
        boolean encontrado = false;
                    Scanner entradaScanner = new Scanner (System.in);
                    System.out.println("Introduce el DNI a buscar:");
                    String dniParaBuscar = entradaScanner.nextLine();
                    
                    //recorremos el array de clientes
                    for (int i = 0; i < array.length; i++) {
                        //si algun dni del array coincide con el dni introducido
                        if (array[i].getNIF().equals(dniParaBuscar)) {
                            System.out.println("Se han encontrado los datos del nif " + dniParaBuscar);
                            System.out.print("cliente:" + array[i].getNombre());
                            System.out.print(", dirección:" + array[i].getTelefono());
                            System.out.print(", tfno.:" + array[i].getCorreo());
                            System.out.print(", deuda:" + array[i].getFechaNacimiento()+ "\n");
                            encontrado = true;
                        }
                    }
                    //si no se ha encontrado
                    if (!encontrado){
                        System.out.println("No se ha encontrado el DNI: "+dniParaBuscar);
                    }
                    
    }
    
}
