/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.*;
import vista.GUI;



/**
 *
 * @author pedro
 */


public class Model {

    FileInputStream entrada;
    FileOutputStream sortida;
    File arxiu;
    public byte[] bytesImg;
    
     private GUI v;

    public String obrirText(File arxiu) {

        String contingut = "";
        try {
            entrada = new FileInputStream(arxiu);
            int ascci;
            while ((ascci = entrada.read()) != -1) {
                char caracter = (char) ascci;
                contingut += caracter;
            }

        } catch (Exception e) {
            System.out.println("Quelcom ha sorgit malament");
        }
        return contingut;
    }

    /*Guardem arxius de text*/

    public String guardarArxiuText(File arxiu, String contingut) {
        String resposta = null;

        try {
            sortida = new FileOutputStream(arxiu);
            byte[] bytesTxt = contingut.getBytes();
            sortida.write(bytesTxt);
            resposta = "S'ha guardat l'arxiu correctament";
        } catch (Exception e) {
            System.out.println("Quelcom ha sorgit malament");
        }
        return resposta;

    }

    public byte[] obrirImatge(File arxiu) {
        byte[] bytesImg = new byte[1024*1000];
        try {
            entrada = new FileInputStream(arxiu);
            entrada.read(bytesImg);
        } catch (Exception e) {
            System.out.println("Quelcom ha sorgit malament");

        }
        return bytesImg;
    }

    /*Guardem una imatge*/
    public String guardarImatge(File arxiu, byte[] byteImg) {

        String resposta = null;
        try {
            sortida = new FileOutputStream(arxiu);
            sortida.write(byteImg);
            resposta = "La imatge s'ha guardat correctament";
        } catch (Exception e) {
            System.out.println("Quelcom ha sorgit malament");
        }
        return resposta;

    }
    
    /*Mostrem la informació que conté el fitxer seleccionat*/
    
    public String getFileInfo(File arxiu) {

        int Gb = (1024 * 1024 * 1024);
        float midaTotal = arxiu.getTotalSpace() / Gb;
        float espaiDisponible = arxiu.getFreeSpace() / Gb;
        float espaiUtilitzable = arxiu.getUsableSpace() / Gb;
        float pesFitxer = arxiu.length() / 1024;

        String info
                = "Mida total: " + midaTotal + "GB" + "\n"
                + "Espai disponible: " + espaiDisponible + "GB" + "\n"
                + "Nom fitxer: " + arxiu.getName() + "\n"
                + "Path fitxer: " + arxiu.getParent() + "\n"
                + "Espai utilitzable: " + espaiUtilitzable + "GB" + "\n"
                + "Pes fitxer: " + pesFitxer + "KB" + "\n"
                + "Ultima modificació: " + arxiu.lastModified();
        return info;

    }

}
