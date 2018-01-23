package proyecto_monitor_bd.vista;

import proyecto_monitor_bd.modelo.Idioma;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.TextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Ventana_info extends JFrame {
    public Ventana_info(String texto) {
        super(Idioma.var_08);
        panel = new JPanel();
        this.texto = texto;
        
        ajustarComponentes(getContentPane());
        setSize(new Dimension(500,195));
        setLocationRelativeTo(null);
        setResizable(false);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void ajustarComponentes(Container c) {
        panel.setLayout(new BorderLayout());
        TextArea campo_texto = new TextArea(texto);
        panel.add(BorderLayout.PAGE_START, campo_texto);//new JLabel(texto));
        //panel_agregar.setPreferredSize(new Dimension(800, altura_ventana));
        /*JScrollPane sp = new JScrollPane(panel_agregar,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        */c.add(BorderLayout.CENTER, panel);
    }

    public void init() {
        setVisible(true);
    }
    
    private final JPanel panel;
    private final String texto;
}