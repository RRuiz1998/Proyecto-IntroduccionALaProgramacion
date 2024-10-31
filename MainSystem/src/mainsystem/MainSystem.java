
package mainsystem;

public class MainSystem {


    public static void main(String[] args) {
        
        //Inicializacion del sistema
        EmployeeData adminEmployeeOption = new EmployeeData();
        adminEmployeeOption.preloadedRegistry();
        
        try {
            adminEmployeeOption.adminEmployeeInfo();
            
            
            
        } catch (Exception e) {
            System.out.println("Error"+ e);
        }
       
        
    }   
}
