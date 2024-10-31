
package mainsystem;

public class MainSystem {


    public static void main(String[] args) {
        
        try {
            EmployeeData adminEmployeeOption = new EmployeeData();
            adminEmployeeOption.adminEmployeeInfo(adminEmployeeOption.preloadedRegistry());
        } catch (Exception e) {
            System.out.println("Error"+ e);
        }
       
        
    }   
}
