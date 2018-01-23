package proyecto_monitor_bd.modelo;

public class Punto {
    public Punto(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public String toString(){
        return "Punto: ("+x+","+y+")";
    }
    
    private int x;
    private final int y;
}
