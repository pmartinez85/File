/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exemples;

import java.io.File;

/**
 *
 * @author pedro
 */
class MyCustomFilter extends javax.swing.filechooser.FileFilter {
        @Override
        public boolean accept(File arxiu) {
            // Permetem directoris o arxius amb extensió .pdf
            return arxiu.isDirectory() || arxiu.getAbsolutePath().endsWith(".txt");
        }
        @Override
        public String getDescription() {
            // La descripció es mostra en el diàleg...està fet Hardcoded
            return "Document de text (*.txt)";
        }
    }
