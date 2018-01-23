package proyecto_monitor_bd.modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class E_S {
    public static void guardar_log(String s, String dia, String mes, String año, String hora, String minuto){
        try {
            String ruta = Idioma.var_19+File.separator+dia+"-"+mes+"-"+año;
            new File(ruta).mkdirs();
            FileOutputStream fos = new FileOutputStream(ruta+File.separator+hora+"-"+minuto+".txt");
            BufferedWriter salida = new BufferedWriter(new OutputStreamWriter(fos,"UTF-8"));
            salida.write(s);
            salida.newLine();
            salida.close();
        }catch(Exception e){System.err.println(e.getMessage());}
    }
}