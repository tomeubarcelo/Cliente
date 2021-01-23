/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionclientes;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tomeu
 */
public class Cliente {

    //atributos
    private String NIF;
    private String nombre;
    private int telefono;
    private String correo;
    private String fechaNacimiento;
    
    //Creación de un objeto Scanner
    Scanner entradaEscaner = new Scanner (System.in); 
    
    //constructor con sus atributos
    public Cliente(String NIF, String nombre, int telefono, String correo, String fechaNacimiento) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    Cliente() throws Exception {
        this.NIF = NIF;
        this.nombre = nombre;
    }
    
    //GETTERS Y SETTERS
    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    //FIN GETTERS Y SETTERS
    
    public String pedirNombre () throws Exception{
        //metodo en el que se introduc el nombre del cliente
        System.out.println ("Introduzca su nombre y apellidos:");
        String nombreCliente = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner
        
        boolean contieneSoloLetras = contieneSoloLetras(nombreCliente);
        //con el metodo contieneSoloLetras(nombreCliente) comprobaremos si solo tiene letras
        if (nombreCliente.length() > 40) { //si supera 40 caracteres -> error
            System.err.println ("Ha superado el límite de carácteres");
            throw new Exception("Ha superado el límite de carácteres");
        } else if(contieneSoloLetras==false){ //si no contiene letras -> error
            System.err.println ("Solo debe contener letras");
            throw new Exception("Solo debe contener letras");
        } else { //devuelve el nombre correctamente
            return nombreCliente;      
        }
    }
    
    public static boolean contieneSoloLetras(String cadena) {
        //metodo para comprobar si una cadena contiene solamente letras
        for (int x = 0; x < cadena.length(); x++) {
            char c = cadena.charAt(x);
            // Si no está entre a y z, ni entre A y Z, ni es un espacio
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                return false;
            }
        }
        return true;
    }
    
    public String pedirDni() throws Exception{
        Pattern pat = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
       
        System.out.println ("Introduzca su DNI con el formato 12345678A:");
        String dniCliente = entradaEscaner.nextLine (); //Invocamos un método sobre un objeto Scanner

        String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";

        // Lo siguiente devuelve true
        //System.out.println(Pattern.matches(dniRegexp, dniCliente));
        try {
            if (Pattern.matches(dniRegexp, dniCliente)) {
                System.out.println("dni correcto");
            } else {
                System.err.println ("DNI incorrecto");
                throw new Exception("DNI incorrecto");
            }
        } catch (Exception e) {
            System.err.println ("DNI incorrecto");
            throw new Exception("DNI incorrecto");
        }

        //array de caracteres que pueden ir con los digitos del dni
        char[] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        
        //guardamos los digitos
        String numDni = dniCliente.substring(0, 8);
        //los pasamos a int
        int numbers = Integer.parseInt(numDni);
        //calculamos el resto del numero de dni entre 23
        int resto = numbers%23;
        System.out.println(numbers);
        System.out.println(resto);
        System.out.println(letras[resto]);
        //guardamos el caracter del dni
        char letraDni = dniCliente.charAt(dniCliente.length() - 1);
        System.out.println(letraDni);
        //para calcular la letra que deberia ser, cogeremos el caracter del array en la posicion del resto
        //si la letra inroducida es igual que la letra que tocaria ser es correcto
        if(letras[resto]==letraDni) {
            System.out.println("DNI CORRECTO");
            return dniCliente;
        } else{
            System.err.println ("DNI incorrecto");
            throw new Exception("DNI incorrecto");
        }
       
    }
    
    public void validarDni(int numeroDNI){

        char[] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        
        int resto;
        resto = numeroDNI % 23;
        System.out.println("DNI COMPLETO: "+numeroDNI+letras[resto]);

    }
    
    
}