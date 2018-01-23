package proyecto_monitor_bd.vista;

import proyecto_monitor_bd.modelo.Idioma;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class VentanaEmergente extends JFrame {

    public VentanaEmergente(String mensaje) {
        super(Idioma.var_08);

        etqAdicional1 = null;
        etqAdicional2 = null;
        etqAdicional3 = null;
        
        ajustarComponentes(getContentPane(),mensaje);
        setSize(new Dimension(272, 90));
        setResizable(false);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public VentanaEmergente(String m1, String m2, String m3, String m4) {
        super(Idioma.var_07);
        
        etqAdicional1 = new JLabel(m2);
        etqAdicional2 = new JLabel(m3);
        etqAdicional3 = new JLabel(m4);
        
        ajustarComponentes(getContentPane(),m1);
        setSize(new Dimension(272, 123));
        setResizable(false);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void ajustarComponentes(Container c, String mensaje) {
        c.setLayout(new FlowLayout(FlowLayout.CENTER));
        Box pPrincipal = Box.createVerticalBox();
        pPrincipal.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        etqInfo = new JLabel(mensaje);
        pPrincipal.add(etqInfo);
        if(etqAdicional1 != null){
            pPrincipal.add(Box.createVerticalStrut(6));
            pPrincipal.add(etqAdicional1);
        }
        if(etqAdicional2 != null)
            pPrincipal.add(etqAdicional2);
        if(etqAdicional3 != null)
            pPrincipal.add(etqAdicional3);
        c.add(pPrincipal);
    }

    public void init(Component c) {
        setLocationRelativeTo(c);
        setVisible(true);
    }

    private JLabel etqInfo;
    private final JLabel etqAdicional1;
    private final JLabel etqAdicional2;
    private final JLabel etqAdicional3;
}