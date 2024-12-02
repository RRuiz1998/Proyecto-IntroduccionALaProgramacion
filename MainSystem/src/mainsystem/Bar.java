
package main;

import java.util.Vector;
import javax.swing.JOptionPane;

public class Bar {
    
    Vector<Vector<String>> List = new Vector<>();
    Vector<String> bookedList = new Vector<>();

    public void gestion(Vector<Vector<String>> register) {
        OUTER:
        while (true) {
            String option = JOptionPane.showInputDialog("""
                                                        Has accedido a la opcion de Bar!
                                                        En esta seccion podras realizar diferentes funciones como por ejemplo crear reservaciones de bebidas para los empleados 
                                                        o realizar modificaciones a las reservas que estan cargadas en el sistema. 
                                                        Ademas, en el siguiente menu podras ver todos los pedidos existentes seleccionando la opcion correspondiente

                                                        Menu:
                                                        1. Reservacion de Bebida
                                                        2. Modificacion de reserva
                                                        3. Cancelar reserva
                                                        4. Listado de pedidos

                                                        Oprime cualquier otra tecla para volver al menu anterior

                                                        Ingresa la opcion deseada: """);
            
            if (option.equals("1") || option.equals("2") || option.equals("3") || option.equals("4")) {
                switch (option) {
                    case "1" ->
                        reservation(register);
                    case "2" ->
                        modification();
                    case "3" ->
                        delete();
                    case "4" ->
                        reservationList();
                }            
            } 
            break;
        }
    }

    public void reservation(Vector<Vector<String>> register) {
        Vector<String> reservationSet = new Vector<>();

        OUTER:
        while (true) {
            String option = JOptionPane.showInputDialog("""
                                                        Has accedido a la seccion de reservaciones!
                                                        Es esta seccion podras realizar reservaciones de bebidas a los empleados utilizando su ID de empleado. 
                                                        Recuerda que es importante configurar una hora de entrega de su pedido
                                                        
                                                        Por favor ingresa el ID del empleado: """);
            
            if (option == null) {
                break;
            }

            for (int i = 0; i < register.size(); i++) {

                if (register.get(i).contains(option) && !(bookedList.contains(register.get(i).get(1)))) {
                    String employeeName = register.get(i).get(0);
                    String employeeId = register.get(i).get(1);
                    reservationSet.add(employeeName);
                    reservationSet.add(employeeId);

                    String drink = JOptionPane.showInputDialog("""
                                                               En este menu podras ver todas las opciones disponibles de bebidas que los empleados pueden elegir.
                                                               Para facilidad se agrega un menu con las bebidas
                                                               
                                                               Menu:
                                                               1. Cafe normal
                                                               2. Capuchino
                                                               3. Capuchino con Vainilla
                                                               4. Chocolate
                                                               5. Moka
                                                               6. Te Chai
                                                               7. Cafe Frio
                                                               
                                                               Toca cualquier otra tecla para salir
                                                               
                                                               Indica la opcion que deseas seleccionar:""");

                    if (drink == null || !(drink.equals("1") || drink.equals("2") || drink.equals("3") || drink.equals("4") || drink.equals("5") || drink.equals("6") || drink.equals("7"))) {
                        break;
                    }
                    
                    String drinkOption = drinkSelection(drink);
                    reservationSet.add(drinkOption);
                    
                    String time = JOptionPane.showInputDialog("""
                                                              Genial!!
                                                              Estamos a un paso de finalizar. Ahora solo debes de seleccionar el momento del dia en donde se entregara la bebida.
                                                              
                                                              Menu:
                                                              1. Break
                                                              2. Lunch
                                                              3. Coffe Break
                                                              4. Leave
                                                              
                                                              Presionar cualquier otra tecla para salir
                                                              
                                                              Indica la opcion deseada: """);

                    if (time == null || !(time.equals("1") || time.equals("2") || time.equals("3") || time.equals("4"))) {
                        break;
                    }
                    
                    String selectedTime = timeSelection (time);
                    reservationSet.add(selectedTime);
                    
                    bookedList.add(employeeId);
                    List.add(reservationSet);
                    JOptionPane.showMessageDialog(null, "Se ha completado exitosamente la reservacion!!\n\n"
                            
                                                    + "Detalles: \n"
                                                    + "Nombre del empleado: "+employeeName+"\n"
                                                    + "ID de empleado: "+employeeId+"\n"
                                                    + "Bebida: "+drinkOption+"\n"
                                                    + "Hora de entrega: "+selectedTime);
                }
            }
            break;
        }
    }
    
    //Seleccion de la bebida deseada
    public String drinkSelection (String drink) {
        String drinkOption = null;
        switch (drink) {
            case "1" -> drinkOption = "Cafe normal";
            case "2" -> drinkOption = "Capuchino";
            case "3" -> drinkOption = "Capuchino con Vainilla";
            case "4" -> drinkOption = "Chocolate";
            case "5" -> drinkOption = "Moka";
            case "6" -> drinkOption = "Te Chai";
            case "7" -> drinkOption = "Cafe Frio";
        }
        return drinkOption;
    }
    
    //Seleccion de la hora de entrega
    public String timeSelection (String time) {
        String selectedTime = null;
        switch (time) {
            case "1" -> selectedTime = "Break";
            case "2" -> selectedTime = "Lunch";
            case "3" -> selectedTime = "Coffee Break";
            case "4" -> selectedTime = "Leave";

        }
        return selectedTime;
    }
    

    //Modifica las reservaciones existentes de bebidas
    public void modification() {
        OUTER:
        while (true) {
            String id = JOptionPane.showInputDialog("""
                                                    Bienvenido al menu de modificacion de reservaciones de bebidas!!
                                                    En este menu podras modificar tanto el momento de entrega de la bebida que el empleado selecciono o bien la bebida seleccionada
                                                    Primero, confirmemos el ID del empleado que desea realizar el cambio

                                                    Ingresa el ID del empleado: """);
            if (id == null) {
                break;
            }

            if (bookedList.contains(id)) {
                for (int i = 0; i < List.size(); i++) {
                    String option = JOptionPane.showInputDialog("""
                                                                Perfecto!! Ahora por favor indica cual opcion deseas modificar
                                                                
                                                                Menu:
                                                                1. Momento de entrega
                                                                2. Bebida seleccionada
                                                                
                                                                Toca cualquier otra tecla para salir
                                                                
                                                                Indica la opcion que deseas realizar: """);

                    if (option == null || !(option.equals("1") || option.equals("2"))) {
                        break OUTER;
                    }
                    switch (option) {
                        case "1" -> {
                            String time = JOptionPane.showInputDialog("""
                                                                    Indica el nuevo momento de entrega:

                                                                    Menu:
                                                                    1. Break
                                                                    2. Lunch
                                                                    3. Coffe Break
                                                                    4. Leave

                                                                    Oprime cualquier otra tecla para salir

                                                                    Indica la opcion deseada: """);

                            if (time == null || !(time.equals("1") || time.equals("2") || time.equals("3") || time.equals("4"))) {
                                break OUTER;
                            }
                            switch (time) {
                                case "1" -> List.get(i).set(3, "Break");
                                case "2" -> List.get(i).set(3, "Lunch");
                                case "3" -> List.get(i).set(3, "Coffe Break");
                                case "4" -> List.get(i).set(3, "Leave");
                            }
                        }

                        case "2" -> {
                            String drink = JOptionPane.showInputDialog("""
                                                                        En este menu podras cambiar la opcion de bebida que fue seleccionada previamente.
                                                                        Agregamos un menu para mostrar las opciones disponibles
                                                                        
                                                                        Menu:
                                                                        1. Cafe normal
                                                                        2. Capuchino
                                                                        3. Capuchino con Vainilla
                                                                        4. Chocolate
                                                                        5. Moka
                                                                        6. Te Chai
                                                                        7. Cafe Frio
                                                                       
                                                                        Toca cualquier otra tecla para salir
                                                                       
                                                                        Indica la opcion que deseas seleccionar:""");

                            if (drink == null || !(drink.contains("1") || drink.contains("2") || drink.contains("3") || drink.contains("4") || drink.contains("5") || drink.contains("6") || drink.contains("7"))) {
                                break;
                            }

                            switch (drink) {
                                case "1" -> List.get(i).set(2, "Cafe Normal");
                                case "2" -> List.get(i).set(2, "Capuchino");
                                case "3" -> List.get(i).set(2, "Capuchino con Vainilla");
                                case "4" -> List.get(i).set(2, "Chocolate");
                                case "5" -> List.get(i).set(2, "Moka");
                                case "6" -> List.get(i).set(2, "Te Chai");
                                case "7" -> List.get(i).set(2, "Cafe Frio");
                            }
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Se ha completado exitosamente su modificacion!!\n\n"

                                                        + "Detalles: \n"
                                                        + "Nombre del empleado: "+List.get(i).get(0)+"\n"
                                                        + "ID de empleado: "+List.get(i).get(1)+"\n"
                                                        + "Bebida: "+List.get(i).get(2)+"\n"
                                                        + "Hora de entrega: "+List.get(i).get(3));
                    ;
                }
                break;
            }
        }
    }

    //Remover pedidos
    public void delete() {
        OUTER:
        while (true) {
            String id = JOptionPane.showInputDialog("""
                                                    Has ingresado a la seccion para cancelar una reservacion de bebida
                                                    En esta seccion se necesitara ubicar al pedido realizado por el empleado utilizando su ID para lograr remover la reservacion correcta
                                                    
                                                    Si deseas salir presione Cancelar
                                                    
                                                    Por favor, ingrese el ID de empleado: """);
            if (id == null) {
                break;
            }

            if (bookedList.contains(id)) {
                for (int i = 0; i < List.size(); i++) {
                    if (List.get(i).get(1).equals(id)) {
                        List.remove(i);
                        bookedList.remove(i);
                        JOptionPane.showMessageDialog(null, "La reserva ha sido removida con exito");
                        break;
                    }
                }
                break;
            } else if (!(bookedList.contains(id))){
                JOptionPane.showMessageDialog(null, "Este ID no tiene reservaciones cargadas en el sistema");
            }
        }
    }

    //Listado de pedidos
    public void reservationList() {
        for (int i = 0; i < List.size(); i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(List.get(i).get(j) + " ");
            }
            System.out.println("");
        }
    }
}
