package proyecto_monitor_bd.vista;

import proyecto_monitor_bd.modelo.Idioma;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import proyecto_monitor_bd.modelo.Punto;

public class Dibujador {
    public static void dibujar_leyenda(Graphics g, Rectangle r, int separacion){
        g.setColor(color);
        int largo = (int)(r.width*0.98);
        g.drawLine(35, (int)(separacion*0.3), 35, (10*separacion + separacion/2));
        g.drawLine(largo, (int)(separacion*0.3), largo, (10*separacion + separacion/2));
        g.drawLine(35, (10*separacion + separacion/2), largo , (10*separacion + separacion/2));
        g.drawLine(35, (int)(separacion*0.3), largo , (int)(separacion*0.3));
        g.drawString("100%", 1, (0*separacion   + (int)(separacion/2.1)));
        g.drawString(" 90%", 1, (1*separacion   + (int)(separacion/2.1)));
        g.drawString(" 80%", 1, (2*separacion   + (int)(separacion/2.1)));
        g.drawString(" 70%", 1, (3*separacion   + (int)(separacion/2.1)));
        g.drawString(" 60%", 1, (4*separacion   + (int)(separacion/2.1)));
        g.drawString(" 50%", 1, (5*separacion   + (int)(separacion/2.1)));
        g.drawString(" 40%", 1, (6*separacion   + (int)(separacion/2.1)));
        g.drawString(" 30%", 1, (7*separacion   + (int)(separacion/2.1)));
        g.drawString(" 20%", 1, (8*separacion   + (int)(separacion/2.1)));
        g.drawString(" 10%", 1, (9*separacion   + (int)(separacion/2.1)));
        g.drawString("   0%", 1, (10*separacion + (int)(separacion/2.1)));
    }
    
    public static void dibujar_grafica(ArrayList<Punto> puntos, Graphics g, Rectangle r, int separacion) {
        g.setColor(color);
        int largo = (int)(r.width*0.98);
        int max=puntos.size();int i,x1,x2,y1,y2;
        for (i=0; i<max-1; i++) {
            x1 = puntos.get(i+1).getX();
            y1 = calcula_posicion(separacion,puntos.get(i+1).getY());
            x2 = puntos.get(i).getX();
            y2 = calcula_posicion(separacion,puntos.get(i).getY());
            if (x1 <= largo && x2 > largo)
                x2 = largo;
            g.drawLine(x1,y1,x2,y2);
        }
    }
    
    public static void dibuja_info(Graphics g, int RAMup, int RAMun, int RAMt, int max_permitido, int separacion){
        String s = String.format(Idioma.var_12+" "+Idioma.var_13, RAMup, RAMun, RAMt, max_permitido);
        g.drawString(s, 3, 10*separacion+(int)(separacion/1.05));
        //g.drawString("Memoria RAM utilizada actualmente: "+RAMup+"%, "+RAMun+"/"+RAMt+" MB. Máximo permitido actualmente: "+max_permitido+"%.", 3, 11*separacion);
    }
    
    public static int calcula_posicion(int separacion, int porcentaje){
        if(porcentaje == 100)
            return (int)(separacion/2.1);
        double uldigito = porcentaje%10;
        int veces = 10 - ((int)porcentaje/10);
        if(uldigito > 0){
            veces -= 1;
            uldigito = 10-uldigito;
        }
        int a=(int)((veces*separacion + (int)(separacion/2.8)) + (separacion*(uldigito/10.0)));
        return a;
    }
    
    public static Color color = new Color(0,204,0);
}
