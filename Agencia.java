import java.util.*;


public class Agencia {
    private Mapa mapa;
    private ArrayList<String> ruta;
    private Fecha fechaIni;
    private Fecha fechaFin;
    
    public static void main(String [] args){
        ruta =  new ArrayList<>();
        armarRuta();
        fechaTentativa();
        organizadorViaje();


    }
    public void armarRuta(){
        ruta.add("Cochabamba");
        ruta.add("Pando");
        ruta.add("Oruro");
        ruta.add("La Paz");
        ruta.add("Potosi");
    }
    
    public void fechaTentativa() {
        fechaIni = new Fecha (27,6,2022);
        fechaFin = new Fecha (7,7,2022);
    }
    
    public void organizadorViaje(){
        mapa = new Mapa(ruta);
        mapa.getViajes(fechaIni,fechaFin);
    }
    
    public void organizadorVisitas(){
        mapa.getVisitas(fechaIni);
    }
}
