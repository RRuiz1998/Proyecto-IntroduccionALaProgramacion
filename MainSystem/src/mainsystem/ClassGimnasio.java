
package mainsystem;

import javax.swing.JOptionPane;

public class ClassGimnasio {
    
    // Asignación de objetos donde se guardarán los datos
    private String tipoClase;      // Tipo de clase: Yoga o Baile
    private int espaciosOcupados;  
    private final int MAX_ESPACIOS = 30; 

    // Constructor, se comienza con 0 estudiantes
    public ClassGimnasio(String tipoClase) {
        this.tipoClase = tipoClase;
        this.espaciosOcupados = 0;  
    }
    
    //Llama acciones que el usuario desea realizar
    public void gestion() {
        OUTER:
        while (true) {
                    int option = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n1. Agregar Estudiante\n2. Mostrar Clase\n3. Cancelar Inscripcion\n4. Volver\n\nIndique la accion que desea realizar: "));
        if  (!(option == 1 || option == 2 || option == 3 || option == 4)) {
            System.out.println("Por favor verifique la informacion introducida");
        } else {
            switch (option) {
                case 1 -> agregarEstudiante();
                case 2 -> mostrarClase();
                case 3 -> eliminarEstudiante();
                case 4 -> {break OUTER;}
            }
        }
        }
    }
    
    
    // Clase para agregar un estudiante a la clase, si hay espacio disponible
    public boolean agregarEstudiante() {
        if (espaciosOcupados < MAX_ESPACIOS) {
            espaciosOcupados++;
            System.out.println("Estudiante agregado a la clase: " + tipoClase + ". Espacios utilizados: " + espaciosOcupados);
            return true;
        } else {
            System.out.println("No hay espacios disponibles en la clase: " + tipoClase);
            return false;
        }
    }
    // Clase para mostrar información de la clase
    public void mostrarClase() {
        System.out.println("Clase: " + tipoClase);
        System.out.println("Espacios ocupados: " + espaciosOcupados + "/" + MAX_ESPACIOS);
    }
    // Clase para cancelar la inscripción de un estudiante
    public boolean eliminarEstudiante() {
        if (espaciosOcupados > 0) {
            espaciosOcupados--;
            System.out.println("Estudiante eliminado de la clase de " + tipoClase + ". Espacios utilizados: " + espaciosOcupados);
            return true;
        } else {
            System.out.println("No hay estudiantes para eliminar en la clase: " + tipoClase);
            return false;
        }
    }
    // Getter para obtener el tipo de clase
    public String getTipoClase() {
        return tipoClase;
    }
    // Getter para obtener la cantidad de espacios ocupados
    public int getEspaciosOcupados() {
        return espaciosOcupados;
    }
}



