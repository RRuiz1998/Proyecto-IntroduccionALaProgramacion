
package mainsystem;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Theater {
    
    String spots;
    String schecudleOne;
    String scheduleTwo;
    String movieOne;
    String movieTwo;
    ArrayList<String> availableSpots;
    ArrayList<String> busySpots;
    ArrayList<List<String>> reservedList;
    ArrayList<String> registeredIds;


    //Construtor
    public Theater(String spots, String schecudleOne, String scheduleTwo, String movieOne, String movieTwo, ArrayList<String> availableSpots, ArrayList<String> busySpots, ArrayList<List<String>> reservedList, ArrayList<String> registedIds) {
        this.spots = spots;
        this.schecudleOne = schecudleOne;
        this.scheduleTwo = scheduleTwo;
        this.movieOne = movieOne;
        this.movieTwo = movieTwo;
        this.availableSpots = availableSpots;
        this.busySpots = busySpots;
        this.reservedList = reservedList;
        this.registeredIds = registedIds;
    }

        
    //Llama funciones que el usuario desea
    public void gestion (ArrayList<ArrayList<String>> register) {
        while (true) {
            String option = JOptionPane.showInputDialog("""
                                                        Estas en el apartado especial para nuestras salas de cine. 
                                                        En esta seccion podras elegir que funcion deseas realizar
                                                        Para facilidad agregamos un menu de opciones disponibles
                                                        
                                                        Menu:
                                                        1. Crear una reservacion
                                                        2. Realizar una actualizacion a la configuraciones
                                                        
                                                        Digite cualquier otra tecla para salir
                                                        
                                                        introduzaca la opcion que deseas realizar: """);
            
            if (option == null || !(option.equals("1") || option.equals("2"))) {
                break;
            }
            switch (option) {
                case "1" -> this.reservation(register);
                case "2" -> this.updateSettings();
            }
        }
        

        
        
    }
        
    
    
    //Se crea solicitud para reserva de un spot en la sala de cine
    public void reservation(ArrayList <ArrayList<String>> register) {
        List <String> confirmedList = new ArrayList<>();
        this.view();
        
        String employeeId = JOptionPane.showInputDialog("Indique el ID del empleado: ");
        for (int i = 0; i < register.size(); i++) {
            if (register.get(i).contains(employeeId)) {
                String selectedSpot = JOptionPane.showInputDialog("Indique el spot que desea reservar: ");
                selectedSpot = selectedSpot.toUpperCase();
                if (availableSpots.contains(selectedSpot) && !(registeredIds.contains(employeeId))) {
                    busySpots.add(selectedSpot);
                    availableSpots.remove(selectedSpot);
                    confirmedList.add(register.get(i).get(0));
                    confirmedList.add(register.get(i).get(1));
                    confirmedList.add(selectedSpot);
                    reservedList.add(confirmedList);
                    registeredIds.add(employeeId);
                } 
            } 
        }
        System.out.println(this.reservedList);
        System.out.println("Spot Reservado: "+confirmedList+"\n");        
    }    

    
    //Modificador de opciones predeterminadas de las salas
    public void updateSettings() {
        OUTER:
        while (true){
           settingsView();

            String specificOption = JOptionPane.showInputDialog("""
                                                                Perfecto, estas en la seccion para la modificacion de configuraciones
                                                                En este segmento lograras localizar las distintas opciones que son disponibles de ajustar
                                                                
                                                                Indique cual opcion desea modificar: 
                                                                
                                                                1. Pelicula 1 
                                                                2. Pelicula 2 
                                                                3. Horario de inicio pelicula 1 
                                                                4. Horario de inicio pelicula 2 
                                                                5. Spots disponibles en sala
                                                                
                                                                Digita cualquier otra tecla para salir""");
            
            if (specificOption == null || !(specificOption.equals("1") || specificOption.equals("2") || specificOption.equals("3") || specificOption.equals("4") || specificOption.equals("5"))) {
                break;
            }
            
            switch (specificOption) {
                case "1" -> this.movieOne = JOptionPane.showInputDialog("Introduzca el titulo de la pelicula que sera transmitida en la primer jornada: ");
                case "2" -> this.movieTwo = JOptionPane.showInputDialog("Introduzca el titulo de la pelicula que sera transmitida en la segunda jornada: ");
                case "3" -> this.schecudleOne = JOptionPane.showInputDialog("Introduzca el nuevo horario para la primer jornada de peliculas: ");
                case "4" -> this.scheduleTwo = JOptionPane.showInputDialog("Introduzca el nuevo horario para la segunda jornada de peliculas: ");
                case "5" -> this.spots = JOptionPane.showInputDialog("Introduzca la cantidad de spots disponibles para la sala (Maximo 30)");
            }
            
            String endOption = JOptionPane.showInputDialog("""
                                                           Si desea realizar otra modificacion digite 1 
                                                           Digite cualquier otra tecla para salir""");
            
            if (endOption == null || endOption.equals("1")) {
                break;
            }
        }
    }
    
    //Settings view
    public void settingsView () {
        System.out.println("Titulo: "+this.movieOne+" (Sera transmitida en el horario "+this.schecudleOne+")");
        System.out.println("Titulo: "+this.movieTwo+" (Sera transmitida en el horario "+this.scheduleTwo+")");
        System.out.println("Inicio de primer tanta: "+this.schecudleOne);
        System.out.println("inicio de segunda tanta: "+this.scheduleTwo);
        System.out.println("Cantidad de spots disponible en sala "+this.spots);
        System.out.println("");
    }

        
    //Visualizacion de los spots de la sala (FASE 2)
    public void view() { 
        int columns = Integer.parseInt(this.spots)/5;
        String [][] arragement = new String [5][columns];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < columns; j++) {
                switch (i) {
                    case 0 -> arragement[i][j] = "A"+j;
                    case 1 -> arragement[i][j] = "B"+j;
                    case 2 -> arragement[i][j] = "C"+j;
                    case 3 -> arragement[i][j] = "D"+j;
                    case 4 -> arragement[i][j] = "E"+j;
                }
                String element = arragement[i][j];
                checker(element);
                
            }
            System.out.println("");
        }
        System.out.println("\nEspacios disponibles: "+this.availableSpots);
        System.out.println("Espacios ocupados: "+this.busySpots);
        
    }
    
    //Valida si el spot esta disponible o ocupado
    public void checker (String element) {
        if (!(this.busySpots.contains(element))) {
            if (!(this.availableSpots.contains(element))) {
                this.availableSpots.add(element);
            }
        } 
        if (this.availableSpots.contains(element)) {
            System.out.print("\u001B[32m"+element+" "); 
        }
        if (this.busySpots.contains(element)) {
            System.out.print("\u001B[37m"+element+" ");
        }
    }
}

    
    
