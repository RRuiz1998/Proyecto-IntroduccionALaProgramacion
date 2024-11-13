
package mainsystem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MainSystem {

    public static void main(String[] args) {
        
        //Inicializacion del sistema
        EmployeeData employeeData = new EmployeeData();
        employeeData.preloadedRegistry();
        
        //Inicializacion de las Salas de Cine (IMAX y VIP)
        ArrayList<String> available = new ArrayList<>();
        ArrayList<String> busy = new ArrayList<>();
        ArrayList<List<String>> reserved = new ArrayList<>();
        Theater imax = new Theater("30", "10am", "2pm", "Mufasa: El rey leon", "Demon Slayer: Kimetsu no Yaiba - Arco del Castillo infinito.", available, busy, reserved);
        Theater vip = new Theater("30", "10am", "2pm", "Sonic 3, La pelicula", "La Guerra de los Rohirrim", available, busy, reserved);
        
        //Inicializacion de la Salas de gimnasio
        ClassGimnasio gimnasio = new ClassGimnasio("gimnasio");
        
        //Inicializacion de la Salas de yoga, baile, bar
        SIstemasDeReservas yoga = new SIstemasDeReservas();
        SIstemasDeReservas baile = new SIstemasDeReservas();
        SIstemasDeReservas bar = new SIstemasDeReservas();

        

        try {
            OUTER:
            while (true) {
                int managementOption = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a al plaforma de gestion de actividades!! \n\nMenu:\n1. Gestionar informacion de empleados\n2. Reservar actividades\n\nPor favor indica que gestion deseas realizar: "));
                if (!(managementOption == 1 || managementOption == 2 || managementOption == 3)) {
                    System.out.println("Por favor verifique la informacion introducida");
                } else {
                    switch (managementOption) {
                        case 1 -> employeeData.gestion();
                        case 2 -> {
                            int bookingOption = Integer.parseInt(JOptionPane.showInputDialog("Has ingresado a la seccion de reservaciones!\n\nMenu:\n1. Cine \n2. Gimnasio\n3. Yoga\n4. Baile\n5. Bar\n6. Salir\n\nIntroduzca a cual actividad desea ingresar: "));
                            if (bookingOption < 1 || bookingOption > 6) {
                                System.out.println("Por favor verifique la informacion introducida");
                            } else {
                                switch (bookingOption) {
                                    case 1 -> {
                                        int option = Integer.parseInt(JOptionPane.showInputDialog("Has Accedido al Menu del Cine!\n\nOpciones disponibles:\n1. IMAX\n2. VIP\n3. Volver\n\nIndica la sala que deseas: "));
                                        switch (option) {
                                            case 1 -> imax.reservation(employeeData.register);
                                            case 2 -> vip.reservation(employeeData.register);
                                            default -> System.out.println("Verifica la informacion ingresada");
                                        }
                                    }
                                    case 2 -> gimnasio.gestion();
                                    case 3 -> yoga.gestion();
                                    case 4 -> baile.gestion();
                                    case 5 -> bar.gestion();
                                    case 6 -> {break OUTER;}
                                }
                            }
                        }
                    }
                }
            }

            
            
        } catch (Exception e) {
            System.out.println("Por favor verifique la informacion introducida"+ e);
        }
        
        
        
        
        
        
//        SIstemasDeReservas sistema = new SIstemasDeReservas();
//
//        System.out.println(sistema.registrarReserva(1));
//        System.out.println(sistema.registrarReserva(2));
//        System.out.println(sistema.registrarReserva(1));
//
//        System.out.println("\n--- Estado de reservas ---");
//        sistema.mostrarReservas();
//
//        System.out.println("\nEliminando la reserva con ID 2...");
//        System.out.println(sistema.eliminarReserva(2));
//
//        System.out.println("\n--- Estado actualizado ---");
//        sistema.mostrarReservas();
//        
//        
        
        
        
    
    }        
}   

