/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemples;

/**
 *
 * @author pedro
 */
import java.io.File;
import java.io.IOException;
public class EjemploFileApp {
 
    public static void main(String[] args) throws IOException {
 
        //Creamos objetos File
        File fichero=new File("/home/pedro/Documentos/prova_file.file1.txt");
        File fichero2=new File("/home/pedro/Documentos/prova_file.file2.pdf");
        File directorio=new File("/home/pedro/Documentos/prova_file");
        File directorio2=new File("/home/pedro/Documentos/prova_file.noesta.txt");
 
        //Indica si existen los archivos
        System.out.println("Existencia: ");
        System.out.println("Fichero "+fichero.exists());
        System.out.println("Directorio "+directorio.exists());
 
        System.out.println("");
 
        //Indica si son directorios
        System.out.println("¿Son directorios?: ");
        System.out.println("Fichero "+fichero.isDirectory());
        System.out.println("Directorio "+directorio.isDirectory());
 
        System.out.println("");
 
        //Indica si son ficheros
        System.out.println("¿Son ficheros?: ");
        System.out.println("Fichero "+fichero.isFile());
        System.out.println("Directorio "+directorio.isFile());
 
        System.out.println("");
 
        //Indica la ruta absoluta del fichero o directorio
        System.out.println("Ruta absoluta: ");
        System.out.println("Fichero "+fichero.getAbsolutePath());
        System.out.println("Directorio "+directorio.getAbsolutePath());
 
        System.out.println("");
 
        //Indica si se puede leer
        System.out.println("¿Se pueden leer?:");
        System.out.println("Fichero "+fichero.canRead());
        System.out.println("Directorio "+directorio.canRead());
 
        System.out.println("");
 
        //Indica si se puede escribir
        System.out.println("¿Se pueden escribir?:");
        System.out.println("Fichero "+fichero.canWrite());
        System.out.println("Directorio "+directorio.canWrite());
 
        System.out.println("");
 
        //Indica si se puede ejecutar
        System.out.println("¿Se pueden ejecutar?:");
        System.out.println("Fichero "+fichero.canExecute());
        System.out.println("Directorio "+directorio.canExecute());
 
        System.out.println("");
 
        //Indica el nombre sin rutas
        System.out.println("Nombres sin rutas: ");
        System.out.println("Fichero "+fichero.getName());
        System.out.println("Directorio "+directorio.getName());
 
        System.out.println("");
 
        //Indica el nombre del directorio padre
        System.out.println("Nombre del directorio padre: ");
        System.out.println("Fichero "+fichero.getParent());
        System.out.println("Directorio "+directorio.getParent());
 
        System.out.println("");
 
        //Guarda en un array de File los directorios hijos, solo con directorios
        System.out.println("Nombre de los objetos File dentro de un array");
        File lista[]=directorio.listFiles();
        for(int i=0;i<lista.length;i++){
            System.out.println(lista[i]);
        }
 
        System.out.println("");
 
        //Guarda en un array de String los directorios hijos, solo con directorios
        System.out.println("Nombre de los objetos String dentro de un array");
        String listaString[]=directorio.list();
        for(int i=0;i<listaString.length;i++){
            System.out.println(listaString[i]);
        }
 
        System.out.println("");
 
        //Crea el directorio (no existe)
        System.out.println("Creando directorio...");
        System.out.println(directorio2.mkdir());
 
        System.out.println("");
 
        //Crea el fichero (no existe), debe controlarse la excepcion (arriba lanzamos la excepcion)
        System.out.println("Creando fichero...");
        System.out.println(fichero2.createNewFile());
 
    }
}
