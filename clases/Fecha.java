package clases;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;
    
    public Fecha(int dia, int mes){
        this.dia  = dia;
        this.mes  = mes;
        anio = 2022;
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

class Conversor {
    public int convertir(String cadena){
        int res=0;
        int cont = 1;
        for(int i=0;i<cadena.length();i++){
            char letraActual = cadena.charAt(i);
            int num = esNumero(letraActual);
            if( num != -1){
                if(i==1){
                    res*=10;
                    res +=num;
                }else{
                    res = num;
                }
            }
        }
        return res;
    }
    
    private int esNumero(char a){
        int res = -1;
        if(a=='1')
            res = 1;
        else if(a=='2')
            res = 2;
        else if(a=='3')
            res = 3;
        else if(a=='4')
            res = 4;
        else if(a=='5')
            res = 5;
        else if(a=='6')
            res = 6;
        else if(a=='7')
            res = 7;
        else if(a=='8')
            res = 8;
        else if(a=='9')
            res = 9;
        else if(a=='0')
            res = 0;
        return res;
    }
}