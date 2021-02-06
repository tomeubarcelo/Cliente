# Tarea para PROG06

Se trata de hacer una aplicación en Java que gestione los clientes de una empresa. Esos datos, se almacenarán en un fichero serializado, denominado clientes.dat.

Los datos que se almacenarán sobre cada cliente son:
 
- NIF.
- Nombre.
- Teléfono.
- Dirección de correo electrónico.
- Fecha de nacimiento.
Mediante un menú se podrán realizar determinadas operaciones:

- Crear fichero clientes. Creará el fichero clientes.dat, pedirá los datos de los 5 clientes de la empresa y guardará los registros en el fichero creado.  Si el fichero ya existe, se mostrará un mensaje por pantalla indicando que el fichero ya está creado.
- Listar clientes. Esta opción recorrerá el fichero mostrando por pantalla los datos de los clientes almacenados en el mismo.
- Buscar un cliente. Pedirá al usuario el nif del cliente a buscar, y comprobará si existe en el fichero. Si existe mostrará sus datos por pantalla y si no existe se indicará por pantalla que no se ha encontrado.
- Felicitar clientes. Esta opción recorrerá el fichero y creará un nuevo fichero de texto con el nombre, fecha de nacimiento, teléfono y correo electrónico de los clientes que celebren el cumpleaños en el margen de hasta una semana antes (una línea de texto para cada cliente a felicitar).
- Borrar fichero de clientes. Esta opción eliminará del disco el fichero clientes.dat.  Si el fichero no existe, se mostrará un mensaje por pantalla indicando que el fichero no existe.
- Salir de la aplicación.

El proyecto deberá contener al menos dos archivos fuente Java:
- Programa principal (clase con método main: AplicacionClientes.java).
- La clase Cliente (Cliente.java).
