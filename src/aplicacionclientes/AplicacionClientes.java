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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author tomeu
 */
public class AplicacionClientes {

    /**
     * @param args the command line arguments
     */
        //variables para colores a usar en consola
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        

        final String PATH = "clientes.dat";
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
                        System.out.println("\n"+ANSI_BLUE_BACKGROUND+ANSI_WHITE+"-------Cliente "+(i+1)+"-------"+ANSI_RESET);
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
                        
                    }//fin bucle
                    
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
                                System.out.println("\n"+ANSI_BLUE_BACKGROUND+ANSI_WHITE+"-------Cliente "+(i+1)+"-------"+ANSI_RESET);
                                array[i] = (Cliente)tuberiaEntrada.readObject();
                                array[i].mostrarCliente();
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
                    //felicitar clientes
                    //fechas
                    SimpleDateFormat formato = new SimpleDateFormat("dd-mm-yyyy");
                    
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
                    LocalDate myObj = LocalDate.now();  // Create a date object
                    System.out.println(myObj);  // Display the current date
                    String formattedDate = myObj.format(myFormatObj);  
                    System.out.println("After Formatting: " + formattedDate + "\nDay: "+myObj.getDayOfMonth() + ", month: "+myObj.getMonthValue());  
                    
                    //fecha de hoy + 7 dias
                    LocalDate fechaDeHoyMasUnaSemana = myObj.plusDays(7);
                    System.out.println("Le sumamos 7: " +myObj.plusDays(7));  
                    System.out.println("Le restamos 7: " +myObj.minusDays(7));  
                                
                    
                    
                    for (int i = 0; i < array.length; i++) {
                        if (array[i].validaFechaNacimiento(array[i].getFechaNacimiento())){
                            //si el formato de fecha es valido..
                            System.out.println("Fecha introducida por el usuario "+array[i].getFechaNacimiento());
                            //fechaDate = formato.parse(array[i].getFechaNacimiento());
                            
                            LocalDate localDate = LocalDate.parse(array[i].getFechaNacimiento(), myFormatObj);
                            //Date date1=formato.parse(array[i].getFechaNacimiento()); 
                            
                            
                            System.out.println(localDate);
                            
                            //debemos averiguar los años de diferencia, para que los 2 esten en el mismo año
                            System.out.println("Año actual: "+myObj.getYear());
                            System.out.println("Año nacimiento cliente: "+localDate.getYear());
                            int differ = myObj.getYear() - localDate.getYear();
                            System.out.println("La diferencia de años es: "+differ);
                            LocalDate anyoClienteActual = localDate.plusYears(differ);
                            System.out.println("Por lo tanto ahora es: "+anyoClienteActual);
                            System.out.println("Fecha de hoy: "+myObj);
                            System.out.println("Cumpleaños del cliente en ste año: "+anyoClienteActual);
                            
                            
                            System.out.println("Fecha de hoy mas una semana: "+fechaDeHoyMasUnaSemana);
                                    
                            if ((anyoClienteActual.isAfter(myObj)|| anyoClienteActual.isEqual(myObj))&& (anyoClienteActual.isBefore(fechaDeHoyMasUnaSemana)|| anyoClienteActual.isEqual(fechaDeHoyMasUnaSemana) )) {
                                System.out.println("El cliente cumple años esta semana");
                                String formatoCorrectoAnyoClienteActual = anyoClienteActual.format(myFormatObj);  
                                String formatoCorrectoFechaMasUnaSemana = fechaDeHoyMasUnaSemana.format(myFormatObj); 
                                
                                System.out.println("Su cumpleaños es: "+formatoCorrectoAnyoClienteActual + " y está entre: "+formattedDate + " y "+formatoCorrectoFechaMasUnaSemana);
                                
                                
                        String ficheroFelicitar = "felicitacionClientes.dat";
                        
                        File fichCumple = new File(ficheroFelicitar);        
                        /*if (fichCumple.exists()){
                            System.err.println("Ya existe el fichero");
                            throw new Exception("Ya existe el fichero");
                        }  */ 


                        //FICHEROS
                                
    
                                
                        FileOutputStream ficheroCumple = null;
                            
                        try{
                            ficheroCumple = new FileOutputStream(ficheroFelicitar);
                            ObjectOutputStream tuberia = new ObjectOutputStream(ficheroCumple);
                            for (int j = 0; j < array.length; j++) {
                            tuberia.writeObject(array[j]);
                            }
                        } catch(FileNotFoundException ex){
                            ex.printStackTrace();
                        } catch(IOException ex){
                            ex.printStackTrace();
                        } finally{
                            try{
                               ficheroCumple.close();   
                            } catch(IOException ex){
                                ex.printStackTrace();
                            }
                        }   
                                
                                
                            } else{
                                String formatoCorrectoAnyoClienteActual = anyoClienteActual.format(myFormatObj);  
                                String formatoCorrectoFechaMasUnaSemana = fechaDeHoyMasUnaSemana.format(myFormatObj); 
                                System.out.println("El cliente NO cumple años esta semana");
                                System.out.println("Su cumpleaños es: "+formatoCorrectoAnyoClienteActual + " y NO está entre: "+formattedDate + " y "+formatoCorrectoFechaMasUnaSemana);
                            }
                        }
                        System.out.println("\n");
                    }
                    
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
                System.out.println("\nSe han encontrado los datos del cliente con DNI: " + dniParaBuscar);
                System.out.println("Nombre: " + array[i].getNombre());
                System.out.println("Telefono: " + array[i].getTelefono());
                System.out.println("Correo: " + array[i].getCorreo());
                System.out.println("Fecha de nacimiento: " + array[i].getFechaNacimiento());
                encontrado = true;
            }
        }
        //si no se ha encontrado
        if (!encontrado){
            System.out.println("No se ha encontrado el DNI: "+dniParaBuscar);
        }
                    
    }
    
}
