package interfaz;

import javax.swing.*;

public class SistemaMatricula {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null,
                "1) Registrar estudiante\n" +
                "2) Registrar curso\n" +
                "3) Matricular\n" +
                "4) Consultas\n" +
                "5) Salir");
        int opcion = 0;
        while(opcion!=5){
            opcion = Integer.parseInt(JOptionPane.showInputDialog("Que desea realizar"));

            switch(opcion){


                case 1:
                    JOptionPane.showMessageDialog(null, "Registrar estudiante");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Registrar curso");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Matricular");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Consultas");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo...");
                    System.exit(0);
                    break;
            }
        }
        System.out.println("Funciona");

    }
}
