package proyecto_monitor_bd.vista;

import proyecto_monitor_bd.modelo.Idioma;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import proyecto_monitor_bd.control.Control;

public class Ventana_modificar_max extends JFrame {
    public Ventana_modificar_max(Control controlador, int max_permitido) {
        super(Idioma.var_09);
        this.controlador = controlador;
        this.max_permitido = max_permitido;
        panel_agregar = new JPanel();
        
        ajustarComponentes(getContentPane());
        setSize(new Dimension(300,100));
        setResizable(false);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void ajustarComponentes(Container c) {
        panel_agregar.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        panel_agregar.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        gc.insets = new Insets(4, 4, 4, 4);
        gc.gridx = 0;
        gc.gridy = 1;
        boton_aceptar = new JButton(Idioma.var_10);
        panel_agregar.add(boton_aceptar, gc);
        gc.gridx = 0;
        gc.gridy = 0;
        panel_agregar.add(new JLabel(Idioma.var_11+" "), gc);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.weightx = 0.1;
        gc.fill = GridBagConstraints.HORIZONTAL;
        nuevo_max = new JTextField();
        nuevo_max.setText(""+max_permitido);
        panel_agregar.add(nuevo_max, gc);
        gc.gridx = 2;
        gc.gridy = 0;
        panel_agregar.add(new JLabel("%"), gc);
        c.add(BorderLayout.CENTER, panel_agregar);
        
        KeyListener cant_caracteres = new KeyListener() {
 
            @Override
            public void keyTyped(KeyEvent e) {
                JTextField campo = (JTextField) e.getSource();
                if (campo.getText().length() == 3)
                    e.consume();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                JTextField campo = (JTextField) e.getSource();
                validar(campo);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                JTextField campo = (JTextField) e.getSource();
                validar(campo);
            }
        };
        nuevo_max.addKeyListener(cant_caracteres);
        
        boton_aceptar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                modificar_max_permitido();
            }

        });
    }

    public void init() {
        setVisible(true);
    }
    
    public void validar(JTextField campo){
        String digitado = campo.getText();int numero;
        try{
            numero = Integer.parseInt(digitado);
            if(numero > 100)
                campo.setText("100");
            if(numero < 0)
                campo.setText(campo.getText().replaceFirst("-", ""));
        }catch(Exception ex){
            campo.setText("");
        }
    } 

    private void modificar_max_permitido(){
        int n = 100;
        try{
            n = Integer.parseUnsignedInt(nuevo_max.getText());
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
        controlador.modificar_max_permitido(n);
        this.dispose();
    }
    
    private final Control controlador;
    private final JPanel panel_agregar;
    private JTextField nuevo_max;
    private JButton boton_aceptar;
    private final int max_permitido;
}