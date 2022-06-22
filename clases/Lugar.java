package clases;

import java.util.*;

public class Lugar {
    private ArrayList<Actividad> actividades; 
    private String nombre;
    private String nombreAereo;
    private int num;
    public Lugar(String nombre, String nombreAereo, int num){
        this.nombreAereo = nombreAereo;
        this.nombre     = nombre;
        this.num        = num;
        actividades     = new ArrayList<>();
    }
    
    public String getNombreAereo(){
        return nombreAereo;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getNum(){
        return num;
    }
    
    public ArrayList<Actividad> getActividad(){
        ArrayList<Actividad> res = new ArrayList<>();
        if(nombre.equals("Cochabamba")){
            actCBBA();
            res = actividades;
        }else if(nombre.equals("Santa Cruz")){
            actSC();
            res = actividades;
        }else if(nombre.equals("La Paz")){
            actLP();
            res = actividades;
        }else if(nombre.equals("Oruro")){
            actOR();
            res = actividades;
        }else if(nombre.equals("Beni")){
            actBN();
            res = actividades;
        }else if(nombre.equals("Sucre")){
            actCQSC();
            res = actividades;
        }else if(nombre.equals("Tarija")){
            actTJ();
            res = actividades;
        }else if(nombre.equals("Potosi")){
            actPT();
            res = actividades;
        }else {
            actPN();
            res = actividades;
        }
        
        return res;
    } 
    
    public void actCBBA(){
        actividades.add(new Lugar.Actividad("Cristo de la Concordia",2));
        actividades.add(new Lugar.Actividad("Palacio portales",1));
        actividades.add(new Lugar.Actividad("Pico Tunari",4));
        actividades.add(new Lugar.Actividad("Convento museo santa teresa",2));
        actividades.add(new Lugar.Actividad("Parque de la familia",4));
    }
    
    public void actSC(){
        actividades.add(new Lugar.Actividad("Plaza 24 de Septiembre",2));
        actividades.add(new Lugar.Actividad("Samaipata",4));
        actividades.add(new Lugar.Actividad("Iglesias de la Chiquitania",2));
        actividades.add(new Lugar.Actividad("Parque Lomas de Arena",3));
        actividades.add(new Lugar.Actividad("Ventura mall",3));
        actividades.add(new Lugar.Actividad("Jardin Botanico Santa Cruz",4));
        actividades.add(new Lugar.Actividad("Santuario de Cotoca",3));
        actividades.add(new Lugar.Actividad("AquaLand",6));
    }
    
    public void actLP(){
        actividades.add(new Lugar.Actividad("Mi Teleferico",3));
        actividades.add(new Lugar.Actividad("WMDR Yungas Road",5));
        actividades.add(new Lugar.Actividad("Valle de la Luna",4));
        actividades.add(new Lugar.Actividad("Mirador Killi Killi",3));
        actividades.add(new Lugar.Actividad("Urban Rush Bolivia",3));
        actividades.add(new Lugar.Actividad("Iglesia de San Francisco",2));
        actividades.add(new Lugar.Actividad("Mercado de las Brujas",3));
        actividades.add(new Lugar.Actividad("Muela del Diablo",4));
    }
    
    public void actPT(){
        actividades.add(new Lugar.Actividad("Cerro Rico",5));
        actividades.add(new Lugar.Actividad("Laguna Colorada",3));
        actividades.add(new Lugar.Actividad("Parque Nacional Torotoro",4));
        actividades.add(new Lugar.Actividad("Casa Nacional de la Moneda",2));
        actividades.add(new Lugar.Actividad("Plaza 10 de Noviembre",2));
        actividades.add(new Lugar.Actividad("Ojo del Inca",3));
        actividades.add(new Lugar.Actividad("Laguna Negra",3));
        actividades.add(new Lugar.Actividad("Catedral de la ciudad de Potosi",3));
    }
    
    public void actCQSC(){
        actividades.add(new Lugar.Actividad("Museo Casa de la Libertad",2));
        actividades.add(new Lugar.Actividad("Museo del Tesoro",3));
        actividades.add(new Lugar.Actividad("Plaza 25 de Mayo",2));
        actividades.add(new Lugar.Actividad("Parque Cretácico",4));
        actividades.add(new Lugar.Actividad("Museo de Arte Indigena",4));
        actividades.add(new Lugar.Actividad("La Recoleta",2));
        actividades.add(new Lugar.Actividad("Simon Bolivar Park",2));
        actividades.add(new Lugar.Actividad("Cretaceous Park",4));
    }
    
    public void actTJ(){
        actividades.add(new Lugar.Actividad("Museo Paleontológico y Arqueologico",4));
        actividades.add(new Lugar.Actividad("Plaza Luis de Fuentes",3));
        actividades.add(new Lugar.Actividad("La Casa Vieja",2));
        actividades.add(new Lugar.Actividad("Bodega Casa Real",3));
        actividades.add(new Lugar.Actividad("Bodega Campos de Solana",2));
        actividades.add(new Lugar.Actividad("Casa Dorada",3));
        actividades.add(new Lugar.Actividad("Chorros de Marquiri",3));
        actividades.add(new Lugar.Actividad("Iglesia de San Roque",3));
    }
    //7
    public void actOR(){
        actividades.add(new Lugar.Actividad("Samaja National Park",4));
        actividades.add(new Lugar.Actividad("Monumento a la Virgen del Socavon",2));
        actividades.add(new Lugar.Actividad("Plaza 10 de Febrero",1));
        actividades.add(new Lugar.Actividad("Las Mina de San Jose",3));
        actividades.add(new Lugar.Actividad("Archaeological Museum",3));
        actividades.add(new Lugar.Actividad("Catedral de Oruro",2));
        actividades.add(new Lugar.Actividad("Iglesia San Gerardo",2));
    }
        
    public void actPN(){
        actividades.add(new Lugar.Actividad("Reserva de Vida Silvestre Manuripi",4));
        actividades.add(new Lugar.Actividad("Chive",3));
        actividades.add(new Lugar.Actividad("Sena Boliviar",3));
        actividades.add(new Lugar.Actividad("Cachuela esperanza",3));
        actividades.add(new Lugar.Actividad("Puerto Rico",3));
    }    
    
    public void actBN(){
        actividades.add(new Lugar.Actividad("River Yacuma",4));
        actividades.add(new Lugar.Actividad("Barba Azul Reserve",3));
        actividades.add(new Lugar.Actividad("Laguna Suárez",3));
        actividades.add(new Lugar.Actividad("Conservacion Loros Bolivia",4));
        actividades.add(new Lugar.Actividad("Aquicuana Reserve",2));
    }
    
    public class Actividad{
        private String nombre;
        private int tiempo;
        
        public Actividad(String nombre, int tiempo){
            this.nombre = nombre;
            this.tiempo = tiempo;
        }
        
        public String getNombreActividad(){
            return nombre;
        }
        
        public int getTiempoActividad(){
            return tiempo;
        }
    }
}