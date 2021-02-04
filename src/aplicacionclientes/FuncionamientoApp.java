/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionclientes;

import java.util.Scanner;

/**
 *
 * @author tomeu
 */
public class FuncionamientoApp {
    
    //variables para colores a usar en consola
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public byte menuOpcions() {
        byte opcio=0;
        do{
            try{
                Scanner op = new Scanner (System.in);
                //menú de opciones del programa
                System.out.println("\n"+ANSI_BLUE+"1."+ANSI_RESET+" Crear fichero clientes. ");
                System.out.println(ANSI_BLUE+"2."+ANSI_RESET+" Listar clientes. ");
                System.out.println(ANSI_BLUE+"3."+ANSI_RESET+" Buscar un cliente. ");
                System.out.println(ANSI_BLUE+"4."+ANSI_RESET+" Felicitar clientes. "); 
                System.out.println(ANSI_BLUE+"5."+ANSI_RESET+" Borrar fichero de clientes.");
                System.out.println(ANSI_BLUE+"6."+ANSI_RESET+" Salir.");
                System.out.print("Introduce la opción elegida: ");
                opcio=op.nextByte();
                if (opcio < 1 || opcio > 6) {
                System.out.println("Escoger entre (1..6)!.");    
                }
            }    
            catch(Exception e){
                System.out.println("Error al leer del teclado(1..6)!.");
            }
            
        }while (opcio < 1 || opcio > 6);
        return opcio;
    }
    
    public String pideNombre() {
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce tu nombre y apellidos.");
        String nombre = entradaScanner.nextLine();
        return nombre;
    }
    
    public String pideDni() {
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce tu DNI.");
        String dni = entradaScanner.nextLine();
        return dni;
    }
    
    public String pideTelefono(){
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce tu teléfono.");
        String tlf = entradaScanner.nextLine();
        return tlf;
    }
    
    public String pideCorreo(){
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce tu correo electronico.");
        String correo = entradaScanner.nextLine();
        return correo;
    }
    
    public String pideFechaNacimiento(){
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce tu fecha de nacimiento.");
        String fechaNac = entradaScanner.nextLine();
        return fechaNac;
    }
}
