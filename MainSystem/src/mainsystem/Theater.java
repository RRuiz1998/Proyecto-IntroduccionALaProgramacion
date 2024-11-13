
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

    
    //Construtor
    public Theater(String spots, String schecudleOne, String scheduleTwo, String movieOne, String movieTwo, ArrayList<String> availableSpots, ArrayList<String> busySpots, ArrayList<List<String>> reservedList) {
        this.spots = spots;
        this.schecudleOne = schecudleOne;
        this.scheduleTwo = scheduleTwo;
        this.movieOne = movieOne;
        this.movieTwo = movieTwo;
        this.availableSpots = availableSpots;
        this.busySpots = busySpots;
        this.reservedList = reservedList;
    }
      
    
    //Llama funciones que el usuario desea
    public void gestion (ArrayList<ArrayList<String>> register) {
        this.reservation(register);
    }
        
    
    
    //Se crea solicitud para reserva de un spot en la sala IMAX
    public void reservation(ArrayList <ArrayList<String>> register) {
        this.view();
        OUTER:
        while (true) {
        String bookingOption = JOptionPane.showInputDialog("Indique el spot a reservar: ");         
            for (int i = 0; i < this.availableSpots.size(); i++) {
            if (bookingOption.equalsIgnoreCase(this.availableSpots.get(i)) ) {
                String selectedSpot = this.availableSpots.get(i);
                this.busySpots.add(this.availableSpots.get(i));
                this.availableSpots.remove(this.availableSpots.get(i)); 

                while (true) {
                    String confirmedId = this.confirmingRequest(register, selectedSpot);
                    if (confirmedId != ""){
                        break;
                    } 
                }
            }
            } 
            break;
        }
    }

      
  
        
    //Se confirma los datos de entrada y se asigna spot al empleado solicitante
    public String confirmingRequest (ArrayList<ArrayList<String>> register, String selectedSpot) {
        List <String> confirmedList= new ArrayList<>();
        
        String employeeId = JOptionPane.showInputDialog("Ingrese el ID del empleado: ");
        String confirmedId = "";
        
        int inicializador = this.reservedList.size();
        if (this.reservedList.isEmpty()) {
            inicializador = 0;
        }
        
        for (int index = 0; index <= inicializador; index++) {
            
            if (this.reservedList.isEmpty() || !(this.reservedList.get(index).contains(employeeId))) {
                for (int i = 0; i < register.size(); i++) {
                    if (register.get(i).get(1).equalsIgnoreCase(employeeId)) {
                        confirmedList.add(register.get(i).get(1));
                        confirmedList.add(register.get(i).get(0));
                        confirmedList.add(selectedSpot);
                        confirmedId = register.get(i).get(1);
                        this.reservedList.add(confirmedList);
                    }
                }
            } else {

            }
        }
        System.out.println(this.reservedList+"\n");
        return confirmedId;
    };
    
    //Modificador de opciones predeterminadas de las salas
    public void updateSettings() {
        OUTER:
        while (true){
            int specificOption = Integer.parseInt(JOptionPane.showInputDialog("Indique cual opcion desea modificar: \n1. Nombre de sala \n2. Horario de inicio pelicula 1 \n3. Horario de inicio pelicula 2 \n4. Pelicula 1 \n5. Pelicula 2 \n6. Salir"));
            switch (specificOption) {
                case 1 -> this.spots = JOptionPane.showInputDialog("Introduzca la cantidad de spots disponibles para la sala (Maximo 30)");
                case 2 -> this.schecudleOne = JOptionPane.showInputDialog("Introduzca el nuevo horario para la primer jornada de peliculas: ");
                case 3 -> this.scheduleTwo = JOptionPane.showInputDialog("Introduzca el nuevo horario para la segunda jornada de peliculas: ");
                case 4 -> this.movieOne = JOptionPane.showInputDialog("Introduzca el titulo de la pelicula que sera transmitida en la primer jornada: ");
                case 5 -> this.movieTwo = JOptionPane.showInputDialog("Introduzca el titulo de la pelicula que sera transmitida en la segunda jornada: ");
                case 6 -> {break OUTER;}
            }
            if (specificOption > 0 && specificOption < 6){
                int endOption = Integer.parseInt(JOptionPane.showInputDialog("Desea realizar otra modificacion? \n1. Si \n2. No"));
                if (endOption == 2) {
                    break;
            }
            }
        }
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

    
    
