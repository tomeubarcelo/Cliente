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
        
    public byte menuOpcions() {
        byte opcio=0;
        do{
            try{
                Scanner op = new Scanner (System.in);
                //menú de opciones del programa
                System.out.println("\n1. Crear fichero clientes. ");
                System.out.println("2. Listar clientes. ");
                System.out.println("3. Buscar un cliente. ");
                System.out.println("4. Felicitar clientes. "); 
                System.out.println("5. Borrar fichero de clientes.");
                System.out.println("6. Salir.");
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
