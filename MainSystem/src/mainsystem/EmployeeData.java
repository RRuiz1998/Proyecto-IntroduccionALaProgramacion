
package mainsystem;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmployeeData {
    
    ArrayList <ArrayList<String>> register = new ArrayList<>();
    
    
    //Registro precargado de informacion de empleados
    public ArrayList preloadedRegistry() {
        ArrayList<String> employee1 = new ArrayList();
        employee1.add("Richard Ruiz");
        employee1.add("000001");
        register.add(employee1);
        
        ArrayList<String> employee2 = new ArrayList();
        employee2.add("Santiago Zamora");
        employee2.add("000002");
        register.add(employee2);
        
        ArrayList<String> employee3 = new ArrayList();
        employee3.add("Edgar MOnge");
        employee3.add("000003");
        register.add(employee3);
        
        ArrayList<String> employee4 = new ArrayList();
        employee4.add("Josafat Garcia");
        employee4.add("000004");
        register.add(employee4);
        
        return register;
    }
    
    //Nuevo registro de empleado
    public void adminEmployeeInfo(ArrayList register) {
        OUTER:
        while (true) {
            int EmployeeInfo = Integer.parseInt(JOptionPane.showInputDialog("Deseas realizar una gestion con la info de los empleados: 1.Si 2.No"));
            switch (EmployeeInfo) {
                case 2:
                    break OUTER;
                case 1:
                    EmployeeData dataSaver = new EmployeeData();
                    register.add(dataSaver.registeringEmployee(addingName(), addingId()));
                    System.out.println("Registro "+register);
                default:
            }
        }
    }
 
    public ArrayList<String> registeringEmployee(String id, String name) {
        ArrayList <String> list = new ArrayList<>();
        list.add(id);
        list.add(name);
        return list;
    }
 
    //Guarda el nombre del empleado
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
    

