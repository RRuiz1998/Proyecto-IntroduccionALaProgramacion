
package main;

import javax.swing.JOptionPane;

public class SistemasDeReservas {
    private int maxCupos = 30;
    private int reservas7pm = 0;
    private int reservas8pm = 0;
    private String[] reservas = new String[60]; 
    private int idCounter = 1;
    
    
    //Llama funciones que el usuario desea realizar
    public void gestion() {
        OUTER:
        while (true) {
            int option = Integer.parseInt(JOptionPane.showInputDialog("Has ingresado a la seccion de Registro:\n\nMenu:\n1. Agregar Estudiante\n2. Mostrar Clase\n3. Cancelar Inscripcion\n4. Volver\n\nIndique la accion que desea realziar: "));
            if  (!(option == 1 || option == 2 || option == 3 || option == 4)) {
                System.out.println("Por favor verifique la informacion introducida");
            } else {
                switch (option) {
                    case 1 -> registrarReserva(Integer.parseInt(JOptionPane.showInputDialog("Horarios disponibles:\n1. 7pm\n2. 8pm\n3. Volver\nIndica la opcion que te funciona mas: ")));
                    case 2 -> eliminarReserva(Integer.parseInt(JOptionPane.showInputDialog("Introduce el ID del empleado: ")));
                    case 3 -> mostrarReservas();
                    case 4 -> {break OUTER;}
            }
        }
        }
    }

    public String registrarReserva(int horario) {
        if (horario == 1 && reservas7pm < maxCupos) { 
            reservas[idCounter - 1] = "Reserva " + idCounter + " - 7pm";
            reservas7pm++;
            return "Reserva registrada con ID " + idCounter++;
        } else if (horario == 2 && reservas8pm < maxCupos) { 
            reservas[idCounter - 1] = "Reserva " + idCounter + " - 8pm";
            reservas8pm++;
            return "Reserva registrada con ID " + idCounter++;
        } else {
            return "No hay cupo disponible en ese horario.";
        }
    }

    public String eliminarReserva(int idReserva) {
        if (idReserva > 0 && idReserva < idCounter && reservas[idReserva - 1] != null) {
            String reserva = reservas[idReserva - 1];
            reservas[idReserva - 1] = null; 
            if (reserva.contains("7pm")) {
                reservas7pm--;
            } else {
                reservas8pm--;
            }
            return "Reserva " + idReserva + " eliminada.";
        } else {
            return "ID no encontrado.";
        }
    }

    public void mostrarReservas() {
        System.out.println("Reservas actuales:");
        for (String reserva : reservas) {
            if (reserva != null) {
                System.out.println(reserva);
            }
        }
        System.out.println("Total: " + reservas7pm + " en 7pm y " + reservas8pm + " en 8pm.");
    }
    
}
