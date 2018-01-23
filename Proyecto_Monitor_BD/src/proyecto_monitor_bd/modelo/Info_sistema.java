package proyecto_monitor_bd.modelo;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Info_sistema {
    public Info_sistema(){
        o = ManagementFactory.getOperatingSystemMXBean();
        m = o.getClass().getMethods();
        m[1].setAccessible(true); // FreePhysicalMemorySize
        m[6].setAccessible(true); // TotalPhysicalMemorySize
    }
    
    public double RAMlibre(){
        double d = 0;
        try{
            d = Double.parseDouble(m[1].invoke(o).toString()) / conversion;
        }catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
            System.err.println(e.getMessage());
        }
        return d;
    }
    
    public double RAMtotal(){
        double d = 0;
        try{
            d = Double.parseDouble(m[6].invoke(o).toString()) / conversion;
        }catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e){
            System.err.println(e.getMessage());
        }
        return d;
    }
    
    public double RAMutilizada(){
        return RAMtotal() - RAMlibre();
    }
    
    Method[] m;
    private final OperatingSystemMXBean o;
    private final int conversion = (1024*1024); // Byte => MegaByte
}