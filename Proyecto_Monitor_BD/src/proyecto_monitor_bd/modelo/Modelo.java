package proyecto_monitor_bd.modelo;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import proyecto_monitor_bd.vista.Dibujable;
import proyecto_monitor_bd.vista.Dibujador;
import proyecto_monitor_bd.vista.Ventana_info;

public class Modelo extends Observable implements Dibujable {

    public Modelo() {
        puntos = new Lista_Puntos();
        is = new Info_sistema();
        max_permitido = 100;
        arriba_de_max = false;
    }
    
    public void registrar(Observer obs){
        this.addObserver(obs);
    }
    
    public void agregar_punto_porcentaje(Punto np){
        puntos.correr_puntos();
        puntos.agregar(np);
        if(np.getY() > max_permitido){
            if(!arriba_de_max){
                Calendar calendar = Calendar.getInstance();
                LocalDateTime time = LocalDateTime.now();
                try{
                    String texto = generarMensaje(calendar,time);
                    Ventana_info v = new Ventana_info(texto);
                    v.init();
                }catch(Exception e){
                    System.err.println(e.getMessage());
                }
                arriba_de_max = true;
            }
        }
        else if(arriba_de_max)
                arriba_de_max = false;
        
        setChanged();
        notifyObservers();
    }
    
    
    public String generarMensaje(Calendar calendar,LocalDateTime time) throws SQLException {
        String charnl = System.getProperty("line.separator");
        String dia = añadir_cero(String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)));
        String mes = añadir_cero(String.valueOf(calendar.get(Calendar.MONTH)+ 1)); //El mes inicia en cero.
        String hora = añadir_cero(String.valueOf(time.getHour()));
        String minuto = añadir_cero(String.valueOf(time.getMinute()));
        String segundo = añadir_cero(String.valueOf(time.getSecond()));
        String año = String.valueOf(calendar.get(Calendar.YEAR));
        String s = "Se ha superado el límite máximo establecido"+charnl+ 
                " - Fecha: " + dia + "/" + mes+ "/" + año + charnl + 
                " - Hora: " + hora + ":" + minuto + ":" + segundo +charnl+charnl;
        s += Conexion_BD.sentencia(año, mes, dia, hora, minuto);
////////////////////////////////////////////////////////////////////////////////
//        Generar sentencia según un T específico
//        s += Conexion.sentencia("2016", "10", "17", "13", "03") + "</html>";
        E_S.guardar_log(s,dia,mes,año,hora,minuto);
        return s;
    }
    
    public String añadir_cero(String s) {
        if(s.length()==1)
            return "0"+s;
        return s;
    }
    
//    public int calcular_altura_ventana(String texto){
//        String charnl = System.getProperty("line.separator");
//        int cont=0; int pos;
//        while(texto.contains(charnl)){
//            cont++;
//            texto = texto.replaceFirst(charnl,"");
//        }
//        return cont*8;
//    }
    
    
    public void modificar_max_permitido(int nuevo_max){
        max_permitido = nuevo_max;
    }
    
    public int getMax_permitido(){
        return max_permitido;
    }
    
    public void setArriba_de_max(boolean b){
        arriba_de_max = b;
    }
    
    public boolean isArriba_de_max(){
        return arriba_de_max;
    }
    
    @Override
    public void dibujar(Graphics g, Rectangle r){
        int separacion = (int)Math.ceil( r.height /11 );
        int RAMup = puntos.obtener(puntos.tamaño()-1).getY();
        int RAMun = (int)Math.round(is.RAMutilizada());
        int RAMt = (int)is.RAMtotal();
        Dibujador.dibujar_leyenda(g,r,separacion);
        Dibujador.dibujar_grafica(puntos.obtener_puntos(),g, r,separacion);
        Dibujador.dibuja_info(g, RAMup, RAMun, RAMt, max_permitido, separacion);
    }

    private final Lista_Puntos puntos;
    private final Info_sistema is;
    private int max_permitido;
    private boolean arriba_de_max;
}
