
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
        ArrayList<String> availableImax = new ArrayList<>();
        ArrayList<String> busyImax = new ArrayList<>();
        ArrayList<List<String>> reservedImax = new ArrayList<>();
        ArrayList<String> registeredIdsImax = new ArrayList<>();
        
        ArrayList<String> availableVip = new ArrayList<>();
        ArrayList<String> busyVip = new ArrayList<>();
        ArrayList<List<String>> reservedVip = new ArrayList<>();
        ArrayList<String> registeredIdsVip = new ArrayList<>();

        Theater imax = new Theater("30", "10am", "2pm", "Mufasa: El rey leon", "Demon Slayer: Kimetsu no Yaiba - Arco del Castillo infinito.", availableImax, busyImax, reservedImax, registeredIdsImax);
        Theater vip = new Theater("30", "10am", "2pm", "Sonic 3, La pelicula", "La Guerra de los Rohirrim", availableVip, busyVip, reservedVip, registeredIdsVip);
        
        //Inicializacion de la Salas de gimnasio
        ClassGimnasio gimnasio = new ClassGimnasio("gimnasio");
        
        //Inicializacion de la Salas de yoga, baile, bar
        SIstemasDeReservas yoga = new SIstemasDeReservas();
        SIstemasDeReservas baile = new SIstemasDeReservas();
        SIstemasDeReservas bar = new SIstemasDeReservas();

        

//        try {
            OUTER:
            while (true) {
                String managementOption = JOptionPane.showInputDialog("Bienvenido a al plaforma de gestion de actividades!!\nEsta herramienta nos funcionara para lograr realizar gestiones a nivel de sistemas. \nPor favor leer atentamente e introducir la informacion requerida para completar el proceso de manera satisfactoria \n\nMenu:\n1. Gestionar informacion de empleados\n2. Reservar actividades\n\nPor favor indica que gestion deseas realizar: ");
                if(managementOption == null) {
                    break;
                }
                if (!(managementOption.equals("1") || managementOption.equals("2") || managementOption.equals("3"))) {
                    System.out.println("Por favor verifique la informacion introducida");
                } else {
                    switch (managementOption) {
                        case "1" -> employeeData.gestion();
                        case "2" -> {
                            String bookingOption = JOptionPane.showInputDialog("Has ingresado a la seccion de reservaciones!\nEn esta seccion lograras localizar las diversas areas que nuestra empresa te brinda para realizar la reservacion que deseas\nPara facilidad agregamos un menu de ayuda para seleccionar la opcion que deseas\n\nMenu:\n1. Cine \n2. Gimnasio\n3. Yoga\n4. Baile\n5. Bar\n\nDigita cualquier otra tecla para salir\n\nIntroduzca a cual actividad desea ingresar: ");
                            if (bookingOption == null) {
                                break;
                            }
                            if (bookingOption.equals("1") || bookingOption.equals("2") || bookingOption.equals("3") || bookingOption.equals("4") || bookingOption.equals("5")) {
                                switch (bookingOption) {
                                    case "1" -> {
                                        String option = JOptionPane.showInputDialog("Has Accedido al Menu del Cine!\nPerfecto, ahora te encuentras en la seccion reservada para elegir tu sala de preferencia\nPor favor leer atentamente y compartir la informacion requerida para continuar\n\nOpciones disponibles:\n1. IMAX\n2. VIP\n\nDigita cualquier otra tecla para salir\n\nIndica la sala que deseas: ");
                                        if (option == null) {
                                            break;
                                        }
                                        switch (option) {
                                            case "1" -> imax.gestion(employeeData.register);
                                            case "2" -> vip.gestion(employeeData.register);
                                        }
                                    }
                                    case "2" -> gimnasio.gestion();
                                    case "3" -> yoga.gestion();
                                    case "4" -> baile.gestion();
                                    case "5" -> bar.gestion();
                                }
                            } 
                        }
                    }
                }
            }

            
//            
//        } catch (Exception e) {
//            System.out.println("Por favor verifique la informacion introducida"+ e);
//        }
        
        
        
        
        
        
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

