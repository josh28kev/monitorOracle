package proyecto_monitor_bd.control;

import java.util.Observer;
import proyecto_monitor_bd.modelo.Modelo;
import proyecto_monitor_bd.modelo.Punto;
import proyecto_monitor_bd.vista.VentanaEmergente;
import proyecto_monitor_bd.vista.Ventana_modificar_max;

public class Control {
    
    public Control() {
        modelo = new Modelo();
    }
    
    public void registrar(Observer obs){
        modelo.registrar(obs);
    }
    
    public void agregar_punto_porcentaje(int valor_y){
        modelo.agregar_punto_porcentaje(new Punto(35,valor_y));
    }
    
    public void abrir_ventana_modificar_max_permitido(){
        Ventana_modificar_max v = new Ventana_modificar_max(this, modelo.getMax_permitido());
        v.init();
    }
    
    public void abrir_ventana_creditos(String mensaje, String s1, String s2, String s3){
        VentanaEmergente v = new VentanaEmergente(mensaje,s1,s2,s3);
        v.init(null);
    }
    
    public void modificar_max_permitido(int nuevo_max){
        modelo.modificar_max_permitido(nuevo_max);
    }
    
    Modelo modelo;
}