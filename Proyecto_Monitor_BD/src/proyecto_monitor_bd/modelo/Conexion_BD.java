
package proyecto_monitor_bd.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion_BD {
    public static String sentencia(String anno, String mes, String dia, String hora, String minuto) throws SQLException {
        String charnl = System.getProperty("line.separator");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "SYSTEM", "root");

        Statement stmt = conn.createStatement();
        String s = "SELECT C.SQL_FULLTEXT, C.SHARABLE_MEM \"MEM (BYTES)\", C.CPU_TIME \"CPU (SEGS)\", U.USERNAME " +
                        "FROM V$SQL C, DBA_USERS U " +
                        "where C.first_load_time like '%" + anno + "-" + mes + "-" + dia + "/" + hora + ":" + minuto + ""
                + "%' " + "AND  U.USER_ID = C.PARSING_USER_ID";
        ResultSet rset
                = stmt.executeQuery(s);
        int c = 1;
        s = Idioma.var_14+" " + hora + ":" + minuto + charnl;
        while (rset.next()) {
            s += String.format ("%d)"+charnl, c++);
            s += imprimirInformacion(rset);  // Print col 1
        }
        stmt.close();
        return s;
       
        // String de prueba
        //String s = "Consultas ocurridas en el tiempo 13:03"+charnl+"1)"+charnl+"Sentencia SQL: select * from v$sql where first_load_time like '%2016-10-17/13:03%' "+charnl+"Memoria (Bytes): 84597"+charnl+"CPU (Segundos): 15625"+charnl+"Usuario: SYS"+charnl+""+charnl+"";
        //return s;//"<html>Se ha superado el límite máximo establecido<br> - Fecha: 17/9/2016<br> - Hora: 13:24:21<br><br>Consultas ocurridas en el tiempo 13:03<br>1)<br>Sentencia SQL: select * from v$sql where first_load_time like '%2016-10-17/13:03%' <br>Memoria (Bytes): 84597<br>CPU (Segundos): 15625<br>Usuario: SYS<br><br></html>";
    }
    
    public static String imprimirInformacion(ResultSet rs) throws SQLException {
        String s = "";
        s = s + Idioma.var_15+ " " + rs.getString(1) + "\n";
        s = s + Idioma.var_16+ " " + rs.getString(2) + "\n";
        s = s + Idioma.var_17+ " " + rs.getString(3) + "\n";
        s = s + Idioma.var_18+ " " + rs.getString(4) + "\n\n";
        return s;
    }
}
