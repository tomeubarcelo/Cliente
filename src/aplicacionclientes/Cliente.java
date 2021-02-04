/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionclientes;

import java.io.Serializable;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author tomeu
 */
public class Cliente implements Serializable {

    //atributos
    private String NIF;
    private String nombre;
    private String telefono;
    private String correo;
    private String fechaNacimiento;
    

    //constructor con sus atributos
    public Cliente(String NIF, String nombre, String telefono, String correo, String fechaNacimiento) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente() throws Exception {
        //constructor per defecte que crea objecte amb les dades a null
        //introduirem les dades amb els setters 
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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
    
    public boolean validaNombre(String nombreCliente) throws Exception{
        
        boolean contieneSoloLetras = contieneSoloLetras(nombreCliente);
        //con el metodo contieneSoloLetras(nombreCliente) comprobaremos si solo tiene letras
            if (nombreCliente.length() > 40) { //si supera 40 caracteres -> error
                //System.err.println ("Ha superado el límite de carácteres");
                throw new Exception("Ha superado el límite de carácteres");
            } else if (nombreCliente.length() < 2){
                //System.err.println ("No llega al mínimo de carácteres");
                throw new Exception("No llega al mínimo de carácteres");
            }
            else if(contieneSoloLetras==false){ //si no contiene letras -> error
                //System.err.println ("Solo debe contener letras");
                throw new Exception("Solo debe contener letras");
            } else { //devuelve el nombre correctamente
                return true; // Valor válido: lo almacenamos
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
    
    public boolean validaDni(String dniCliente) throws Exception{
        Pattern pat = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
        
        //array de caracteres que pueden ir con los digitos del dni
        char[] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};

        try {
            if (Pattern.matches(dniRegexp, dniCliente)) {
                //System.out.println("dni con formato correcto");
                //guardamos los digitos
                String numDni = dniCliente.substring(0, 8);
                //los pasamos a int
                int numbers = Integer.parseInt(numDni);
                //calculamos el resto del numero de dni entre 23
                int resto = numbers%23;
                /*
                System.out.println(numbers);
                System.out.println(resto);
                System.out.println(letras[resto]);
                */
                //guardamos el caracter del dni
                char letraDni = dniCliente.charAt(dniCliente.length() - 1);
                //System.out.println(letraDni);
                //para calcular la letra que deberia ser, cogeremos el caracter del array en la posicion del resto
                //si la letra inroducida es igual que la letra que tocaria ser es correcto
                if(letras[resto]==letraDni) {
                    //System.out.println("DNI CORRECTO");
                    return true;
                } else{
                    System.err.println ("La letra no coincide con sus digitos del DNI");
                    System.err.println ("Su DNI debería ser: "+numDni+"-"+letras[resto]);
                    throw new Exception("La letra no coincide con sus digitos del DNI");
                }
            } else {
                //System.err.println("Length dini: "+dniCliente.length());
                System.err.println ("Introduzca el formato correcto: 12345678A");
                throw new Exception("Introduzca el formato correcto: 12345678A");
            }
        } catch (Exception e) {
            throw new Exception("DNI incorrecto");
        }


    }

    public boolean validaTelefono(String numTlf) throws Exception {

        if (numTlf.length() == 9) {
            //return numTlf;
            return true;
        } else {
            System.err.println ("Número de teléfono incorrecto");
            throw new Exception("Número de teléfono incorrecto");
        }

    }
    
    public boolean validaCorreo(String correo) throws Exception{

        //http://puntocomnoesunlenguaje.blogspot.com/2013/07/ejemplos-expresiones-regulares-java-split.html
        Pattern pat = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");   
        Matcher mat = pat.matcher(correo);
        if(mat.find()){
            //System.out.println("Correo Válido");
            return true;
        }else{
            System.err.println ("Formato de correo electrónico incorrecto");
            throw new Exception("Formato de correo electrónico incorrecto");
        }
    }
    
    public boolean validaFechaNacimiento(String fechaNacimiento) throws ParseException, Exception {
        //metodo para validar fecha de nacimiento
        
        Pattern pat = Pattern.compile("^([0-2][0-9]|3[0-1])(\\/|-)(0[1-9]|1[0-2])\\2(\\d{4})$");
        Matcher mat = pat.matcher(fechaNacimiento);
        if(mat.find()){
            //System.out.println(fechaNacimiento);
            return true;
        }else{
            System.err.println ("Formato de fecha incorrecto. Use 'DD/MM/YYYY' o 'DD-MM-YYYY'");
            throw new Exception("Formato de fecha incorrecto. Use 'DD/MM/YYYY' o 'DD-MM-YYYY'");
        }
    }
    
    public void mostrarCliente(){ //metodo que muestra los clientes -> opcion 2 Listar clientes
        System.out.println("Nombre: "+nombre);
        System.out.println("DNI: "+NIF);
        System.out.println("Telefono: "+telefono);
        System.out.println("Correo: "+correo);
        System.out.println("Fecha nacimiento: "+fechaNacimiento);
    }
}
