/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import controller.Controlador;
import model.Model;
import vista.GUI;

/**
 *
 * @author pedro
 */
public class Inici {
    
    private static Model m=new Model();
    private static GUI v=new GUI();
    private static Controlador c;
    
    public static void main(String[] args){
     
        v.setVisible(true);
        v.setLocationRelativeTo(null);
        c=new Controlador(m,v);
    
    
    }
    
}
