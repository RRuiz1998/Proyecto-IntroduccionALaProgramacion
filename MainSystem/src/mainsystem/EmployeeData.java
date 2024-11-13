
package mainsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmployeeData {
    
    ArrayList <ArrayList<String>> register = new ArrayList<>();
    

    
    //Registro precargado de informacion de empleados
    public void preloadedRegistry() {
        ArrayList<String> employee1 = new ArrayList();
        employee1.add("Richard Ruiz");
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
            int option = Integer.parseInt(JOptionPane.showInputDialog("Has ingresado a la gestion de empleados\n\nMenu:\n1. Agregar empleado \n2. Modificar informacion \n3. Remover empleado\n4. Volver\n\nSeleccione la opcion que desea realizar: "));
                switch (option) {
                    case 1 -> addEmployee();
                    case 2 -> modifyEmployeeName ();
                    case 3 -> removeEmployee();
                    case 4 -> {break OUTER;}
                    default -> System.out.println("Verifique la informacion");
                }
            
        }
    }
    
    //Agrega Empleados del sistema
    public void addEmployee() {
        EmployeeData dataSaver = new EmployeeData();
        register.add(dataSaver.registeringEmployee(addingName(), addingId()));
        System.out.println(register);
    }
    
    //Modifica la informacion del empleado
    public void modifyEmployeeName () {
        System.out.println("El ID de los empleados no es modificable");
        String inputId = JOptionPane.showInputDialog("Ingrese el ID del empleado: ");
        for (int i = 0; i < register.size(); i++) {
            String employeeId = register.get(i).get(1);
            if (inputId.equals(employeeId)) {
                String inputName = JOptionPane.showInputDialog("Ingrese el nombre correcto: ");
                register.get(i).set(0, inputName);
                System.out.println(register);
                break;
            }else{
                System.out.println("Dato no valido");
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
    

