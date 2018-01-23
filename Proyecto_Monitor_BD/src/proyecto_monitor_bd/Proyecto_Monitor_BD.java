package proyecto_monitor_bd;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import proyecto_monitor_bd.control.Control;
import proyecto_monitor_bd.modelo.Info_sistema;
import proyecto_monitor_bd.modelo.Idioma;
import proyecto_monitor_bd.vista.Ventana;

public class Proyecto_Monitor_BD {

    public static void main(String[] args) {
        Idioma.actualizar_idioma();
        Proyecto_Monitor_BD p = new Proyecto_Monitor_BD();
        Info_sistema i = new Info_sistema();
        p.iniciar();
        int g;
        while(true){
            g = (int)Math.round(((i.RAMutilizada() / i.RAMtotal())*100));
            controlador.agregar_punto_porcentaje(g);
            p.esperar();
        }
    }
    
    public Proyecto_Monitor_BD(){}
    
    private void iniciar(){
        controlador = new Control();
        Ventana vc = new Ventana(Idioma.var_01,controlador);
        vc.init();
    }
    
    public void esperar(){
        try{
            TimeUnit.MILLISECONDS.sleep(500);
        }catch(Exception e){}
    }
    
    private static Control controlador;
}
