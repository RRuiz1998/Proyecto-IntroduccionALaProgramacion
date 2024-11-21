
package mainsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmployeeData {
    
    ArrayList <ArrayList<String>> register = new ArrayList<>();
    

    
    //Registro precargado de informacion de empleados
    public void preloadedRegistry() {
        ArrayList<String> employee1 = new ArrayList();
        employee1.add("Tracy Ruiz");
        employee1.add("000001");
        register.add(employee1);
        
        ArrayList<String> employee2 = new ArrayList();
        employee2.add("Santiago Zamora");
        employee2.add("000002");
        register.add(employee2);
        
        ArrayList<String> employee3 = new ArrayList();
        employee3.add("Edgar Monge");
        employee3.add("000003");
        register.add(employee3);
        
        ArrayList<String> employee4 = new ArrayList();
        employee4.add("Josafat Garcia");
        employee4.add("000004");
        register.add(employee4);
        
        System.out.println("Registro "+register+"\n");
    }
    
    //Gestion de Informacion de Empleados
    public void gestion() {
        OUTER:
        while (true) {
            String option = JOptionPane.showInputDialog("Has ingresado a la gestion de empleados\n\nEn este apartado podras realiazar diversas funciones con la informacion de los empleados\nCon el fin de facilitar el uso se te agrega el menu de opciones disponibles\n\nMenu:\n1. Agregar empleado \n2. Modificar informacion \n3. Remover empleado\n\nCualquier otra tecla para salir\n\nSeleccione la opcion que desea realizar: ");
            if (option == null) {
                break;
            }
            switch (option) {
                case "1" -> addEmployee();
                case "2" -> modifyEmployeeName ();
                case "3" -> removeEmployee();
                default -> {break OUTER;}
            }
        }
    }
    
    //Agrega Empleados del sistema
    public void addEmployee() {
        ArrayList<String> newEmployeeSet = new ArrayList<>();
        
        String name = addingName();
        String id = addingId();
        if (!(name == null)) {
            newEmployeeSet.add(name);
            newEmployeeSet.add(id);
            register.add(newEmployeeSet);  //set de informacion del empleado nuevo registrada en el sistema
        }        
        System.out.println(register);
    }
    
    //Modifica la informacion del empleado
    public void modifyEmployeeName () {
        while (true) {
            String inputId = JOptionPane.showInputDialog("Has ingresado a la seccion de modificacion de informacion de empleados\n\nImportante:\nEl ID de los empleados no es modificable\nSolo es permitido modificar el nombre\n\nDigite 0 para salir\n\nPor favor ingrese el ID del empleado al que se le realizaran los cambios requeridos: ");
            if (inputId == null || !(inputId.equals("0"))) {
                if (!(inputId == null)){
                    for (int i = 0; i < register.size(); i++) {
                        String employeeId = register.get(i).get(1);
                        if (inputId.equals(employeeId)) {
                            String inputName = JOptionPane.showInputDialog("Ingrese el nombre correcto: ");
                            register.get(i).set(0, inputName);
                            System.out.println(register);
                            break;
                        }
                    }
                    System.out.println("El ID ingresado no se encuentra en la base de datos");
                } else {
                    break;
                }
            } else {
                break;
            }
        
        }
    }
    
    //Remueve Empleados del Sistema
    public void removeEmployee() {
        String name = JOptionPane.showInputDialog("Indique el nombre del empleado a remover: ");
        for (int i = 0; i < register.size(); i++) {
            String element = register.get(i).get(0);
            if (element.equalsIgnoreCase(name)) {
                register.remove(register.get(i));
                System.out.println(register);
                break;
            }
        }
    }
    
    //Une Nombre de Empleado con ID
    public ArrayList<String> registeringEmployee(String id, String name) {
        ArrayList <String> list = new ArrayList<>();
        list.add(id);
        list.add(name);
        return list;
    }
 
    //Guarda el Nombre del Empleado
    public String addingName(){
        String registeredName = JOptionPane.showInputDialog("Introduzca el nombre del empleado: ");
        return registeredName;
    }
    
    //Generate unique ID 
    public String addingId() {
        int randomNumber = (int)(Math.random()* 999999)+1;
        return String.valueOf(randomNumber);
    }
}
    

