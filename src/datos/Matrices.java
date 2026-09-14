package datos;

import javax.swing.JOptionPane;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrices {

    public static void main(String[] args) {
        String[][] matrizEstudiantes = crearMatrizEstudiantes();
        String[][] matrizCursos = crearMatrizCursos();

        String[][] matrizMatricula = crearMatrizMatricula(matrizEstudiantes, matrizCursos);

        if (matrizEstudiantes != null) {
            mostrarMatriz("MATRIZ DE ESTUDIANTES", matrizEstudiantes, 155);
        }
        if (matrizCursos != null) {
            mostrarMatriz("MATRIZ DE CURSOS", matrizCursos, 20);
        }
        if (matrizMatricula != null) {
            mostrarMatriz("MATRIZ DE MATRÍCULA (ID + 10 Cursos posibles, Máx. 4 matriculados)", matrizMatricula, 150);
        }
    }

    public static String[][] crearMatrizEstudiantes() {
        String[][] matriz = new String[155][6];
        JOptionPane.showMessageDialog(null, "=== REGISTRO DE ESTUDIANTES ===");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos estudiantes desea registrar?:"));

        String[] estado = {"Activo (A)", "Inactivo (I)"};
        String[] programa = {"Ingeniería de Sistemas", "Ingeniería Industrial", "Ingeniería Mecánica"};


        for (int i = 0; i < cantidad && i < 155; i++) {
            matriz[i][0] = String.valueOf(i + 1);
            String identificacion = "";
            boolean idValido = false;

            while (!idValido) {
                identificacion = JOptionPane.showInputDialog("Estudiante " + (i + 1) + "\nIngrese la Identificación (solo números):");

                if (identificacion == null) {
                    identificacion = "No especificado";
                    break;
                }

                if (identificacion.matches("^[0-9]+$")) {
                    idValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: La identificación solo debe contener números y no puede estar vacía.", "Dato inválido", JOptionPane.ERROR_MESSAGE);
                }
            }

            matriz[i][1] = identificacion;
            String nombre = "";
            boolean nombreValido = false;

            while (!nombreValido) {
                nombre = JOptionPane.showInputDialog("Ingrese el Nombre Completo (solo letras):");


                if (nombre == null) {
                    nombre = "No especificado";
                    break;
                }


                if (esSoloTexto(nombre)) {
                    nombreValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: El nombre solo debe contener letras y no puede estar vacío.", "Dato inválido", JOptionPane.ERROR_MESSAGE);
                }
            }


            matriz[i][2] = nombre;

            String opciones = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el programa del estudiante:",
                    "Caja de Opciones",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    programa,
                    programa[0]
            );


            if (opciones != null) {
                matriz[i][3] = opciones;
                JOptionPane.showMessageDialog(null, "Usted seleccionó: " + opciones);
            } else {
                matriz[i][3] = "No especificado";
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
            }


            String correo = "";
            boolean correoValido = false;

            while (!correoValido) {
                correo = JOptionPane.showInputDialog("Estudiante " + (i + 1) + "\nIngrese el Correo (ej: usuario@dominio.com):");

                if (correo == null) {
                    correo = "No especificado";
                    break;
                }

                if (validarCorreo(correo)) {
                    correoValido = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Correo inválido. Asegúrese de incluir '@' y un dominio válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                }
            }
            matriz[i][4] = correo;

            String seleccion = (String) JOptionPane.showInputDialog(
                    null,
                    "Seleccione el estado del estudiante:",
                    "Caja de Opciones",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    estado,
                    estado[0]
            );


            if (seleccion != null) {
                matriz[i][5] = seleccion.substring(0, 1);
                JOptionPane.showMessageDialog(null, "Usted seleccionó: " + seleccion);
            } else {
                matriz[i][5] = "I";
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
            }
        }

        return matriz;
    }

    public static boolean validarCorreo(String correo) {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    public static boolean esSoloTexto(String texto) {
        return texto != null && !texto.trim().isEmpty() && texto.matches("^[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+$");
    }

    public static String[][] crearMatrizCursos() {
        String[][] matriz = new String[20][4];


        for (int i = 0; i < 20; i++) {
            matriz[i][0] = String.valueOf(i + 1);
            matriz[i][1] = "2026-1";
            matriz[i][2] = "0000";
            matriz[i][3] = "VACANTE";
        }

        JOptionPane.showMessageDialog(null, "=== REGISTRO DE CURSOS (Máx 10) ===");
        int cantidadCursos = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos cursos va a registrar (máximo 10)?:"));

        for (int i = 0; i < cantidadCursos && i < 10; i++) {

            matriz[i][2] = String.format("%04d", i + 1);
            JOptionPane.showMessageDialog(null, "Codigo Curso: " + matriz[i][2]);

            String nombreCurso = "";
            boolean nombreValido = false;

            while (!nombreValido) {
                nombreCurso = JOptionPane.showInputDialog("Curso " + (i + 1) + "\nIngrese el Nombre del Curso (solo texto):");


                if (nombreCurso == null) {
                    nombreCurso = "Curso No Especificado";
                    break;
                }


                if (esSoloTexto(nombreCurso)) {
                    nombreValido = true;

                } else {
                    JOptionPane.showMessageDialog(null, "Error: El nombre del curso solo debe contener letras y no puede estar vacío.", "Dato inválido", JOptionPane.ERROR_MESSAGE);
                }
            }


            matriz[i][3] = nombreCurso;
        }

        JOptionPane.showMessageDialog(null, "¡Registro de cursos finalizado con éxito!");
        return matriz;
    }

    public static String[][] crearMatrizMatricula(String[][] estudiantes, String[][] cursos) {
        String[][] matrizMatricula = new String[150][12];

        for (int i = 0; i < 150; i++) {
            matrizMatricula[i][0] = String.valueOf(i + 1);
            matrizMatricula[i][1] = "0000";
            for (int j = 2; j < 12; j++) {
                matrizMatricula[i][j] = "0000";
            }
        }

        JOptionPane.showMessageDialog(null, "=== PROCESO DE MATRÍCULA ===");

        String[] opcionesCursos = obtenerOpcionesCursos(cursos);

        if (opcionesCursos.length == 0) {
            JOptionPane.showMessageDialog(null, "No hay cursos disponibles para matricular.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return matrizMatricula;
        }

        int filaMatricula = 0;

        for (int i = 0; i < estudiantes.length && filaMatricula < 150; i++) {
            if (estudiantes[i][1] != null) {
                String idEstudiante = estudiantes[i][1];
                String nombreEstudiante = estudiantes[i][2];
                String estadoEstudiante = estudiantes[i][5];

                if ("A".equals(estadoEstudiante)) {

                    matrizMatricula[filaMatricula][1] = idEstudiante;

                    JOptionPane.showMessageDialog(null, "Estudiante ACTIVO encontrado:\nID: " + idEstudiante + "\nNombre: " + nombreEstudiante);

                    int cantMatricular = 0;
                    try {
                        String inputCant = JOptionPane.showInputDialog("Estudiante: " + nombreEstudiante + "\n¿Cuántos cursos desea matricular? (Máximo 4):");
                        if (inputCant != null) {
                            cantMatricular = Integer.parseInt(inputCant);
                        }
                    } catch (NumberFormatException _) {
                    }

                    if (cantMatricular > 4) {
                        cantMatricular = 4;
                        JOptionPane.showMessageDialog(null, "El máximo permitido es 4 cursos. Se ajustará a 4.");
                    } else if (cantMatricular < 0) {
                        cantMatricular = 0;
                    }

                    for (int c = 0; c < cantMatricular; c++) {
                        String cursoSeleccionado = (String) JOptionPane.showInputDialog(
                                null,
                                "Estudiante: " + nombreEstudiante + "\nSeleccione el curso #" + (c + 1) + ":",
                                "Caja de Opciones - Cursos",
                                JOptionPane.QUESTION_MESSAGE,
                                null,
                                opcionesCursos,
                                opcionesCursos[0]
                        );

                        if (cursoSeleccionado != null) {
                            String codigoCurso = cursoSeleccionado.split(" - ")[0];
                            matrizMatricula[filaMatricula][2 + c] = codigoCurso;
                        } else {
                            matrizMatricula[filaMatricula][2 + c] = "0000";
                        }
                    }

                    filaMatricula++;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "¡Proceso de matrícula finalizado con éxito!");
        return matrizMatricula;
    }

    public static String[] obtenerOpcionesCursos(String[][] matrizCursos) {
        int contador = 0;
        for (int i = 0; i < matrizCursos.length; i++) {
            if (matrizCursos[i][2] != null && !matrizCursos[i][2].equals("0000")) {
                contador++;
            }
        }

        String[] opciones = new String[contador];
        int index = 0;
        for (int i = 0; i < matrizCursos.length; i++) {
            if (matrizCursos[i][2] != null && !matrizCursos[i][2].equals("0000")) {
                opciones[index] = matrizCursos[i][2] + " - " + matrizCursos[i][3];
                index++;
            }
        }
        return opciones;
    }

    public static void mostrarMatriz(String titulo, String[][] matriz, int totalFilas) {
        StringBuilder sb = new StringBuilder();
        sb.append(titulo).append("\n\n");

        int contadorMostrados = 0;

        for (int i = 0; i < totalFilas && i < matriz.length; i++) {
            boolean filaValida = false;

            if (titulo.contains("CURSOS")) {
                if (matriz[i][2] != null && !matriz[i][2].equals("0000")) {
                    filaValida = true;
                }
            } else if (titulo.contains("MATRÍCULA")) {
                if (matriz[i][1] != null && !matriz[i][1].equals("0000")) {
                    filaValida = true;
                }
            } else {
                if (matriz[i][1] != null) {
                    filaValida = true;
                }
            }

            if (filaValida) {
                contadorMostrados++;
                sb.append("Registro ").append(contadorMostrados).append(": [ ");
                for (int j = 0; j < matriz[i].length; j++) {
                    sb.append(matriz[i][j]);
                    if (j < matriz[i].length - 1) {
                        sb.append(" | ");
                    }
                }
                sb.append(" ]\n");
            }
        }

        if (contadorMostrados == 0) {
            sb.append("No hay registros para mostrar.");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}