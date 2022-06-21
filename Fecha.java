public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    
    public Fecha(int dia, int mes, int anio){
        this.dia  = dia;
        this.mes  = mes;
        this.anio = anio;
    }
    
    public String getFecha(){
        return dia + "/" + mes + "/" + anio;
    }
    
    public void aumentarDia(int n) {
        for(int i =0;i<n;i++){
            if(dia == 30){
                dia = 1;
                mes += 1;
            }else
                dia+=1;    
        }
    }
    
    public void restarDia(int n){
        for(int i =0;i<n;i++){
            if(dia == 1){
                dia = 30;
                mes -= 1;
            }else
                dia-=1;    
        }
    }
    
    public int diferenciaFechas(Fecha a, Fecha b){
        int res = 0;
        if(a.mes==b.mes){
            res = b.dia - a.dia;
        }else{
            res = (b.dia - a.dia) + 30;
        }
        return res;
    }
}