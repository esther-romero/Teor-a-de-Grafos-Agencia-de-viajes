import java.util.ArrayList;
import java.util.*;

public class Mapa {
    private ArrayList<Arista> [] adj;
    private boolean [] vis;
    private Lugar [] padre;
    private int numNodos = 9;
    private ArrayList<Lugar> camino;
    private ArrayList<String> ruta;
    
    private ArrayList<String> visitas;
        
    public Mapa (ArrayList<String> ruta){
        this.ruta = ruta;
        adj = new ArrayList[numNodos];
        for (int i =0;i<numNodos;i++) {
            adj[i] = new ArrayList<>();
        }
        camino  =  new ArrayList<>();
        
        addDepartamentos();
        
        visitas = new ArrayList<>();
        
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
        
        
        vis = new boolean[numNodos];
        padre = new Lugar [numNodos];
        padre [0] = new Lugar(" ","",-1);
        dfs(new Lugar ("Cochabamba","Jorge Wilstermann International Airport (CBB)",0), new Lugar ("Pando","Heroes Del Acre (CIJ)",7),0);
    }

    public void addEdge(Lugar origen,Lugar destino, int pesoV, int pesoF) {
        adj[origen.getNum()].add(new Arista(destino,pesoV,pesoF));
        adj[destino.getNum()].add(new Arista(origen,pesoV,pesoF));
    }
    
    private void addDepartamentos (){
        addEdge(new Lugar("Cochabamba","Jorge Wilstermann International Airport (CBB)",0),new Lugar ("Santa Cruz","Viru Viru Intl (VVI)",1), 45,12);
        addEdge(new Lugar("Cochabamba","Jorge Wilstermann International Airport (CBB)",0),new Lugar ("Sucre","Juana Azurduy De Padilla (SRE)",2),45,0);
        addEdge(new Lugar("Cochabamba","Jorge Wilstermann International Airport (CBB)",0),new Lugar ("Potosi","Capitán Nicolás Rojas (POI)",4),45,0);
        addEdge(new Lugar("Cochabamba","Jorge Wilstermann International Airport (CBB)",0),new Lugar ("Oruro","Aeropuerto Juan Mendoza (ORU)",5),35,5);
        addEdge(new Lugar("Cochabamba","Jorge Wilstermann International Airport (CBB)",0),new Lugar ("La Paz","El Alto Intl (LPB)",6),45,8);
        addEdge(new Lugar("Cochabamba","Jorge Wilstermann International Airport (CBB)",0),new Lugar ("Beni","Jorge Henrich Araúz",8),55,0);
        addEdge(new Lugar ("Santa Cruz","Viru Viru Intl (VVI)",1),new Lugar ("Beni","Jorge Henrich Araúz",8),45,6);
        addEdge(new Lugar ("Santa Cruz","Viru Viru Intl (VVI)",1),new Lugar ("Sucre","Juana Azurduy De Padilla (SRE)",2),45,0);
        addEdge(new Lugar ("Sucre","Juana Azurduy De Padilla (SRE)",2),new Lugar ("Potosi","Capitán Nicolás Rojas (POI)",4),0,0);
        addEdge(new Lugar ("Sucre","Juana Azurduy De Padilla (SRE)",2),new Lugar ("Tarija","Capitan Oriel Lea Plaza (TJA)",3),0,0);
        addEdge(new Lugar ("Tarija","Capitan Oriel Lea Plaza (TJA)",3),new Lugar ("Potosi","Capitán Nicolás Rojas (POI)",4),0,0);
        addEdge(new Lugar ("Potosi","Capitán Nicolás Rojas (POI)",4),new Lugar ("Oruro","Aeropuerto Juan Mendoza (ORU)",5),0,0);
        addEdge(new Lugar ("Oruro","Aeropuerto Juan Mendoza (ORU)",5),new Lugar ("La Paz","El Alto Intl (LPB)",6),25,3);
        addEdge(new Lugar ("La Paz","El Alto Intl (LPB)",6),new Lugar ("Pando","Heroes Del Acre (CIJ)",7),0,0);
        addEdge(new Lugar ("La Paz","El Alto Intl (LPB)",6),new Lugar ("Beni","Jorge Henrich Araúz",8),35,9);
        addEdge(new Lugar ("Pando","Heroes Del Acre (CIJ)",7),new Lugar ("Beni","Jorge Henrich Araúz",8),0,0); 
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
    
    public boolean esCamino(ArrayList<Lugar> camino){
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
    
    private ArrayList<Lugar.Actividad> [] lista;
    private void llenar(){
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
    
    public void getVisitas(Fecha fec){
        llenar();
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
                int contador = 0;
                int con = 0;
                while(con!=numAct){
                    Lugar.Actividad a = lista[i].get(contador); 
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
                    contador++;
                }
                contDias++;
            }
        }
    }
    
    public class Arista {
        private Lugar destino;
        private int pesoFlota,pesoVuelo;
        private boolean ocupado;

        public Arista(Lugar destino,int pesoVuelo, int pesoFlota){
            this.destino   = destino;
            this.pesoVuelo = pesoVuelo;
            this.pesoFlota = pesoFlota;
            ocupado = false;
        }

        public Lugar getDestino(){
            return destino;
        }

        public int getPesoVuelo(){
            return pesoVuelo;
        }

        public int getPesoFlota(){
            return pesoFlota;
        }

        public boolean getOcupado(){
            return ocupado;
        }

        public void setOcupado(boolean ocupado){
            this.ocupado = ocupado;
        }
    }
}