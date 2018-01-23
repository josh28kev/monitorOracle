package proyecto_monitor_bd.modelo;

import java.io.BufferedReader;
import java.io.FileReader;

public class Idioma {
    public static void actualizar_idioma(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("language.txt"));
            String s;
            if((s=br.readLine()) != null){
                s = (s.replace("language: ", ""));
                if(s.compareTo("spanish") == 0)
                    cambiar_idioma_a_español();
            }
            br.close();
        }catch(Exception e){System.err.println(e.getMessage());}
    }
    
    public static void cambiar_idioma_a_español(){
        var_01 = "Monitor de Bases de Datos JJJ";
        var_02 = "Archivo";
        var_03 = "Salir";
        var_04 = "Edición";
        var_05 = "Máximo permitido";
        var_06 = "Acerca de";
        var_07 = "Créditos";
        var_08 = "Información";
        var_09 = "Modificar máximo permitido";
        var_10 = "Aceptar";
        var_11 = "Digite el nuevo máximo permitido:";
        var_12 = "Memoria RAM utilizada actualmente: %s%%, %s/%s MB.";
        var_13 = "Máximo permitido actualmente: %s%%.";
        var_14 = "Consultas ocurridas en el tiempo";
        var_15 = "Sentencia SQL:";
        var_16 = "Memoria (Bytes):";
        var_17 = "CPU (segundos):";
        var_18 = "Usuario:";
        var_19 = "picos";
    }
    
    public static String var_01 = "Database Monitor JJJ";
    public static String var_02 = "Archive";
    public static String var_03 = "Exit";
    public static String var_04 = "Edit";
    public static String var_05 = "Maximum allowed";
    public static String var_06 = "About";
    public static String var_07 = "Credits";
    public static String var_08 = "Info";
    public static String var_09 = "Modify maximum allowed";
    public static String var_10 = "OK";
    public static String var_11 = "Type the new maximum allowed:";
    public static String var_12 = "RAM memory used now: %s%%, %s/%s MB.";
    public static String var_13 = "Maximum allowed now: %s%%.";
    public static String var_14 = "Queries happened in the time";
    public static String var_15 = "SQL query:";
    public static String var_16 = "Memory (Bytes):";
    public static String var_17 = "CPU (seconds):";
    public static String var_18 = "User:";
    public static String var_19 = "Peaks";
}
