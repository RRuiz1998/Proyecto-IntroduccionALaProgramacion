
package main;

import java.util.Vector;
import javax.swing.JOptionPane;

public class EmployeeData {
    
        
    Vector <Vector<String>> register = new Vector<>();
    
    
    //Registro precargado de informacion de empleados
    public void preloadedRegistry() {
        Vector<String> employee1 = new Vector();
        employee1.add("Richard Ruiz");
        employee1.add("000001");
        register.add(employee1);
        
        Vector<String> employee2 = new Vector();
        employee2.add("Santiago Zamora");
        employee2.add("000002");
        register.add(employee2);
        
        Vector<String> employee3 = new Vector();
        employee3.add("Edgar Monge");
        employee3.add("000003");
        register.add(employee3);
        
        Vector<String> employee4 = new Vector();
        employee4.add("Josafat Garcia");
        employee4.add("000004");
        register.add(employee4);
        
        System.out.println("Registro "+register+"\n");
    }
    
    //Gestion de Informacion de Empleados
    public void gestion() {
        OUTER:
        while (true) {
            String option = JOptionPane.showInputDialog("""
                                                        Has ingresado a la gestion de empleados
                                                        
                                                        En este apartado podras realiazar diversas funciones con la informacion de los empleados
                                                        Con el fin de facilitar el uso se te agrega el menu de opciones disponibles
                                                        
                                                        Menu:
                                                        1. Agregar empleado 
                                                        2. Modificar informacion 
                                                        3. Remover empleado
                                                        
                                                        Cualquier otra tecla para salir
                                                        
                                                        Seleccione la opcion que desea realizar: """);
            
            if (option == null || !(option.equals("1") || option.equals("2") || option.equals("3"))) {
                break;
            }
            switch (option) {
                case "1" -> addEmployee();
                case "2" -> modifyEmployeeName();
                case "3" -> removeEmployee();
            }
        }
    }
    
    //Agrega Empleados del sistema
    public void addEmployee() {
        Vector<String> newEmployeeSet = new Vector<>();
        
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
            String inputId = JOptionPane.showInputDialog("""
                                                         Has ingresado a la seccion de modificacion de informacion de empleados
                                                         
                                                         Importante:
                                                         El ID de los empleados no es modificable
                                                         Solo es permitido modificar el nombre
                                                         
                                                         Digite 0 para salir
                                                         
                                                         Por favor ingrese el ID del empleado al que se le realizaran los cambios requeridos: """);
            
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
    public Vector<String> registeringEmployee(String id, String name) {
        Vector <String> list = new Vector<>();
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
