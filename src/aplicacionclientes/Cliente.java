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
}
