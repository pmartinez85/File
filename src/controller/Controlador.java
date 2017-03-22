/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author pedro
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.Model;
import vista.GUI;

public class Controlador {

    public Model m;
    public GUI v;
    public File arxiu;
    public JFileChooser seleccionat = new JFileChooser();
    public byte[] bytesImg;

    public Controlador(Model m, GUI v) {
        this.m = m;
        this.v = v;
        this.v.setVisible(true);

        control(m, v);
    }

    public void control(Model m, GUI v) {

        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if (actionEvent.getSource().equals(v.getBtnObrirArxiu())) {
                    int result = v.getFileChooser().showOpenDialog(v.getFileChooser());

                    if (result == v.getFileChooser().APPROVE_OPTION) {
                        File file = v.getFileChooser().getSelectedFile();
                        v.getPathJTF().setText(file.getAbsolutePath());
                    
                        if (file.isFile()) v.getEsfitxerbtn().setSelected(true);
                        if (file.isDirectory())v.getEsdirectoribtn().setSelected(true);
                        if (file.canExecute()) v.getExecutarbtn().setSelected(true);
                        if (file.canRead()) v.getLlegirbtn().setSelected(true);
                        if (file.canWrite()) v.getEscriurebtn().setSelected(true);
                    }
                }    
                if (actionEvent.getSource().equals(v.getBtnMostrarcaract())) {
                    File file = v.getFileChooser().getSelectedFile();
                    System.out.println(m.getFileInfo(file));
                    
                    JOptionPane.showMessageDialog(null, m.getFileInfo(file) , "informació", JOptionPane.INFORMATION_MESSAGE);
                }
                if (actionEvent.getSource().equals(v.getObririmatgebtn())) {
                    File arxiu = v.getFileChooser().getSelectedFile();
                    if (arxiu.canRead()) {
                        if (arxiu.getName().endsWith("txt")) {
                            String contingut = m.obrirText(arxiu);
                            v.getTxtAreaText().setText(contingut);
                        } else if (arxiu.getName().endsWith("jpg") || arxiu.getName().endsWith("png") || arxiu.getName().endsWith("gif")) {
                            bytesImg = m.obrirImatge(arxiu);
                            v.getLblImagen().setIcon(new ImageIcon(bytesImg));
                        } else {
                            JOptionPane.showMessageDialog(null, "Selecciona un arxiu de text o imatge");
                        }
                    }
                }
                if (actionEvent.getSource().equals(v.getBtnGuardarText())) {
                 File arxiu = v.getFileChooser().getSelectedFile();
                if (arxiu.getName().endsWith("txt")) {
                    String contingut = v.getTxtAreaText().getText();
                    String resposta = m.guardarArxiuText(arxiu, contingut);
                    if (resposta != null) {
                        JOptionPane.showMessageDialog(null, resposta);
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al guardar el text");

                    }
                } else {
                    JOptionPane.showMessageDialog(null, "L'arxiu s'ha de guardar en un format correcte");
                }
            }
        } 
       };
        
        v.getBtnGuardarImatge().addActionListener(actionListener);
        v.getBtnGuardarText().addActionListener(actionListener);
        v.getBtnCrearfitxer().addActionListener(actionListener);
        v.getBtnCreardirectori().addActionListener(actionListener);
        v.getBtnMostrarcaract().addActionListener(actionListener);
        v.getBtnObrirArxiu().addActionListener(actionListener);
        v.getObririmatgebtn().addActionListener(actionListener);

    }
}
