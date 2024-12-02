
package main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Activities extends JFrame implements ActionListener {
    
    JLabel etiqueta1, etiqueta2, etiqueta3, etiqueta4;
    JButton b1, b2;
    
        public Activities(){
            
            super("Activities");
            
            setLayout(new FlowLayout());
            
            etiqueta1 = new JLabel("""
                                  Bienvenido a la plataforma de gestion de actividades!!
                                  """);
            
            etiqueta2 = new JLabel("""
                                  Esta herramienta nos funcionara para lograr realizar gestiones a nivel de sistemas. 
                                  """);
            etiqueta3 = new JLabel("""
                                  Por favor leer atentamente e introducir la informacion requerida para completar el proceso de manera satisfactoria 
                                  """);
            etiqueta4 = new JLabel("Menu: ");
            
            
            b1 = new JButton("Gestionar informacion de empleados");
            b1.addActionListener(this);
            
            b2 = new JButton("Gestionar actividades");
            b2.addActionListener(this);
            
            add(etiqueta1);
            add(etiqueta2);
            add(etiqueta3);
            add(etiqueta4);
            add(b1);
            add(b2);

            
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Inicializacion del sistema
        EmployeeData employeeData = new EmployeeData();
        employeeData.preloadedRegistry();
        
                 
        //Inicializacion de las Salas de Cine (IMAX y VIP)
        
        
        Vector<String> availableImax = new Vector<>();
        
        Vector<String> busyImax = new Vector<>();
        Vector<Vector<String>> reservedImax = new Vector<>();
        Vector<String> registeredIdsImax = new Vector<>();

        Vector<String> availableVip = new Vector<>();
        Vector<String> busyVip = new Vector<>();
        Vector<Vector<String>> reservedVip = new Vector<>();
        Vector<String> registeredIdsVip = new Vector<>();
        
                
        //Inicializacion de la Salas de gimnasio
        ClassGimnasio gimnasio = new ClassGimnasio("gimnasio");
        
        //Inicializacion de la Salas de yoga, baile
        SistemasDeReservas yoga = new SistemasDeReservas();
        SistemasDeReservas baile = new SistemasDeReservas();

        //Inicializacion de Bar
        Bar bar = new Bar();

        Theater imax = new Theater("30", "10am", "2pm", "Mufasa: El rey leon", "Demon Slayer: Kimetsu no Yaiba - Arco del Castillo infinito.", availableImax, busyImax, reservedImax, registeredIdsImax);
        Theater vip = new Theater("30", "10am", "2pm", "Sonic 3, La pelicula", "La Guerra de los Rohirrim", availableVip, busyVip, reservedVip, registeredIdsVip);

        
        if (e.getSource() == b1) {
            employeeData.gestion();
        }
        if (e.getSource() == b2){
   
            OUTER:
            while (true) {
                String bookingOption = JOptionPane.showInputDialog("""
                                                                   Has ingresado a la seccion de reservaciones!
                                                                   En esta seccion lograras localizar las diversas areas que nuestra empresa te brinda para realizar la reservacion que deseas
                                                                   Para facilidad agregamos un menu de ayuda para seleccionar la opcion que deseas

                                                                   Menu:
                                                                   1. Cine 
                                                                   2. Gimnasio
                                                                   3. Yoga
                                                                   4. Baile
                                                                   5. Bar

                                                                   Digita cualquier otra tecla para salir

                                                                   Introduzca a cual actividad desea ingresar: """);

                if (bookingOption == null || !(bookingOption.equals("1") || bookingOption.equals("2") || bookingOption.equals("3") || bookingOption.equals("4") || bookingOption.equals("5"))) {
                    break;
                }
                if (bookingOption.equals("1") || bookingOption.equals("2") || bookingOption.equals("3") || bookingOption.equals("4") || bookingOption.equals("5")) {
                    activitiesOptions(bookingOption, employeeData, imax, vip, gimnasio, yoga, baile, bar);

                } 
            }
    
     
    
    

        }

            
            
        }
    
    
        public void activitiesOptions (String bookingOption, EmployeeData employeeData,Theater imax, Theater vip, ClassGimnasio gimnasio, SistemasDeReservas yoga, SistemasDeReservas baile, Bar bar) {
        OUTER:
        while (true) {
            switch (bookingOption) {
                case "1" -> {
                    String option = JOptionPane.showInputDialog("""
                                                                Has Accedido al Menu del Cine!
                                                                Perfecto, ahora te encuentras en la seccion reservada para elegir tu sala de preferencia
                                                                Por favor leer atentamente y compartir la informacion requerida para continuar
                                                                
                                                                Opciones disponibles:
                                                                1. IMAX
                                                                2. VIP
                                                                
                                                                Digita cualquier otra tecla para salir
                                                                
                                                                Indica la sala que deseas: """);

                    if (option == null || !(option.equals("1") || option.equals("2"))) {
                        break OUTER;
                    }
                    switch (option) {
                        case "1" -> imax.gestion(employeeData.register);
                        case "2" -> vip.gestion(employeeData.register);
                    }
                }
                case "2" -> gimnasio.gestion();
                case "3" -> yoga.gestion();
                case "4" -> baile.gestion();
                case "5" -> bar.gestion(employeeData.register);
            }
            break;
        }
    }
    
}
