package clases;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;


public class Frame extends JFrame{
    public Frame(){
        setBounds(700,300,500,300);
        setResizable(false);
        setTitle("Agencia de viajes");
        Lamina milamina = new Lamina();
        add(milamina);
        // jp1 = new JPanel(new GridLayout(3, 1, 5, 7));
        //milamina.setBackground(Color.PINK);
    }
}

class Lamina extends JPanel{
    private Image imagen;
    JButton boton1 = new JButton("Agregar destinos");
    JButton boton2 = new JButton("Agregar Actividades");
    JButton boton3 = new JButton("Fecha de ida");
    JButton boton4 = new JButton("Fecha de Regreso");
    JButton boton5 = new JButton("Diseño de viaje");
    JButton boton6 = new JButton("Diseño de actividades");
    public Lamina(){
        add(boton1);add(boton2);add(boton3);add(boton4);add(boton5);add(boton6);
        setBackground(Color.PINK);
        Agencia agencia = new Agencia();
        boton1.addActionListener(agencia);
        boton2.addActionListener(agencia);
        boton3.addActionListener(agencia);
        boton4.addActionListener(agencia);
        boton5.addActionListener(agencia);
        boton6.addActionListener(agencia);
        
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g); 
        File mimagen = new File("tren.jpg");
        try{
           imagen  = ImageIO.read(mimagen);
        }catch(IOException e){
            System.out.println("la imagen no se encuentra");
        }
        g.drawImage(imagen, 0,63,null);
    }
}

