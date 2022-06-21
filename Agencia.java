import java.util.*;

public class Agencia {
    private Mapa mapa;
    private ArrayList<String> ruta;
    private ArrayList<String> visitas;
    private Fecha fechaIni;
    private Fecha fechaFin;
    
    public Agencia (){
        ruta =  new ArrayList<>();
        visitas = new ArrayList<>();
    }

    public void armarRuta(){
        ruta.add("Cochabamba");
        ruta.add("Pando");
        ruta.add("Oruro");
        ruta.add("La Paz");
        ruta.add("Potosi");
    }
    
    public void armarVisitas(){
        visitas.add("Mi Teleferico");
        visitas.add("WMDR Yungas Road");
        visitas.add("Valle de la Luna");
        visitas.add("Cerro Rico");//
        visitas.add("Laguna Colorada");
        visitas.add("Parque Nacional Torotoro");
        visitas.add("Samaja National Park");
        visitas.add("Monumento a la Virgen del Socavon");
        visitas.add("Reserva de Vida Silvestre Manuripi");
        visitas.add("Chive");
        visitas.add("Sena Boliviar");
        visitas.add("Cachuela esperanza");
        visitas.add("Puerto Rico");
    }
    
    public void fechaTentativa() {
        fechaIni = new Fecha (27,6,2022);
        fechaFin = new Fecha (7,7,2022);
    }
    
    public void organizadorViaje(String origen, String destino){
        mapa = new Mapa(ruta,origen,destino);
        mapa.getViajes(fechaIni,fechaFin);
    }
    
    public void organizadorVisitas(){
        mapa.getVisitas(fechaIni,visitas);
    }
}