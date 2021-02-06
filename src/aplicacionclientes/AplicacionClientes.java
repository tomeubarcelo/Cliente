/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionclientes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author tomeu barcelo pons
 * Tarea para PROG06.
 * Aplicación en Java que gestiona los clientes de una empresa. 
 * Estos datos, se almacenarán en un fichero serializado, denominado clientes.dat.
 * -----------------
 * Ejemplos DNI:
 * 12345678Z
 * 43211234F
 * 12341234D
 * 87654321X
 * Más en: https://www.letranif.com/
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
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        final String PATH = "clientes.dat"; //fichero clientes.dat
        File fich = new File(PATH);
        
        Cliente array[] = new Cliente[5]; //cantidad de clientes 
        
        // instanciamos la clase de solicitudes por teclado
        FuncionamientoApp solicitud = new FuncionamientoApp();
        
        System.out.println(ANSI_BLUE_BACKGROUND+ANSI_WHITE+"Bienvenido a nuestra aplicación. ¿Qué desea hacer?"+ANSI_RESET);
        byte opcio;
        do { 
            opcio = solicitud.menuOpcions(); //mostra les opcions de menú i retorna l'opció escollida
            switch (opcio) {
                
                case 1: //Crear fichero clientes                
                    //llamada al metodo que comprueba si existe clientes.dat
                    compruebaSiExisteFichero(fich);
                    System.out.println("A continuación, pediremos los datos de los clientes y los guardaremos en un fichero:");
                    //llamada al metodo que pide los datos de los clientes
                    crearFicheroClientes(array, solicitud, PATH);
                    break;

                case 2: //Listar clientes
                    System.out.println("A continuación, mostraremos la lista de los clientes:");
                    //llamada a metodo para leer los clientes del fichero clientes.dat
                    listarClientes(array, PATH);
                    break;
                    
                case 3: //buscar un cliente             
                    //Esta opción recorrerá el fichero mostrando por pantalla los datos de los clientes almacenados
                    System.out.println("A continuación, podrá buscar al cliente que desee mediante su DNI:");
                    //metodo necesario para cargar los datos de los clientes
                    cargarClientes(array, PATH);
                    //buscar un cliente
                    buscaDni(array);
                    break;
                    
                case 4: //felicitar clientes
                    System.out.println("A continuación, se recorre el archivo clientes.dat y si hay algún cliente que cumpla años a lo largo de esta semana, se guarda en un fichero junto a sus datos.\n");
                    //metodo necesario para cargar los datos de los clientes
                    cargarClientes(array, PATH);
                    //llamada al metodo para felicitar clientes
                    felicitarClientes(array);
                    break;
                    
                case 5:
                    //borrar fichero clientes
                    //Esta opción eliminará del disco el fichero clientes.dat.  
                    //Si el fichero no existe, se mostrará un mensaje por pantalla indicando que el fichero no existe.
                    //Haremos lo mismo con el archivo felicitacionClientes.txt creado en la opcion 4
                    System.out.println("A continuación se borrará el fichero de clientes.dat y felicitacionClientes.txt");
                    //llamada al metodo que borra los archivos
                    borrarFicheros(fich, PATH);
                    break;
                    
                case 6:
                    //salir de la aplicacion
                    System.out.println(ANSI_BLUE_BACKGROUND+ANSI_WHITE+"Hasta pronto. Gracias por usar nuestra aplicación."+ANSI_RESET);
                    break;
                    
                default: 
                    System.out.println("Final de programa");
            } 
        } while (opcio==1 || opcio == 2 || opcio==3 || opcio == 4 || opcio == 5);
    } //fin metodo main

    //metodos para pedir info de los clientes en la opcion 1 con sus respectivos metodos de la clase FuncionamientoApp 
    //tambien con sus metodos de validacion
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
    //FIN metodos para pedir info de los clientes en la opcion 1
    
    public static void crearFicheroClientes(Cliente array[], FuncionamientoApp solicitud, String PATH) throws Exception{
        //bucle que recorre el array de los clientes
        for (int i = 0; i < array.length; i++) {
            // Tenemos un array de 5 elementos.

            array[i] = new Cliente(); //creacion
            System.out.println("\n"+ANSI_BLUE_BACKGROUND+ANSI_WHITE+"-------Cliente "+(i+1)+"-------"+ANSI_RESET);
            boolean sal = false;
            
            //llamada a metodos que piden los datos de cada cliente
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
            //FIN llamada a metodos que piden los datos de cada cliente
        }//fin bucle
                    
        //FICHERO CLIENTES.DAT
        FileOutputStream fichero = null;
        //a continuacion guardaremos los registros en el fichero clientes.dat (PATH)
        try{
            fichero = new FileOutputStream(PATH);
            ObjectOutputStream tuberia = new ObjectOutputStream(fichero);
            for (int i = 0; i < array.length; i++) {
                tuberia.writeObject(array[i]); //recorre el array de clientes y lo va guardando en el archivo
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
    }
    
    //metodo para opcion 2-> listar clientes
    public static void listarClientes(Cliente array[], String PATH){
        //Esta opción recorrerá el fichero mostrando por pantalla los datos de los clientes almacenados en el mismo.
        FileInputStream ficheroEntrada = null; 
        try{
            ficheroEntrada = new FileInputStream(PATH);
            ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
            for (int i = 0; i < array.length; i++) { //recorremos el array de clientes
                System.out.println("\n"+ANSI_BLUE_BACKGROUND+ANSI_WHITE+"-------Cliente "+(i+1)+"-------"+ANSI_RESET);
                array[i] = (Cliente)tuberiaEntrada.readObject();
                //llamada al metodo mostrarCliente de la clase Cliente
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
    }
    
    //metodo que busca el dni para la opcion 3
    public static void buscaDni(Cliente array[]) throws Exception{
        boolean encontrado = false;
        boolean sal = false;
        String dniParaBuscar;
        Scanner entradaScanner = new Scanner (System.in);
        System.out.println("Introduce el DNI a buscar:");
        do{ //bucle do-while que se hara mientras la variable sal sea falsa
            //con este bucle le seguiremos pidiendo el dni al usuario si lo introduce mal
            dniParaBuscar = entradaScanner.nextLine();
            
            if (validaDni(dniParaBuscar, sal)) { //si el formato de dni es correcto
                //System.out.println("DNI correcto");
                //recorremos el array de clientes
                for (int i = 0; i < array.length; i++) {
                    //si algun dni del array coincide con el dni introducido
                    if (array[i].getNIF().equals(dniParaBuscar)) {
                        System.out.println("\nSe han encontrado los datos del cliente con DNI: " + ANSI_BLUE+dniParaBuscar+ANSI_RESET);
                        System.out.println("Nombre: " + array[i].getNombre());
                        System.out.println("Telefono: " + array[i].getTelefono());
                        System.out.println("Correo: " + array[i].getCorreo());
                        System.out.println("Fecha de nacimiento: " + array[i].getFechaNacimiento()+"\n");
                        sal = true; //salimos del bucle do-while
                    } else{ //el dni es correcto pero ningun cliente lo tienes
                        System.out.println("El cliente "+array[i].getNombre()+" no tiene este DNI");
                        sal = true; //salimos del bucle do-while
                    }
                }
            } else {
                System.out.println("Vuelva a introducir el DNI:");
            }
        }while(!sal);  
    }
    
    //metodo para borrar ficheros -> opcion 5
    public static void borrarFicheros(File fich, String PATH) throws Exception{
        //Esta opción eliminará del disco el fichero clientes.dat.  
        //Si el fichero no existe, se mostrará un mensaje por pantalla indicando que el fichero no existe.
        //Haremos lo mismo con el fichero felicitacionClientes.txt
        File archivoFelicitar = new File("felicitacionClientes.txt");

        if ((!(fich.exists()))&&(!(archivoFelicitar.exists()))){ //si no existe ninguno de los 2
            System.err.println("No existe el fichero "+fich+", ni tampoco "+archivoFelicitar);
            throw new Exception("No existe el fichero "+fich+", ni tampoco "+archivoFelicitar);
        } else if (!(fich.exists())){ //si solo existe felicitacionClientes lo borraremos                       
            File ficheroClientesParaBorrar = new File("felicitacionClientes.txt");
            ficheroClientesParaBorrar.delete();
            System.out.println("Borrado "+archivoFelicitar);
            System.err.println("No existe el fichero "+fich);
            throw new Exception("No existe el fichero "+fich);
        } else if (!(archivoFelicitar.exists())){ //si solo existe clientes.dat lo borraremos
            File ficheroParaBorrar = new File(PATH);
            ficheroParaBorrar.delete();
            System.out.println("Borrado "+fich);
            System.err.println("No existe el fichero "+archivoFelicitar);
            throw new Exception("No existe el fichero"+archivoFelicitar);
        } else { //si existen los 2 borramos los 2
            File ficheroParaBorrar = new File(PATH);
            ficheroParaBorrar.delete();
            System.out.println("Borrado "+fich);
            File ficheroClientesParaBorrar = new File("felicitacionClientes.txt");
            ficheroClientesParaBorrar.delete();
            System.out.println("Borrado "+archivoFelicitar);
        }
    }
    
    //metodo para felicitar clientes -> opcion 4
    public static void felicitarClientes(Cliente array[]) throws Exception{
        //Esta opción recorrerá el fichero y creará un nuevo fichero de texto con el nombre, fecha de nacimiento, 
        //teléfono y correo electrónico de los clientes que celebren el cumpleaños en el margen de hasta una 
        //semana antes (una línea de texto para cada cliente a felicitar).
        
        //debemos trabajar con fechas por eso usaremos clases como LocalDate o DateTimeFormatter
        //formato que usaremos para las fechas
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
        LocalDate fechaActual = LocalDate.now();  //Crea un objeto LocalDate con la fecha actual
        //System.out.println("Hoy es dia: "+fechaActual);  // Muestra la fecha actual
        String formattedDate = fechaActual.format(myFormatObj); //fecha actual con el formato dd/mm/yyyy  
        //System.out.println("After Formatting: " + formattedDate + "\nDay: "+fechaActual.getDayOfMonth() + ", month: "+fechaActual.getMonthValue());  

        //fecha de hoy + 7 dias
        LocalDate fechaDeHoyMasUnaSemana = fechaActual.plusDays(7);

        File archivo = new File("felicitacionClientes.txt");
        compruebaSiExisteFichero(archivo); //comprobamos si ya existe el fichero

        for (int i = 0; i < array.length; i++) { //bucle para recorrer el array de los clientes
            if (array[i].validaFechaNacimiento(array[i].getFechaNacimiento())){ //si el formato de fecha es valido...
               
                //transformamos a LocalDate la fecha introducida por el usuario ya con el formato dd/mm/yyyy
                LocalDate localDate = LocalDate.parse(array[i].getFechaNacimiento(), myFormatObj);
                
                //debemos averiguar los años de diferencia que faltan para llegar al año actual
                //para sumarle dicha diferencia y saber cuando es su cumpleaños este año
                //System.out.println("Año actual: "+fechaActual.getYear());
                //System.out.println("Año nacimiento cliente: "+localDate.getYear());
                int differ = fechaActual.getYear() - localDate.getYear(); //hacemos la resta
                //System.out.println("La diferencia de años es: "+differ);
                LocalDate anyoClienteActual = localDate.plusYears(differ); //sumamos mediante el metodo plusYears
                //System.out.println("Fecha de hoy: "+fechaActual);
                //System.out.println("Cumpleaños del cliente en este año: "+anyoClienteActual);
                //System.out.println("Fecha de hoy mas una semana: "+fechaDeHoyMasUnaSemana);

                //condicional para saber si el cumpleaños del cliente esta entre el dia de hoy y el el dia de hoy+7
                //ambos dias incluidos
                if ((anyoClienteActual.isAfter(fechaActual)|| anyoClienteActual.isEqual(fechaActual))&& (anyoClienteActual.isBefore(fechaDeHoyMasUnaSemana)|| anyoClienteActual.isEqual(fechaDeHoyMasUnaSemana) )) {
                    System.out.println("El cliente "+array[i].getNombre() +" cumple años esta semana");
                    String formatoCorrectoAnyoClienteActual = anyoClienteActual.format(myFormatObj);  
                    String formatoCorrectoFechaMasUnaSemana = fechaDeHoyMasUnaSemana.format(myFormatObj); 

                    System.out.println("Su cumpleaños es: "+formatoCorrectoAnyoClienteActual + " y está entre: "+formattedDate + " y "+formatoCorrectoFechaMasUnaSemana);

                    //en el caso de que los cumpla esta semana crearemos el nuevo fichero para felicitar clientes          
                    PrintWriter out = null;
                    out = new PrintWriter(new FileWriter("felicitacionClientes.txt",true));        
                    BufferedReader br = new BufferedReader(
                            new InputStreamReader(System.in)
                    );
                    //texto que se verá en el archivo felicitacionClientes.txt de cada cliente
                    out.println("FELICIDADES "+array[i].getNombre()+"!!! Cumplirás años el "+formatoCorrectoAnyoClienteActual);
                    out.println(array[i].getNombre()+", "+array[i].getFechaNacimiento()+", "+array[i].getTelefono()+", "+array[i].getCorreo()+"\n");
                    out.close();                                        
                } else{ //caso en el que el cliente no cumpla el cumpleaños en el margen de tiempo estipulado
                    String formatoCorrectoAnyoClienteActual = anyoClienteActual.format(myFormatObj);  
                    String formatoCorrectoFechaMasUnaSemana = fechaDeHoyMasUnaSemana.format(myFormatObj); 
                    System.out.println("El cliente "+array[i].getNombre() +" NO cumple años esta semana");
                    System.out.println("Su cumpleaños es: "+formatoCorrectoAnyoClienteActual + " y NO está entre: "+formattedDate + " y "+formatoCorrectoFechaMasUnaSemana);
                }
            }
            System.out.println("\n");
        }
        
        //comprueba si el archivo felicitacionClientes.txt existe
        if (archivo.exists()) {
            System.out.println(ANSI_GREEN_BACKGROUND+"Fichero creado correctamente."+ANSI_RESET);
        } else{ //si no existe..
            System.out.println(ANSI_RED_BACKGROUND+ANSI_WHITE+"El fichero no se ha creado ya que ningún cliente cumple años en el margen de tiempo estipulado."+ANSI_RESET);
        }       
    }
    
    //metodo que comprueba si existe el fichero asignado en el atributo
    public static void compruebaSiExisteFichero(File comprobarArchivo) throws Exception{
        if (comprobarArchivo.exists()) {
            System.err.println("Ya existe el fichero "+comprobarArchivo);
            throw new Exception("Ya existe el fichero "+comprobarArchivo);
        }
    }
    
    public static boolean validaDni(String dniCliente, boolean correcto) throws Exception{
        //metodo para validad DNI
        //Pattern pat = Pattern.compile("[0-9]{7,8}[A-Z a-z]");
        String dniRegexp = "\\d{8}[A-HJ-NP-TV-Z]";
        
        //array de caracteres que pueden ir con los digitos del dni
        char[] letras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        
        correcto = false;
        try {
            if (Pattern.matches(dniRegexp, dniCliente)) { //comprobamos que tenga el formato correcto
                //System.out.println("dni con formato correcto");
                //guardamos los digitos
                String numDni = dniCliente.substring(0, 8);
                //los pasamos a int
                int numbers = Integer.parseInt(numDni);
                //calculamos el resto del numero de dni entre 23
                int resto = numbers%23;
                //guardamos el caracter del dni
                char letraDni = dniCliente.charAt(dniCliente.length() - 1);
                //System.out.println(letraDni);
                //para calcular la letra que deberia ser, cogeremos el caracter del array en la posicion del resto
                //si la letra inroducida es igual que la letra que tocaria ser es correcto
                if(letras[resto]==letraDni) {
                    //System.out.println("DNI CORRECTO");
                    correcto = true;
                    //return correcto;
                } else{
                    System.err.println ("La letra no coincide con sus digitos del DNI");
                    System.err.println ("Su DNI debería ser: "+numDni+"-"+letras[resto]);
                    correcto = false;
                }
            } else {
                //System.err.println("Length dini: "+dniCliente.length());
                System.err.println ("Introduzca el formato correcto: 12345678A");
                correcto = false;
            }
        } catch (NumberFormatException e) {
            throw new Exception("DNI incorrecto");        
        }
        return correcto;
    }
    
    //metodo necesario para la opcion 3(buscar dni) y 4(felicitar) para que cargue los clientes
    public static void cargarClientes(Cliente array[], String PATH){
            FileInputStream ficheroEntrada = null; 
            try{
                ficheroEntrada = new FileInputStream(PATH);
                ObjectInputStream tuberiaEntrada = new ObjectInputStream(ficheroEntrada);
                for (int i = 0; i < array.length; i++) { //recorremos el array de clientes
                    array[i] = (Cliente)tuberiaEntrada.readObject();
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
    }
    
}
