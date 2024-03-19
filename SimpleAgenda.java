import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SimpleAgenda {

    public void generarArchivo() {
        try {
            // Crear un objeto File con el nombre de contactos.txt
            File archivo = new File("contactos.txt");
            // Crear físicamente el archivo mediante usando createNewFile()
            archivo.createNewFile();
            // Crear un objeto de tipo FileWriter, que reciba el archivo creado anteriormente para escribir contenido al mismo.
            FileWriter escritor = new FileWriter(archivo);
            // Mediante el método write(), pasarle el siguiente contenido String
            escritor.write("contacto,telefono\n" +
                    "Adan,8098551212\n" +
                    "Enmanuel,8294118787\n" +
                    "Raider,8097410032\n" +
                    "Roger,8095554141\n");
            // usar close() una vez finalizada la escritura
            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al generar el archivo: " + e.getMessage());
        }
    }

    public void mostrarContacto() {
        try {
            // Leer archivo contactos.txt usando el objeto Scanner para manejar los datos del archivo
            Scanner scanner = new Scanner(new File("contactos.txt"));
            // Crear una variable a ser utilizada posteriormente para verificar un valor String existente
            String linea;
            // Imprimir en pantalla “Ingrese nombre a consultar”
            System.out.println("Ingrese nombre a consultar: ");
            // Solicitar por teclado un nombre que represente al contacto y almacenar en una variable de tipo String
            Scanner inputScanner = new Scanner(System.in);
            String nombre = inputScanner.nextLine();
            boolean encontrado = false;
            // Verificar si el elemento ingresado por teclado existe en el archivo
            while (scanner.hasNextLine()) {
                linea = scanner.nextLine();
                // Ignorar la primera línea que es el encabezado
                if (linea.startsWith("contacto")) continue;
                String[] partes = linea.split(",");
                if (partes[0].equalsIgnoreCase(nombre)) {
                    encontrado = true;
                    // Imprimir ”El contacto [contacto] existe“
                    System.out.println("El contacto " + nombre + " existe");
                    break;
                }
            }
            // Si no se encuentra el contacto
            if (!encontrado) {
                // Imprimir “No existen registros de este contacto”
                System.out.println("No existen registros de este contacto");
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void mostrarContactos() {
        System.out.println("Mostrando contactos...");
        try {
            // Leer archivo contactos.txt usando el objeto Scanner para manejar los datos del archivo
            Scanner scanner = new Scanner(new File("contactos.txt"));
            // Ignorar la primera línea que es el encabezado
            scanner.nextLine();
            // Imprimir cada registro almacenado en el archivo contactos.txt correspondiente a su nombre y teléfono a excepción del encabezado
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                System.out.println("Nombre: " + partes[0] + ", Teléfono: " + partes[1]);
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SimpleAgenda agenda = new SimpleAgenda();
        agenda.generarArchivo();
        agenda.mostrarContacto();
        agenda.mostrarContactos();
    }
}
