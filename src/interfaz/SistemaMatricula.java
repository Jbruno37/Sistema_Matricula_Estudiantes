package interfaz;

import logica.Funciones;
import javax.swing.*;

public class SistemaMatricula {
    public static void main(String[] args) {
        // Creamos el objeto de la capa lógica
        Funciones logica = new Funciones();

        int opcion = 0;
        while(opcion != 5){
            String input = JOptionPane.showInputDialog(null,
                    "=== SISTEMA DE MATRÍCULA ===\n" +
                            "1) Registrar estudiante\n" +
                            "2) Registrar curso\n" +
                            "3) Matricular\n" +
                            "4) Consultas\n" +
                            "5) Salir\n\n" +
                            "¿Qué desea realizar?");

            if (input == null) {
                opcion = 5;
                continue;
            }

            try {
                opcion = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                opcion = 0;
            }

            switch(opcion){
                case 1:
                    logica.gestionarRegistroEstudiantes();
                    break;
                case 2:
                    logica.gestionarRegistroCursos();
                    break;
                case 3:
                    logica.gestionarMatricula();
                    break;
                case 4:
                    String tipoConsultaStr = JOptionPane.showInputDialog(
                            "¿Qué desea consultar?\n" +
                                    "1) Estudiantes\n" +
                                    "2) Cursos\n" +
                                    "3) Matrículas");
                    if (tipoConsultaStr != null) {
                        int tipoConsulta = Integer.parseInt(tipoConsultaStr);
                        logica.gestionarConsultas(tipoConsulta);
                    }
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida.");
                    break;
            }
        }
    }
}