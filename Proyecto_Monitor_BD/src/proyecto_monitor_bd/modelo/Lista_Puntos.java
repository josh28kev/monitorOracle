package proyecto_monitor_bd.modelo;

import java.awt.Point;
import java.util.ArrayList;

public class Lista_Puntos {
    public Lista_Puntos() {
        puntos = new ArrayList<>();
    }

    public void agregar(Punto np) {
        puntos.add(np);
        if(puntos.size() > 99)
            puntos.remove(0);
    }
    
    public void correr_puntos(){
        for(Punto p: puntos)
            p.setX(p.getX()+20);
    }

    public ArrayList<Punto> obtener_puntos() {
        return puntos;
    }
    
    public Punto obtener(int i){
        return puntos.get(i);
    }
    
    public int tamaño(){
        return puntos.size();
    }

    private final ArrayList<Punto> puntos;
}
