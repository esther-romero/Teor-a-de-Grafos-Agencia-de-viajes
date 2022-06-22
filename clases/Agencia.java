package clases;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import java.io.*;
import java.awt.event.*;

public class Agencia implements ActionListener{
    private Mapa mapa;
    private ArrayList<String> ruta;
    private ArrayList<String> visitas;
    private Fecha fechaIni;
    private Fecha fechaFin;
    
    public Agencia () {
        ruta =  new ArrayList<>();
        visitas = new ArrayList<>();
    }
    
    public void actionPerformed(ActionEvent e){
        Object botonPulsado=e.getSource();
        if(botonPulsado.toString().contains("Agregar destinos")){
            armarRuta();    
        }else if (botonPulsado.toString().contains("Agregar Actividades")){
            armarVisitas();
        }else if (botonPulsado.toString().contains("Fecha de ida")){
            fechaTentativa(1);
        }else if (botonPulsado.toString().contains("Fecha de Regreso")){
            fechaTentativa(2);
        }else if (botonPulsado.toString().contains("Diseño de viaje")){
            organizadorViaje();
        }else if (botonPulsado.toString().contains("Diseño de actividades")){
            organizadorVisitas();
        }
        
    }
    
    public void armarRuta(){
        String nombre = JOptionPane.showInputDialog("Introduce un lugar");
        ruta.add(nombre);
    }
    
    public void armarVisitas(){
        String nombre = JOptionPane.showInputDialog("Introduce Actividad");
        visitas.add(nombre);
    }
    
    public void fechaTentativa(int num) {
        String dia = JOptionPane.showInputDialog("Introduce dia");
        String mes = JOptionPane.showInputDialog("Introduce mes");
        Conversor c = new Conversor();
        if(num==1)
            fechaIni = new Fecha (c.convertir(dia),c.convertir(mes));
        else
            fechaFin = new Fecha (c.convertir(dia),c.convertir(mes));
    }
    
    public void organizadorViaje(){
        String origen = JOptionPane.showInputDialog("Introduce Origen");
        String destino = JOptionPane.showInputDialog("Introduce Destino");
        mapa = new Mapa(ruta,origen,destino);
        mapa.getViajes(fechaIni,fechaFin);
    }
    
    public void organizadorVisitas(){
        mapa.getVisitas(fechaIni,visitas);
    }
}