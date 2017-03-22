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
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.*;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

    // Alguns mètodes de la classe File que ens poden ser útils
    

public class PrintFiles
    extends SimpleFileVisitor<Path> {

    // Imprimim informació sobre cada tipus d'arxiu
    
    @Override
    public FileVisitResult visitFile(Path arxiu, BasicFileAttributes atribut) {
        if (atribut.isSymbolicLink()) {
            System.out.format("Enllaç simbolic: %s ", arxiu);
        } else if (atribut.isRegularFile()) {
            System.out.format("Arxiu normal: %s ", arxiu);
        } else {
            System.out.format("Altres: %s ", arxiu);
        }
        System.out.println("(" + atribut.size() + "bytes)");
        return CONTINUE;
    }

    
}
    
