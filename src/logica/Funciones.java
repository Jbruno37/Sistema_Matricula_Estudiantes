package logica;

import datos.Matrices;

public class Funciones {


    private String[][] matrizEstudiantes;
    private String[][] matrizCursos;
    private String[][] matrizMatricula;


    public void gestionarRegistroEstudiantes() {
        this.matrizEstudiantes = Matrices.crearMatrizEstudiantes();
    }

    public void gestionarRegistroCursos() {
        this.matrizCursos = Matrices.crearMatrizCursos();
    }

    public void gestionarMatricula() {
        if (matrizEstudiantes == null || matrizCursos == null) {
            javax.swing.JOptionPane.showMessageDialog(null,
                    "Debe registrar primero los estudiantes y los cursos antes de matricular.",
                    "Advertencia", javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }
        this.matrizMatricula = Matrices.crearMatrizMatricula(matrizEstudiantes, matrizCursos);
    }

    public void gestionarConsultas(int tipoConsulta) {
        switch (tipoConsulta) {
            case 1:
                if (matrizEstudiantes != null) {
                    Matrices.mostrarMatriz("MATRIZ DE ESTUDIANTES", matrizEstudiantes, 155);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
                }
                break;
            case 2:
                if (matrizCursos != null) {
                    Matrices.mostrarMatriz("MATRIZ DE CURSOS", matrizCursos, 20);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "No hay cursos registrados.");
                }
                break;
            case 3:
                if (matrizMatricula != null) {
                    Matrices.mostrarMatriz("MATRIZ DE MATRÍCULA", matrizMatricula, 150);
                } else {
                    javax.swing.JOptionPane.showMessageDialog(null, "No hay matrículas registradas.");
                }
                break;
            default:
                javax.swing.JOptionPane.showMessageDialog(null, "Opción de consulta no válida.");
                break;
        }
    }
}