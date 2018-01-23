package proyecto_monitor_bd.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import proyecto_monitor_bd.control.Control;

public class Ventana extends JFrame implements Observer{
    public Ventana(String titulo, Control controlador) {
        super(titulo);
        this.controlador = controlador;
        
        ajustarComponentes(getContentPane());
        setMinimumSize(new Dimension(848, 480));
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void ajustarComponentes(Container c) {
        c.setLayout(new BorderLayout());
        panelPrincipal = new PanelDibujo();
        c.add(BorderLayout.CENTER, panelPrincipal);
        setJMenuBar(barra_superior = new Barra(controlador));
    }

    public void init() {
        controlador.registrar(this);
        setVisible(true);
    }

    private final Control controlador;
    private JPanel panelPrincipal;
    private Barra barra_superior;

    @Override
    public void update(Observable o, Object arg) {
        ((PanelDibujo) panelPrincipal).actualizar((Dibujable) o);
    }
}

class PanelDibujo extends JPanel {

    public PanelDibujo() {
        this.d = null;
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics bg) {
        super.paintComponent(bg);
        if (d != null) {
            d.dibujar((Graphics2D) bg, getBounds());
        }
    }

    public void actualizar(Dibujable d) {
        if (this.d == null) {
            this.d = d;
        }
        repaint();
    }

    private Dibujable d = null;
}
