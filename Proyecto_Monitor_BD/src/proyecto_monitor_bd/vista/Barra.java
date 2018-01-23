package proyecto_monitor_bd.vista;

import proyecto_monitor_bd.modelo.Idioma;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import proyecto_monitor_bd.control.Control;

public class Barra extends JMenuBar{

    public Barra(Control c) {
        controlador = c;
        ajustarComponentes();
    }

    private void ajustarComponentes() {
        menu_archivo = new JMenu();
        opcionSalir = new JMenuItem();
        modificar_max_permitido = new JMenuItem();
        menu_edicion = new JMenu();
        pestañaCreditos = new JMenu();
        opcionVerCreditos = new JMenuItem();

        // Menú archivo
        menu_archivo.setText(Idioma.var_02);

        opcionSalir.setText(Idioma.var_03);
        menu_archivo.add(new JSeparator());
        menu_archivo.add(opcionSalir);
        
        add(menu_archivo);
        
        // Menú edicion
        menu_edicion.setText(Idioma.var_04);
        
        modificar_max_permitido.setText(Idioma.var_05);
        menu_edicion.add(modificar_max_permitido);
        
        add(menu_edicion);

        // Menú Acerca
        pestañaCreditos.setText(Idioma.var_06);
 
        opcionVerCreditos.setText(Idioma.var_07);
        pestañaCreditos.add(opcionVerCreditos);
        
        add(pestañaCreditos);
        
        opcionSalir.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
        
        modificar_max_permitido.addActionListener((ActionEvent e) -> {
            controlador.abrir_ventana_modificar_max_permitido();
        });
        
        opcionVerCreditos.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                String s1 = Idioma.var_01;
                String s2 = "-Kevin Josué Morales Marín";
                String s3 = "-José Pablo Solano Morgan";
                String s4 = "-José Pablo Zamora Rodríguez";
                controlador.abrir_ventana_creditos(s1,s2,s3,s4);
            }
        });
    }
    
    private JMenuItem opcionSalir;
    private JMenuItem modificar_max_permitido;
    private JMenuItem opcionVerCreditos;
    private JMenu pestañaCreditos;
    private JMenu menu_archivo;
    private JMenu menu_edicion;
    private final Control controlador;
}
