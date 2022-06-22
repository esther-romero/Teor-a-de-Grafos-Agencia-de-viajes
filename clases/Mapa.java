package clases;

import java.util.*;

public class Mapa {
    private ArrayList<Arista> [] adj;
    private boolean [] vis;
    private Lugar [] padre;
    private int numNodos = 9;
    private ArrayList<Lugar> camino;
    private ArrayList<String> ruta;
    private ArrayList<Lugar.Actividad> [] lista;


    public Mapa (ArrayList<String> ruta, String origen, String destino){
        this.ruta = ruta;
        camino  =  new ArrayList<>();
        adj = new ArrayList[numNodos];
        for (int i =0;i<numNodos;i++) {
            adj[i] = new ArrayList<>();
        }
        
        addDepartamentos();
        Lugar ori = getConvertido(origen);
        vis = new boolean[numNodos];
        padre = new Lugar [numNodos];
        padre [ori.getNum()] = new Lugar(" ","",-1);
        dfs(ori, getConvertido(destino),0);
    }
    
    private Lugar getConvertido(String nombre){
        Lugar res;
        if(nombre.equals("Cochabamba")){
            res = new Lugar ("Cochabamba","Jorge Wilstermann International Airport (CBB)",0);
        }else if(nombre.equals("Santa Cruz")){
            res = new Lugar ("Santa Cruz","Viru Viru Intl (VVI)",1);
        }else if(nombre.equals("La Paz")){
            res = new Lugar ("La Paz","El Alto Intl (LPB)",6);
        }else if(nombre.equals("Oruro")){
            res = new Lugar ("Oruro","Aeropuerto Juan Mendoza (ORU)",5);
        }else if(nombre.equals("Beni")){
            res = new Lugar ("Beni","Jorge Henrich Araúz",8);
        }else if(nombre.equals("Sucre")){
            res = new Lugar ("Sucre","Juana Azurduy De Padilla (SRE)",2);
        }else if(nombre.equals("Tarija")){
            res = new Lugar ("Tarija","Capitan Oriel Lea Plaza (TJA)",3);
        }else if(nombre.equals("Potosi")){
            res = new Lugar ("Potosi","Capitán Nicolás Rojas (POI)",4);
        }else {
            res = new Lugar ("Pando","Heroes Del Acre (CIJ)",7);
        }
        return res;
    }
    
    public void addEdge(Lugar origen,Lugar destino, int pesoV) {
        adj[origen.getNum()].add(new Arista(destino,pesoV));
        adj[destino.getNum()].add(new Arista(origen,pesoV));
    }
    
    private void addDepartamentos (){
        addEdge(getConvertido("Cochabamba"),getConvertido("Santa Cruz"),45);
        addEdge(getConvertido("Cochabamba"),getConvertido("Sucre"),45);
        addEdge(getConvertido("Cochabamba"),getConvertido("Potosi"),45);
        addEdge(getConvertido("Cochabamba"),getConvertido("Oruro"),35);
        addEdge(getConvertido("Cochabamba"),getConvertido("La Paz"),45);
        addEdge(getConvertido("Cochabamba"),getConvertido("Beni"),55);
        addEdge(getConvertido("Santa Cruz"),getConvertido("Beni"),45);
        addEdge(getConvertido("Santa Cruz"),getConvertido("Sucre"),45);
        addEdge(getConvertido("Sucre"),getConvertido("Potosi"),45);
        addEdge(getConvertido("Sucre"),getConvertido("Tarija"),35);
        addEdge(getConvertido("Tarija"),getConvertido("Potosi"),45);
        addEdge(getConvertido("Potosi"),getConvertido("Oruro"),35);
        addEdge(getConvertido("Oruro"),getConvertido("La Paz"),25);
        addEdge(getConvertido("La Paz"),getConvertido("Pando"),35);
        addEdge(getConvertido("La Paz"),getConvertido("Beni"),35);
        addEdge(getConvertido("Pando"),getConvertido("Beni"),35); 
    }

    public void dfs(Lugar v, Lugar destino,int cont) {
        vis[v.getNum()] = true;  
        if(v.getNum()==destino.getNum()) {
            Lugar aux = v;
            while (aux.getNum() != -1 && cont<1) {
                camino.add(aux);
                aux = padre[aux.getNum()];
            }  
        
            if(camino.size() == ruta.size() && cont<1){
                Collections.reverse(camino);
                if(esCamino(camino))
                    cont++;
            }
            
            if (cont==0){
                camino.clear();  
                vis[v.getNum()] = false;
            }
            return;
        }
        for (Arista u : adj[v.getNum()]) {
            if(!vis[u.getDestino().getNum()]) {
                padre[u.getDestino().getNum()] = v;
                dfs(u.getDestino(),destino,cont);
            }
        }
        vis[v.getNum()] = false;
    }
    
    private boolean esCamino(ArrayList<Lugar> camino){
        boolean res=true;
        int i = 0;
        while (i<camino.size() && res){
            Lugar lugar = camino.get(i);
            res = ruta.contains(lugar.getNombre());
            i++;
        }        
        return res;
    }
    int num;
    public void getViajes(Fecha fechaIni, Fecha fechaFin){   
        System.out.println("\n1) ORGANIZACION DE VIAJE\n");
        System.out.print("Plan de viaje: ");
        
        for(Lugar a : camino){
            System.out.print(a.getNombre() + " ");
        }
        
        int dias = fechaIni.diferenciaFechas(fechaIni,fechaFin);
        fechaFin.restarDia(dias % (ruta.size()-1));
        dias = fechaIni.diferenciaFechas(fechaIni,fechaFin);
        System.out.println("\nFechas de viaje: " + fechaIni.getFecha()+" - " +fechaFin.getFecha()+ " ("+dias+" dias)");
        
        System.out.println("Transporte - BOA Boliviana de Aviación\n");
        num = dias/(ruta.size()-1);
        for(int i=0; i<(camino.size())-1;i++){
            Lugar a = camino.get(i);
            Lugar b = camino.get(i+1);
            for(Arista u : adj[a.getNum()]){
                if(u.getDestino().getNum() == b.getNum()){
                    System.out.println(fechaIni.getFecha()+" Salida  06:00 - " + a.getNombre() + "," + a.getNombreAereo());
                    System.out.println(fechaIni.getFecha() + " Llegada 06:" + u.getPesoVuelo() + " - " + b.getNombre() + "," + b.getNombreAereo() + ", Estadía de "+ num + " días");
                    fechaIni.aumentarDia(num);
                }
            }
        }
        int aumentar = num*(ruta.size()-1); 
        fechaIni.restarDia(aumentar);
    }
    
    private void llenar(ArrayList<String> visitas){
        lista = new ArrayList[camino.size()];
        for (int i =1;i<camino.size();i++) {
            lista[i] = new ArrayList<>();
            Lugar a = camino.get(i);
            ArrayList<Lugar.Actividad> acti = a.getActividad();
            
            for(Lugar.Actividad s : acti){
                String nom = s.getNombreActividad();
                if(visitas.contains(nom)){
                    lista[i].add(s);    
                }
            }
        }
    }
    
    public void getVisitas(Fecha fec,ArrayList<String> visitas){
        llenar(visitas);
        int contDias = 1;
        System.out.println("\n\n2) ORGANIZACION DE VISITAS");
        
        for(int i=1;i<camino.size();i++){
            int numAct = lista[i].size()/num; 
            for(int j=1;j<=num ;j++){
                int hora = 8;
                Lugar visitado = camino.get(i); 
                System.out.println("\n("+fec.getFecha() +") DIA " + contDias + " " + visitado.getNombre().toUpperCase());
                System.out.println("Hora        Actividad          Descripción");
                System.out.println("8:00 hrs.   Desayuno Buffet    Restaurante del Hotel");
                fec.aumentarDia(1);
                hora+=1;
                int con = 0;
                while(con!=numAct){
                    Lugar.Actividad a = lista[i].get(con); 
                    System.out.println(hora+":00 hrs   " + a.getNombreActividad());
                    hora += a.getTiempoActividad();
                    con+=1;
                    if (hora<=14 && con==1){
                        System.out.println(hora+":00 hrs  " + " almuerzo           Comida Tipica de "+ visitado.getNombre());
                        hora+=2;
                    }
                    if(hora<=16 && con == numAct){
                        System.out.println(hora+":00 hrs  " + " Actividades Recreativas");
                    }
                    if(con == numAct){
                        System.out.println("18:30 hrs  " + " Fin del circuito    Llegada al Hotel");
                    }
                    lista[i].remove(a);
                }
                contDias++;
            }
        }
    }
    
    public class Arista {
        private Lugar destino;
        private int pesoVuelo;

        public Arista(Lugar destino,int pesoVuelo){
            this.destino   = destino;
            this.pesoVuelo = pesoVuelo;
        }

        public Lugar getDestino(){
            return destino;
        }

        public int getPesoVuelo(){
            return pesoVuelo;
        }
    }
}